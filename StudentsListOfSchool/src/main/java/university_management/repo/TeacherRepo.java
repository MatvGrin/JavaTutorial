package university_management.repo;

import university_management.entity.Teachers;

import java.util.List;

public interface TeacherRepo {
    boolean saveTeacher(Teachers teacher);
    boolean updateTeacher(Teachers teacher);
    boolean removeTeacher(Teachers teacher);
    List<Teachers> getAllTeachers();
    Teachers findTeacherById(long id);
}
