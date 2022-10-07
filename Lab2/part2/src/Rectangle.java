import java.lang.Math.*;
public class Rectangle
{

    private Point tleft;
    private Point bright;

    public Rectangle(final Point tleft, final Point bright)
    {
        this.tleft = tleft;
        this.bright = bright;
    }

    public Point getTopLeft()
    {
        return tleft;
    }

    public Point getBottomRight()
    {
        return bright;
    }

    public double perimeter()
    {
        double width = Math.abs(tleft.getX() - bright.getX());
        double height = Math.abs(tleft.getY() - bright.getY());
        return (2*width) + (2*height);
    }
}
