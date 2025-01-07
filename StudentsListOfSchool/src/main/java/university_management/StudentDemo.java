package university_management;

import university_management.repo.*;
import university_management.service.*;

import javax.swing.*;

public class StudentDemo {

    public static void main(String[] args) {
        StudentRepo studentRepo = new StudentRepoSql();
        CourseRepo courseRepo = new CourseRepoSql();
        TeacherRepo teacherRepo = new TeacherRepoSql();

        StudentService studentService = new StudentServiceImpl(studentRepo);
        CourseService courseService = new CourseServiceImpl(courseRepo);
        TeacherService teacherService = new TeacherServiceImpl(teacherRepo);

        SwingUtilities.invokeLater(() -> new StudentManager(studentService, courseService, teacherService));
    }
}
