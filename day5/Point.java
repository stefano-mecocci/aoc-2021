public class Point {
  public int x;
  public int y;

  public static Point fromString(String s) {
    String[] coords = s.split(",");
    Point p = new Point();

    p.x = Integer.parseInt(coords[0]);
    p.y = Integer.parseInt(coords[1]);

    return p;
  }
}
