import java.util.Comparator;

public class Attainment implements Comparable<Attainment> {
  String courseCode;
  String studentNumber;
  int grade;

  public Attainment(String courseCode, String studentNumber, int grade) {
    this.courseCode = courseCode;
    this.studentNumber = studentNumber;
    this.grade = grade;
  }

  public String getCourseCode() {
    return this.courseCode;
  }

  public String getStudentNumber() {
    return this.studentNumber;
  }

  public int getGrade() {
    return this.grade;
  }

  public String toString() {
    return String.format("%s %s %d", this.courseCode, this.studentNumber, this.grade);
  }

  @Override
  public int compareTo(Attainment o) {
    int cmp = this.studentNumber.compareTo(o.studentNumber);
    if (cmp == 0) {
      cmp = this.courseCode.compareTo(o.courseCode);
    }
    return cmp;
  }

  public static final Comparator<Attainment> CODE_STUDENT_CMP = new Comparator<Attainment>() {
    @Override
    public int compare(Attainment a, Attainment b) {
      int cmp = a.courseCode.compareTo(b.courseCode);
      if (cmp == 0) {
        cmp = a.studentNumber.compareTo(b.studentNumber);
      }
      return cmp;
    }
  };

  public static final Comparator<Attainment> CODE_GRADE_CMP = new Comparator<Attainment>() {
    @Override
    public int compare(Attainment a, Attainment b) {
      int cmp = a.courseCode.compareTo(b.courseCode);
      if (cmp == 0) {
        cmp = Integer.compare(b.grade, a.grade);
      }
      return cmp;
    }
  };
}