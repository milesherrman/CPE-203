import java.util.*;
public class Polygon
{
    private List<Point> points;

    public Polygon(final List<Point> points)
    {
        this.points = points;
    }

    public List<Point> getPoints()
    {
        return points;
    }

    public double perimeter()
    {
        double perimeter = 0;
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
