public class Bigger
{
    public static double whichIsBigger(Circle circ, Rectangle rect, Polygon poly)
    {
        double circP = circ.perimeter();
        double rectP = rect.perimeter();
        double polyP = poly.perimeter();

        if (rectP > polyP) {
            if (rectP > circP) return rectP;
        }
        else if (polyP > circP) { return polyP;
        }
        return circP;
    }
}
