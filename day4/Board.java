public class Board {
  private Cell[][] board;
  public final static int SIZE = 5;

  public Board() { this.board = new Cell[SIZE][SIZE]; }

  public void setCell(int x, int y, int val) {
    this.board[x][y] = new Cell(val);
  }

  public void setRow(String row, int lineNum) {
    String[] rawNums = row.trim().split("\\s+");

    for (int i = 0; i < rawNums.length; i++) {
      this.setCell(lineNum, i, Integer.parseInt(rawNums[i]));
    }
  }

  public void checkNumber(int num) {
    for (int i = 0; i < Board.SIZE; i++) {
      for (int j = 0; j < Board.SIZE; j++) {
        if (this.board[i][j].getVal() == num) {
          this.board[i][j].checkMarked();
        }
      }
    }
  }

  public boolean checkWin() {
    boolean[] columns = new boolean[Board.SIZE];
    boolean[] rows = new boolean[Board.SIZE];
    boolean result = false;

    for (int i = 0; i < Board.SIZE; i++) {
      columns[i] = true;
      rows[i] = true;
    }

    for (int i = 0; i < Board.SIZE; i++) {
      for (int j = 0; j < Board.SIZE; j++) {
        rows[i] = rows[i] && this.board[i][j].isMarked();
        columns[i] = columns[i] && this.board[j][i].isMarked();
      }
    }

    for (int i = 0; i < Board.SIZE; i++) {
      result = result || rows[i] || columns[i];
    }

    return result;
  }

  public int getUnmarkedSum() {
    int result = 0;

    for (int i = 0; i < Board.SIZE; i++) {
      for (int j = 0; j < Board.SIZE; j++) {
        if (!this.board[i][j].isMarked()) {
          result += this.board[i][j].getVal();
        }
      }
    }

    return result;
  }

  public void printBoard() {
    for (int i = 0; i < Board.SIZE; i++) {
      for (int j = 0; j < Board.SIZE; j++) {
        System.out.print(this.board[i][j].getVal() + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
