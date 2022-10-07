public class Bigger
{
    public static double whichIsBigger(Circle circ, Rectangle rect, Polygon poly)
    {
        double circP = Util.perimeter(circ);
        double rectP = Util.perimeter(rect);
        double polyP = Util.perimeter(poly);

        if (rectP > polyP) {
            if (rectP > circP) return rectP;
        }
        else if (polyP > circP) { return polyP;
        }
        return circP;
    }
}
