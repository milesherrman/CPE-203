import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PartTwoTestCases
{
   public static final double DELTA = 0.00001;

   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getCenter", "getRadius", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, double.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0], new Class[0]);

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getTopLeft", "getBottomRight", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, Point.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0], new Class[0]);

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testPolygonImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getPoints", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         List.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

      verifyImplSpecifics(Polygon.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals(0, clazz.getFields().length,
              "Unexpected number of public fields");

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals(expectedMethodNames.size(), publicMethods.size(),
              "Unexpected number of public methods");

      assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
              "Invalid test configuration");
      assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
              "Invalid test configuration");

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }

   @Test
   public void testRectPerimeter()
   {
      Rectangle rect1 = new Rectangle(new Point(0,5), new Point(5,0));
      Rectangle rect2 = new Rectangle(new Point(-2,1), new Point(1,-2));
      double perimeter1 = rect1.perimeter();
      double perimeter2 = rect2.perimeter();
      assertEquals(20, perimeter1);
      assertEquals(12, perimeter2);
   }

   @Test
   public void testPolyPerimeter()
   {
      Point point1 = new Point(0,0);
      Point point2 = new Point(0,3);
      Point point3 = new Point(3,3);
      Point point4 = new Point(3,0);
      List<Point> list1 =  Arrays.asList(point1, point2, point3, point4);
      Polygon poly1 = new Polygon(list1);
      Point point5 = new Point(-1,-1);
      Point point6 = new Point(-1,1);
      Point point7 = new Point(1,1);
      Point point8 = new Point(1,-1);
      List<Point> list2 =  Arrays.asList(point5, point6, point7, point8);
      Polygon poly2 = new Polygon(list2);
      double perimeter1 = poly1.perimeter();
      double perimeter2 = poly2.perimeter();
      assertEquals(12, perimeter1);
      assertEquals(8, perimeter2);
   }

   @Test
   public void testPolyPerimeterGiven() {
      List < Point >points = new ArrayList< Point >();
      points.add(new Point(0, 0));
      points.add(new Point(3,0));
      points.add(new Point(0,4));
      Polygon poly1 = new Polygon(points);
      double d = poly1.perimeter();
      assertEquals(12.0, d, DELTA);
   }

   @Test
   public void testWhichIsBigger()
   {
      Circle circ1 = new Circle(new Point(0,0), 3);

      Rectangle rect1 = new Rectangle(new Point(0,5), new Point(5,0));
      Rectangle rect2 = new Rectangle(new Point(0,4), new Point(4,0));

      List < Point >points = new ArrayList < Point >();
      points.add(new Point(0, 0));
      points.add(new Point(3,0));
      points.add(new Point(0,4));
      Polygon poly1 = new Polygon(points);
      double polyP = poly1.perimeter();

      assertEquals(20, Bigger.whichIsBigger(circ1, rect1, poly1));
      assertEquals(18.84955592153876, Bigger.whichIsBigger(circ1, rect2, poly1));
   }
}
