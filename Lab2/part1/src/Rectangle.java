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

}
