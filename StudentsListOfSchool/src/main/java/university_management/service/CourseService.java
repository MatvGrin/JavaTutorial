package university_management.service;

import university_management.entity.Courses;

import java.util.List;

public interface CourseService {
    boolean saveCourse(Courses course);
    boolean updateCourse(Courses course);
    boolean removeCourse(Courses course);
    List<Courses> getAllCourses();
    Courses findCourseById(long id);
}
