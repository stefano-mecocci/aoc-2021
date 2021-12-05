import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class First {
  public static int updateMax(int currentMax, int from, int to) {
    if (from > currentMax) {
      currentMax = from;
    }

    if (to > currentMax) {
      currentMax = to;
    }

    return currentMax;
  }

  public static int[][] generateMap(int maxX, int maxY) {
    int[][] map = new int[maxY + 1][maxX + 1];

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = 0;
      }
    }

    return map;
  }

  public static int countOverlaps(int[][] map) {
    int count = 0;

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] >= 2) {
          count++;
        }
      }
    }

    return count;
  }

  public static void readLines(BufferedReader br, ArrayList<Line> lines, Point max) throws Exception {
    String line;

    while ((line = br.readLine()) != null) {
      var linePoints = line.split(" -> ");
      var from = Point.fromString(linePoints[0]);
      var to = Point.fromString(linePoints[1]);
      var tmpLine = new Line();

      max.x = updateMax(max.x, from.x, to.x);
      max.y = updateMax(max.y, from.y, to.y);

      tmpLine.setFrom(from);
      tmpLine.setTo(to);
      tmpLine.calcPoints();

      lines.add(tmpLine);
    }
  }

  public static void main(String[] args) throws Exception {
    var fileBuffer = new BufferedReader(new FileReader("input.txt"));
    ArrayList<Line> lines = new ArrayList<>();
    Point max = new Point();

    readLines(fileBuffer, lines, max);

    int[][] map = generateMap(max.x, max.y);
    var listOfPoints = lines.stream()
                           .filter(l -> !l.isDiagonal())
                           .map(l -> l.getPoints())
                           .collect(Collectors.toList());

    // add lines to map
    for (var points : listOfPoints) {
      for (var p : points) {
        map[p.y][p.x] += 1;
      }
    }

    System.out.println(countOverlaps(map));

    fileBuffer.close();
  }
}