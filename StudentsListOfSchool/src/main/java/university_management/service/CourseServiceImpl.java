package university_management.service;

import university_management.entity.Courses;
import university_management.repo.CourseRepo;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public boolean saveCourse(Courses course) {
        return courseRepo.saveCourse(course);
    }

    @Override
    public boolean updateCourse(Courses course) {
        return courseRepo.updateCourse(course);
    }

    @Override
    public boolean removeCourse(Courses course) {
        return courseRepo.removeCourse(course);
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    @Override
    public Courses findCourseById(long id) {
        return courseRepo.findCourseById(id);
    }
}
