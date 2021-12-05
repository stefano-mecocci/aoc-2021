import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Second {
  public static void main(String[] args) throws Exception {
    var fileBuffer = new BufferedReader(new FileReader("input.txt"));
    String line = fileBuffer.readLine();
    List<Integer> sums = new ArrayList<>();
    int i = 1;
    int[] tmpSums = new int[4];

    while (line != null) {
      for (int j = 0; j < 4; j++) {
        if (i > j) {
          if ((i - j) % 4 == 0) {
            sums.add(tmpSums[j]);
            tmpSums[j] = 0;
          } else {
            tmpSums[j] += Integer.parseInt(line);
          }
        }
      }

      i++;
      line = fileBuffer.readLine();
    }

    sums.add(tmpSums[3]);

    int before = -1;
    int after = -1;
    int count = 0;

    for (int sum : sums) {
      if (after == -1) {
        after = sum;
      } else {
        before = after;
        after = sum;
      }

      if (after > before) {
        count++;
      }
    }

    System.out.println(count);
  }
}
