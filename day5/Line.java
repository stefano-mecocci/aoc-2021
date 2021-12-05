public class Line {
  private Point from;
  private Point to;
  private Point[] points;

  public void setFrom(Point from) { this.from = from; }

  public Point getFrom() { return from; }

  public Point getTo() { return to; }

  public void setTo(Point to) { this.to = to; }

  public boolean isDiagonal() {
    return !(this.hasSameX() || this.hasSameY());
  }

  public boolean hasSameX() {
    return from.x == to.x;
  }

  public boolean hasSameY() {
    return from.y == to.y;
  }

  private void generatePointsForY() {
    int start = from.y;
    points = new Point[to.y - from.y + 1];

    for (int i = 0; i < points.length; i++) {
      points[i] = new Point();
      points[i].y = start;
      points[i].x = from.x;

      start++;
    }
  }

  private void generatePointsForX() {
    int start = from.x;
    points = new Point[to.x - from.x + 1];

    for (int i = 0; i < points.length; i++) {
      points[i] = new Point();
      points[i].x = start;
      points[i].y = from.y;

      start++;
    }
  }

  public Point[] getPoints() {
    return this.points;
  }

  public void calcPoints() {
    int tmp;

    if (hasSameX()) {
      if (to.y < from.y) {
        tmp = from.y;
        from.y = to.y;
        to.y = from.y;
      }

      generatePointsForY();
    } else {
      if (to.x < from.x) {
        tmp = from.x;
        from.x = to.x;
        to.x = from.x;
      }

      generatePointsForX();
    }
  }
}
