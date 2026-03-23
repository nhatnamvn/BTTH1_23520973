import java.util.*;

class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class Bai03 {

    public static double crossProduct(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public static double distSq(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            List<Point> points = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                points.add(new Point(sc.nextDouble(), sc.nextDouble()));
            }
            if (n < 3) return;
            int minIdx = 0;
            for (int i = 1; i < n; i++) {
                if (points.get(i).y < points.get(minIdx).y || 
                   (points.get(i).y == points.get(minIdx).y && points.get(i).x < points.get(minIdx).x)) {
                    minIdx = i;
                }
            }
            Point pivot = points.get(minIdx);
            points.sort((p1, p2) -> {
                if (p1 == pivot) return -1;
                if (p2 == pivot) return 1;
                double dx1 = p1.x - pivot.x;
                double dy1 = p1.y - pivot.y;
                double dx2 = p2.x - pivot.x;
                double dy2 = p2.y - pivot.y;
                double cos1 = dx1 / Math.sqrt(dx1 * dx1 + dy1 * dy1);
                double cos2 = dx2 / Math.sqrt(dx2 * dx2 + dy2 * dy2);
                if (cos1 > cos2) return -1;
                if (cos1 < cos2) return 1;
                return Double.compare(distSq(pivot, p1), distSq(pivot, p2));
            });
            Stack<Point> hull = new Stack<>();
            hull.push(points.get(0));
            hull.push(points.get(1));
            for (int i = 2; i < n; i++) {
                Point next = points.get(i);
                while (hull.size() >= 2) {
                    Point b = hull.pop();
                    Point a = hull.peek();
                    if (crossProduct(a, b, next) > 0) {
                        hull.push(b);
                        break;
                    }
                }
                hull.push(next);
            }
            for (Point p : hull) {
                System.out.println((int) p.x + " " + (int) p.y);
            }
        }
    }
}