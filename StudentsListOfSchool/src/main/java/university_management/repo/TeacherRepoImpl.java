package university_management.repo;

import university_management.entity.Teachers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherRepoImpl implements TeacherRepo{
    private final Map<Long, Teachers> teachers = new HashMap<>();

    @Override
    public boolean saveTeacher(Teachers teacher) {
        Teachers teacherFromMap = teachers.get(teacher.getId());
        if (teacherFromMap!=null){
            return false;
        }
        teachers.put(teacher.getId(), teacher);
        return true;
    }

    @Override
    public boolean updateTeacher(Teachers teacher) {
        Teachers teacherFromMap = teachers.get(teacher.getId());
        if (teacherFromMap==null){
            return false;
        }
        teachers.put(teacher.getId(), teacher);
        return true;
    }

    @Override
    public boolean removeTeacher(Teachers teacher) {
        Teachers courseFromMap = teachers.get(teacher.getId());
        if (courseFromMap==null){
            return false;
        }
        teachers.remove(teacher.getId());
        return true;
    }

    @Override
    public List<Teachers> getAllTeachers() {
        return new ArrayList<>(teachers.values());
    }

    @Override
    public Teachers findTeacherById(long id) {
        return teachers.get(id);
    }
}
