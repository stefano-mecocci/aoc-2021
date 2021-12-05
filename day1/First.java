import java.io.BufferedReader;
import java.io.FileReader;

public class First {
  public static void main(String[] args) throws Exception {
    var fileBuffer = new BufferedReader(new FileReader("input.txt"));
    String line;
    int before = -1;
    int after = -1;
    int count = 0;

    while ((line = fileBuffer.readLine()) != null) {
      if (after == -1) {
        after = Integer.parseInt(line);
      } else {
        before = after;
        after = Integer.parseInt(line);

        if (after > before) {
          count++;
        }
      }
    }

    System.out.println(count);
  }
}