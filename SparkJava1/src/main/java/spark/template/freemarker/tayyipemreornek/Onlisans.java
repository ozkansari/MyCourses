package spark.template.freemarker.tayyipemreornek;
/**
 * Created by myolab on 26.05.2017.
 */
public class Onlisans extends Student {

    public Student studentNumber;
    public Student studentName;
    public Student studentSection;
    public Student studentType;


    public Onlisans(int studentNumber, String studentName, String studentSection, String studentType) {
        super(studentNumber, studentName, studentSection, studentType);
    }

    public Student getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Student studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Student getStudentName() {
        return studentName;
    }

    public void setStudentName(Student studentName) {
        this.studentName = studentName;
    }

    public Student getStudentSection() {
        return studentSection;
    }

    public void setStudentSection(Student studentSection) {
        this.studentSection = studentSection;
    }

    public Student getStudentType() {
        return studentType;
    }

    public void setStudentType(Student studentType) {
        this.studentType = studentType;
    }
}
