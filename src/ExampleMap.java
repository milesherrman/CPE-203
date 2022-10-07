
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExampleMap {

  /**
   * Return a list of "high scoring" students --- High scoring students are
   * students who have all grades strictly greater than the given threshold.
   * 
   * @param scoresByApplicantName A map of applicant names to applicant scores
   * @param scoreThreshold        The score threshold
   * @return The list of high-scoring applicant names
   */
  public static List<String> highScoringStudents(Map<String, List<CourseGrade>> scoresByApplicantName, int scoreThreshold)
  {
    LinkedList<String> bestStudents = new LinkedList();
    for (Map.Entry<String,List<CourseGrade>> student : scoresByApplicantName.entrySet())
    {
      boolean allow = true;
      for (int j = 0; j < student.getValue().size(); j++)
      {
         if (student.getValue().get(j).getScore() < scoreThreshold) allow = false;
      }
      if (allow == true) bestStudents.add(student.getKey());
    }
    return bestStudents;
  }
}
