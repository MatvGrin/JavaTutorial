package university_management.repo;

import university_management.entity.Courses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRepoImpl implements CourseRepo{
    private final Map<Long, Courses> courses = new HashMap<>();

    @Override
    public boolean saveCourse(Courses course) {
        Courses courseFromMap = courses.get(course.getId());
        if (courseFromMap!=null){
            return false;
        }
        courses.put(course.getId(), course);
        return true;
    }

    @Override
    public boolean updateCourse(Courses course) {
        Courses courseFromMap = courses.get(course.getId());
        if (courseFromMap==null){
            return false;
        }
        courses.put(course.getId(), course);
        return true;
    }

    @Override
    public boolean removeCourse(Courses course) {
        Courses courseFromMap = courses.get(course.getId());
        if (courseFromMap==null){
            return false;
        }
        courses.remove(course.getId());
        return true;
    }

    @Override
    public List<Courses> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    @Override
    public Courses findCourseById(long id) {
        return courses.get(id);
    }
}
