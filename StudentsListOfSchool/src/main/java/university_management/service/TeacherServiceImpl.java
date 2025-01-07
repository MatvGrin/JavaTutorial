package university_management.service;

import university_management.entity.Teachers;
import university_management.repo.TeacherRepo;

import java.util.List;

public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepo teacherRepo;

    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public boolean saveTeacher(Teachers teacher) {
        return teacherRepo.saveTeacher(teacher);
    }

    @Override
    public boolean updateTeacher(Teachers teacher) {
        return teacherRepo.updateTeacher(teacher);
    }

    @Override
    public boolean removeTeacher(Teachers teacher) {
        return teacherRepo.removeTeacher(teacher);
    }

    @Override
    public List<Teachers> getAllTeachers() {
        return teacherRepo.getAllTeachers();
    }

    @Override
    public Teachers findTeacherById(long id) {
        return teacherRepo.findTeacherById(id);
    }

}
