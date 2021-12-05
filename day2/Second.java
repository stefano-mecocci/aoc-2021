import java.io.BufferedReader;
import java.io.FileReader;

public class Second {
  public static void main(String[] args) throws Exception {
    var fileBuffer = new BufferedReader(new FileReader("input.txt"));
    String line;
    String[] pieces;

    int forward = 0;
    int depth = 0;
    int aim = 0;

    int num;

    while ((line = fileBuffer.readLine()) != null) {
      pieces = line.split(" ");
      num = Integer.parseInt(pieces[1]);

      if (pieces[0].equals("forward")) {
        forward += num;
        depth += num * aim;
      } else if (pieces[0].equals("up")) {
        aim -= num;
      } else {
        aim += num;
      }
    }

    System.out.println(depth * forward);
  }
}
