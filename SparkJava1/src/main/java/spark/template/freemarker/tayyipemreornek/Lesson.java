package spark.template.freemarker.tayyipemreornek;
import java.util.List;

/**
 * Created by Ghost on 22.5.2017.
 */
public class Lesson {

    public int lessonID;
    public String lessonName;
    public int lessonCredit;
    public int lessonHour;

    public Lesson(int lessonID, String lessonName, int lessonCredit, int lessonHour) {
        this.lessonID = lessonID;
        this.lessonName = lessonName;
        this.lessonCredit = lessonCredit;
        this.lessonHour = lessonHour;
    }

    public String lessonID() { return String.valueOf(this.lessonID);}

    public String lessonName() { return this.lessonName;}

    public String lessonCredit() { return String.valueOf(this.lessonCredit);}

    public String lessonHour() { return String.valueOf(this.lessonHour);}
}
