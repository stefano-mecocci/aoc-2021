public class Cell {
  private int val;
  private boolean mark = false;

  public Cell(int val) { this.val = val; }

  public void checkMarked() { this.mark = true; }

  public boolean isMarked() { return this.mark; }

  public void setVal(int val) { this.val = val; }

  public int getVal() {
    return this.val;
  }
}
