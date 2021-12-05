import java.io.BufferedReader;
import java.io.FileReader;

public class First {
  public static void main(String[] args) throws Exception {
    var fileBuffer = new BufferedReader(new FileReader("input.txt"));
    String line;
    String[] pieces;

    int forward = 0;
    int height = 0;

    while ((line = fileBuffer.readLine()) != null) {
      pieces = line.split(" ");
      
      if (pieces[0].equals("forward")) {
        forward += Integer.parseInt(pieces[1]);
      } else if (pieces[0].equals("up")) {
        height -= Integer.parseInt(pieces[1]);
      } else {
        height += Integer.parseInt(pieces[1]);
      }
    }

    System.out.println(height * forward);
  }
}