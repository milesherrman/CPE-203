import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestCases
{
   /*
    * This test is just to get you started.
    */
   @Test
   public void testGetName()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades);
      assertEquals("Aakash", testApplicant.getName());
   }

   @Test
   public void testGetGrades()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83));

      Applicant testApplicant = new Applicant("Aakash", grades);
      System.out.println(testApplicant.getGrades());


   }

   @Test
   public void testGetGradeFor()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades);
      System.out.println(testApplicant.getGradeFor("Intro to CS").getCourseName());
      System.out.println(testApplicant.getGradeFor("Non-CS").getCourseName());
      System.out.println(testApplicant.getGradeFor("Nonexistent Class").getCourseName());
   }

   @Test
   public void testMajor()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83));

      Applicant testApplicant = new Applicant("Aakash", grades, "Business");
      assertEquals(testApplicant.getMajor(),"Business");
   }
   @Test
   public void testAnalyzeApplicant() { assertTrue(SimpleIf.analyzeApplicant(89, 85)); }

   @Test
   public void testMaxAverage() {
      assertEquals(SimpleIf.maxAverage(89.5, 91.2), 91.2);
   }
   @Test
   public void testAnalyzeApplicant2() {
      List<CourseGrade> grades = Arrays.asList(
              new CourseGrade("Intro to CS", 100),
              new CourseGrade("Data Structures", 95),
              new CourseGrade("Algorithms", 91),
              new CourseGrade("Computer Organization", 91),
              new CourseGrade("Operating Systems", 75),
              new CourseGrade("Non-CS", 83));
      Applicant testApplicant1 = new Applicant("Aakash", grades, "Business");
      Applicant testApplicant2 = new Applicant("Tyler", grades, "Computer Science");
      assertEquals(SimpleIf.analyzeApplicant2(testApplicant1), false);
      assertEquals(SimpleIf.analyzeApplicant2(testApplicant2), true);
   }


}
