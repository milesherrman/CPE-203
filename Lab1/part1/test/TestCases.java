import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases
{
   private final static double DELTA = 0.0001;

   ////////////////////////////////////////////////////////////
   //                      SimpleIf Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testAnalyzeApplicant() { assertTrue(SimpleIf.analyzeApplicant(89, 85)); }

   @Test
   public void testAnalyzeApplicant2() {assertFalse(SimpleIf.analyzeApplicant(15, 90));}

   @Test
   public void testAnalyzeApplicant3(){assertFalse(SimpleIf.analyzeApplicant(85, 86));}

   @Test
   public void testMaxAverage() {
      assertEquals(SimpleIf.maxAverage(89.5, 91.2), 91.2, DELTA);
   }

   @Test
   public void testMaxAverage2() {
      assertEquals(SimpleIf.maxAverage(60, 89), 89, DELTA);
   }

   @Test
   public void testMaxAverage3() {
      /* TO DO: Delete the line below and add a valid test case. */
      assertFalse(SimpleIf.maxAverage(60, 89) == 60);
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleLoop1()
   {
      assertEquals(7, SimpleLoop.sum(3, 4));
   }

   @Test
   public void testSimpleLoop2()
   {
      assertEquals(7, SimpleLoop.sum(-2, 4));
   }

   @Test
   public void testSimpleLoop3()
   {
      /* TO DO: Write one more valid test case to make sure that
         this function is not just returning 7. */
      assertEquals(15, SimpleLoop.sum(0, 5));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleArray Tests                   //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleArray1()
   {
      /* What is that parameter?  They are newly allocated arrays
         with initial values. */
      assertArrayEquals(
         new boolean[] {false, false, true, true, false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 85, 89, 92, 76, 81}, 85)
      );
   }

   @Test
   public void testSimpleArray2()
   {
      assertArrayEquals(
         new boolean[] {false, false},
         SimpleArray.applicantAcceptable(new int[] {80, 83}, 92));
   }

   @Test
   public void testSimpleArray3()
   {
      /* TO DO: Delete the line below and add a valid test case. */
      assertArrayEquals(new boolean[] {false, false, false, true, true},
              SimpleArray.applicantAcceptable(new int[] {60, 70, 80, 90, 100}, 80));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleList Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleList1()
   {
      List<Integer> input =
         new LinkedList<>(Arrays.asList(80, 85, 89, 92, 76, 81));
      List<Boolean> expected =
         new ArrayList<>(Arrays.asList(false, false, true, true, false, false));

      assertEquals(expected, SimpleList.applicantAcceptable(input, 85));
   }

   @Test
   public void testSimpleList2()
   {
      List<Integer> input = new LinkedList<>(Arrays.asList(80, 85, 89, 92, 96, 100));
      List<Boolean> expected = Arrays.asList(false, false, false, true, true, true);

      /* TO DO: Delete the line below and dd a valid test case. 
         You can change the expected above if needed */
      assertEquals(expected, SimpleList.applicantAcceptable(input, 90));
   }

   ////////////////////////////////////////////////////////////
   //                    BetterLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testFourOver85()
   {
      assertFalse(BetterLoop.atLeastFourOver85(new int[] {89, 93, 100, 39, 84, 63}));
   }

   @Test
   public void testFourOver85_2()
   {
      assertTrue(BetterLoop.atLeastFourOver85(new int[] {89, 86, 90, 92, 84, 88}));
   }

   @Test
   public void testFourOver85_3() {
         assertFalse(BetterLoop.atLeastFourOver85(new int[] {80, 81, 50, 72, 84, 88}));
      /* TO DO: Write a valid test case where the expected result is false. */

   }

   ////////////////////////////////////////////////////////////
   //                    ExampleMap Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testExampleMap1()
   {
      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Julie",
         Arrays.asList(
            new CourseGrade("CPE 123", 89),
            new CourseGrade("CPE 101", 90),
            new CourseGrade("CPE 202", 99),
            new CourseGrade("CPE 203", 100),
            new CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Paul",
         Arrays.asList(
            new CourseGrade("CPE 101", 86),
            new CourseGrade("CPE 202", 80),
            new CourseGrade("CPE 203", 76),
            new CourseGrade("CPE 225", 80)));
      courseListsByStudent.put("Zoe",
         Arrays.asList(
            new CourseGrade("CPE 123", 99),
            new CourseGrade("CPE 203", 91),
            new CourseGrade("CPE 471", 86),
            new CourseGrade("CPE 473", 90),
            new CourseGrade("CPE 476", 99),
            new CourseGrade("CPE 572", 100)));

      List<String> expected = Arrays.asList("Julie", "Zoe");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
         new HashSet<>(ExampleMap.highScoringStudents(
            courseListsByStudent, 85)));
   }

   @Test
   public void testExampleMap2() {
      /* TO DO: Write another valid test case. */
      assertFalse(true);

      Map<String, List<CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Tyler",
              Arrays.asList(
                      new CourseGrade("CPE 123", 100),
                      new CourseGrade("CPE 101", 90),
                      new CourseGrade("CPE 202", 99)));
      courseListsByStudent.put("John",
              Arrays.asList(
                      new CourseGrade("CPE 101", 54),
                      new CourseGrade("CPE 202", 80),
                      new CourseGrade("CPE 203", 76)));
      courseListsByStudent.put("Roman",
              Arrays.asList(
                      new CourseGrade("CPE 123", 99),
                      new CourseGrade("CPE 203", 91),
                      new CourseGrade("CPE 471", 69)));

      List<String> expected = Arrays.asList("Tyler");

      assertEquals(new HashSet<>(expected),
              new HashSet<>(ExampleMap.highScoringStudents(
                      courseListsByStudent, 70)));
   }
}
