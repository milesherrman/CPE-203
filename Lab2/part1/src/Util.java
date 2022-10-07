import java.lang.Math.*;
import java.util.List;

public class Util {

    public static double perimeter(Circle circ)
    {
        return 2*Math.PI*circ.getRadius();
    }

    public static double perimeter(Rectangle rect)
    {
        double width = Math.abs(rect.getTopLeft().getX() - rect.getBottomRight().getX());
        double height = Math.abs(rect.getTopLeft().getY() - rect.getBottomRight().getY());
        return (2*width) + (2*height);
    }

    public static double perimeter(Polygon poly)
    {
        double perimeter = 0;
        List<Point> points = poly.getPoints();
        for (int i = 0; i < points.size(); i++)
        {
            Point p1 = points.get(i);
            Point p2 = points.get(i);
            if (i == points.size() - 1)
            {
                p2 = points.get(0);
            }
            else
            {
                p2 = points.get(i + 1);
            }

            double x = Math.abs(p1.getX() - p2.getX());
            double y = Math.abs(p1.getY() - p2.getY());
            perimeter = perimeter + Math.sqrt((x*x) + (y*y));
        }
        return perimeter;
    }
}
