import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class First {
  public static ArrayList<Integer> readWinningNums(BufferedReader br)
      throws IOException {
    String line = br.readLine();
    String[] numbers = line.split(",");
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 0; i < numbers.length; i++) {
      result.add(Integer.parseInt(numbers[i]));
    }

    return result;
  }

  public static ArrayList<Board> readBoards(BufferedReader br)
      throws IOException {
    ArrayList<Board> result = new ArrayList<>();
    String line = "";

    while (line != null) {
      line = br.readLine();

      if (line != null && line.equals("")) {
        Board tmpBoard = new Board();

        for (int i = 0; i < Board.SIZE; i++) {
          line = br.readLine();
          tmpBoard.setRow(line, i);
        }

        result.add(tmpBoard);
      }
    }

    return result;
  }

  public static void main(String[] args) throws Exception {
    var fileBuffer = new BufferedReader(new FileReader("input.txt"));
    var winningNums = readWinningNums(fileBuffer);
    var boards = readBoards(fileBuffer);

    boolean win = false;
    Board winningBoard = null;
    int lastWinningNum = -1;

    for (int i = 0; !win && i < winningNums.size(); i++) {
      for (int j = 0; !win && j < boards.size(); j++) {
        boards.get(j).checkNumber(winningNums.get(i));

        if (boards.get(j).checkWin()) {
          win = true;
          winningBoard = boards.get(j);
          lastWinningNum = winningNums.get(i);
        }
      }
    }

    int unmarkedSum = winningBoard.getUnmarkedSum();

    System.out.println("\n" + (unmarkedSum * lastWinningNum));

    fileBuffer.close();
  }
}