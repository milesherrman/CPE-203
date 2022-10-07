import java.util.*;

public class Applicant {

  public String name;
  public List<CourseGrade> grades;

  public String major;

  public Applicant(String name, List<CourseGrade> grades) {
    this.name = name;
    this.grades = grades;
  }

  public Applicant(String name, List<CourseGrade> grades, String major) {
    this.name = name;
    this.grades = grades;
    this.major = major;
  }

  public String getName()
  {
    return name;
  }

  public List<CourseGrade> getGrades()
  {
    return this.grades;
  }

  public String getMajor()
  {
    return major;
  }

  public CourseGrade getGradeFor(String course) {
    for (CourseGrade cur_course : grades)
    {
      if (cur_course.getCourseName().equals(course)) return cur_course;
    }
    return new CourseGrade("issue", 0);
  }

}