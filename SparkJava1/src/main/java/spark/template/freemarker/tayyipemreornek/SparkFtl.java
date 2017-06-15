package spark.template.freemarker.tayyipemreornek;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.*;
import spark.template.freemarker.*;

/**
 * Created by Ghost on 22.5.2017.
 */
public class SparkFtl {

    public static void main(String[] args) {
        final List<Student> studentlist = new ArrayList<Student>();
        List<Lesson> lessonlist = new ArrayList<Lesson>();

        studentlist.add(new YuksekLisans(1, "Tayyip Emre Örnek", "Software Engineering", "Yüksek Lisans"));
        studentlist.add(new Lisans(2, "Hasan Hakan Sayar", "Bilgisayar Muhendisliği", "Lisans"));

        lessonlist.add(new Lesson(1, "Visual Programming", 6, 3));
        lessonlist.add(new Lesson(2, "Operating System", 4, 4));

        setPort(5859);

        //lessonlist.ftl
        FreeMarkerRoute getLessonList = new FreeMarkerRoute("/lessonlist") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("lessons", lessonlist);
                return new ModelAndView(attributes, "tayyipemreornek/lessonlist.ftl");
            }
        };
        get(getLessonList);

        //lessonadd.ftl
        FreeMarkerRoute addLessonList = new FreeMarkerRoute("/lessonadd") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("lessons", lessonlist);
                return new ModelAndView(attributes, "tayyipemreornek/lessonadd.ftl");
            }
        };
        get(addLessonList);

        //lessondelete.ftl
        FreeMarkerRoute getLessonDelete = new FreeMarkerRoute("/lessondelete") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("lessons", lessonlist);
                return new ModelAndView(attributes, "tayyipemreornek/lessondelete.ftl");
            }
        };
        get(getLessonDelete);

        //lessonshow.ftl
        FreeMarkerRoute getLessonShow = new FreeMarkerRoute("/lessonshow") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("lessons", lessonlist);
                return new ModelAndView(attributes, "tayyipemreornek/lessonshow.ftl");
            }
        };
        get(getLessonShow);

        //studentlist.ftl
        FreeMarkerRoute getStudentList = new FreeMarkerRoute("/studentlist") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("students", studentlist);
                return new ModelAndView(attributes, "tayyipemreornek/studentlist.ftl");
            }
        };
        get(getStudentList);

        //studentadd.ftl
        FreeMarkerRoute addStudentList = new FreeMarkerRoute("/studentadd") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("students", studentlist);
                return new ModelAndView(attributes, "tayyipemreornek/studentadd.ftl");
            }
        };
        get(addStudentList);

        //studentdelete.ftl
        FreeMarkerRoute getStudentDelete = new FreeMarkerRoute("/studentdelete") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("students", studentlist);
                return new ModelAndView(attributes, "tayyipemreornek/studentdelete.ftl");
            }
        };
        get(getStudentDelete);

        //studentshow.ftl
        FreeMarkerRoute getStudentShow = new FreeMarkerRoute("/studentshow") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("students", studentlist);
                return new ModelAndView(attributes, "tayyipemreornek/studentshow.ftl");
            }
        };
        get(getStudentShow);

        //lessonstudent.ftl
        FreeMarkerRoute getLessonStudent = new FreeMarkerRoute("/lessonstudent") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("students", studentlist);
                attributes.put("lessons", lessonlist);
                return new ModelAndView(attributes, "tayyipemreornek/lessonstudent.ftl");
            }
        };
        get(getLessonStudent);

        /**************************************************************************************************************/
        //lessonadd.ftl
        FreeMarkerRoute postAddLessonList = new FreeMarkerRoute("/lessonadd") {
            public Object handle(Request req, Response resp) {
                int id = Integer.parseInt(req.queryParams("lessonID"));
                String name = req.queryParams("lessonName");
                int credit = Integer.parseInt(req.queryParams("lessonCredit"));
                int hour = Integer.parseInt(req.queryParams("lessonHour"));
                lessonlist.add(new Lesson(id, name, credit, hour));
                resp.redirect("/lessonlist");
                return null;
            }
        };
        post(postAddLessonList);

        //lessondelete.ftl
        FreeMarkerRoute postDeleteLessonList = new FreeMarkerRoute("/lessonlist") {
            public Object handle(Request req, Response resp) {
                int index = -1;
                int selectedLesson = Integer.parseInt(req.queryParams("delete"));
                for (int i = 0; i < lessonlist.size(); i++) {
                    Lesson lesson = lessonlist.get(i);
                    if (selectedLesson == lesson.lessonID) {
                        index = i;
                        break;
                    }
                }
                lessonlist.remove(index);
                resp.redirect("/lessonlist");
                return null;
            }
        };
        post(postDeleteLessonList);

        //lessonshow.ftl
        FreeMarkerRoute postShowLessonList = new FreeMarkerRoute("/lessonshow") {
            public Object handle(Request req, Response resp) {
                int index = -1;
                int selectedLesson = Integer.parseInt(req.queryParams("shows"));
                for (int i = 0; i < lessonlist.size(); i++) {
                    Lesson lesson = lessonlist.get(i);
                    if (selectedLesson == lesson.lessonID) {
                        index = i;
                        break;
                    }
                }
                Lesson lessons = lessonlist.get(index);
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("lessons", lessons);
                return new ModelAndView(attributes, "tayyipemreornek/lessonshow.ftl");
            }
        };
        post(postShowLessonList);

        //studentadd.ftl
        FreeMarkerRoute postAddStudentList = new FreeMarkerRoute("/studentadd") {
            public Object handle(Request req, Response resp) {
                int number = Integer.parseInt(req.queryParams("studentNumber"));
                String name = req.queryParams("studentName");
                String section = req.queryParams("studentSection");
                String type = req.queryParams("studentType");
                studentlist.add(new Student(number, name, section, type));
                resp.redirect("/studentlist");
                return null;
            }
        };
        post(postAddStudentList);




        //studentshow.ftl
        FreeMarkerRoute postShowStudentList = new FreeMarkerRoute("/studentshow") {
            public Object handle(Request req, Response resp) {
                int index = -1;
                int selectedStudent = Integer.parseInt(req.queryParams("shows"));
                for (int i = 0; i < studentlist.size(); i++) {
                    Student student = studentlist.get(i);
                    if (selectedStudent == student.studentNumber) {
                        index = i;
                        break;
                    }
                }
                Student studentshows = studentlist.get(index);
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("students", studentshows);
                return new ModelAndView(attributes, "tayyipemreornek/studentshow.ftl");
            }
        };
        post(postShowStudentList);

        //studentdelete.ftl
        FreeMarkerRoute postDeleteStudentList = new FreeMarkerRoute("/studentdelete") {
            public Object handle(Request req, Response resp) {
                int index = -1;
                int selectedStudent = Integer.parseInt(req.queryParams("delete"));
                for (int i = 0; i < studentlist.size(); i++) {
                    Student student = studentlist.get(i);
                    if (selectedStudent == student.studentNumber) {
                        index = i;
                        break;
                    }
                }
                studentlist.remove(index);
                resp.redirect("/studentdelete");
                return null;
            }
        };
        post(postDeleteStudentList);

        //lessonstudent.html
        FreeMarkerRoute postLessonStudent = new FreeMarkerRoute("/lessonstudent") {
            public Object handle(Request req, Response resp) {
                int studentNumber = Integer.parseInt(req.queryParams("studentNumber"));
                int lessonID = Integer.parseInt(req.queryParams("lessonID"));
                int indexStudent = -1;
                int indexLesson = -1;
                for (int i = 0; i < studentlist.size(); i++) {
                    Student student = studentlist.get(i);
                    if (studentNumber == student.studentNumber) {
                        indexStudent = i;
                        break;
                    }
                }
                for (int i = 0; i < lessonlist.size(); i++) {
                    Lesson lesson = lessonlist.get(i);
                    if (lessonID == lesson.lessonID) {
                        indexLesson = i;
                        break;
                    }
                }

                Student students = studentlist.get(indexStudent);
                Lesson lessons = lessonlist.get(indexLesson);

                Map<String, Object> attributes = new HashMap<>();
                attributes.put("students", students);
                attributes.put("lessons", lessons);
                // HATALI return new ModelAndView(attributes, "tayyipemreornek/lessonstudent.html");
                return new ModelAndView(attributes, "tayyipemreornek/lessonstudent.ftl");

            }
        };
        post(postLessonStudent);
    }
}
