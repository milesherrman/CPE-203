
public class SimpleIf {

  public static boolean analyzeApplicant(double avg, double threshold)
  {
    return avg > threshold;
  }
  public static double maxAverage(double avg1, double avg2)
  {
    if (avg1 > avg2) return avg1;
    return avg2;
  }

  /*
  Although it's very simple, the new Major filter will definitely leave us
  with only the best applicants. The "cream of the crop" if you will.
  */
  public static boolean analyzeApplicant2(Applicant applicant)
  {
  return applicant.getMajor().equals("Computer Science");
  }





}
