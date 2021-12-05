import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class First {
  public static int fromBinary(String num) {
    int power = num.length() - 1;
    int sum = 0;

    for (int i = 0; i < num.length(); i++) {
      if (num.charAt(i) == '1') {
        sum += Math.pow(2, power) ;
      }

      power--;
    }

    return sum;
  }
  public static void main(String[] args) throws Exception {
    var fileBuffer = new BufferedReader(new FileReader("input.txt"));
    String line;
    final int LINE_LENGTH = 12;
    int[][] counters = new int[LINE_LENGTH][2];

    for (int i = 0; i < counters.length; i++) {
      counters[i][0] = 0;
      counters[i][1] = 0;
    }

    while ((line = fileBuffer.readLine()) != null) {
      for (int i = 0; i < counters.length; i++) {
        if (line.charAt(i) == '0') {
          counters[i][0] += 1;
        } else {
          counters[i][1] += 1;
        }
      }
    }
    
    String gammaRate = Arrays.stream(counters)
                     .map(count -> (count[0] > count[1]) ? '0' : '1')
                     .map(Object::toString)
                     .collect(Collectors.joining());
    String epsilonRate = gammaRate.replace('0', '2').replace('1', '0').replace('2', '1');

    System.out.println(fromBinary(gammaRate) * fromBinary(epsilonRate));
  }
}