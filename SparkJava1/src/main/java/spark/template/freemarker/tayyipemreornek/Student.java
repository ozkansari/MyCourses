package spark.template.freemarker.tayyipemreornek;
import java.util.List;

/**
 * Created by Ghost on 22.5.2017.
 */
public class Student {

    public int studentNumber;
    public String studentName;
    public String studentSection;
    public String studentType;

    public Student(int studentNumber, String studentName, String studentSection, String studentType) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.studentSection = studentSection;
        this.studentType = studentType;
    }

    public String getStudent() {
        return "Numara : " + this.studentNumber + "\nAd Soyad : " + this.studentName +
                "\nBölüm : " + this.studentSection + "\nDüzey : " + this.studentType;
    }

    public String studentNumber() {return String.valueOf(this.studentNumber);}

    public String studentName() { return this.studentName;}

    public String studentSection() { return String.valueOf(this.studentSection);}

    public String studentType() { return String.valueOf(this.studentType);}
}
