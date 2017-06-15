package spark.template.freemarker.tayyipemreornek;

public class Lisans extends Student {

    public Student studentNumber;
    public Student studentName;
    public Student studentSection;
    public Student studentType;


    public Lisans(int studentNumber, String studentName, String studentSection, String studentType) {
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
