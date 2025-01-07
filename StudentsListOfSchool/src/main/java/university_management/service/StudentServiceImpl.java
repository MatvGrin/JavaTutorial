package university_management.service;

import university_management.entity.Students;
import university_management.repo.StudentRepo;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public boolean saveStudent(Students student) {
        return studentRepo.saveStudent(student);
    }

    @Override
    public boolean updateStudent(Students student) {
        return studentRepo.updateStudent(student);
    }

    @Override
    public boolean removeStudent(Students student) {
        return studentRepo.removeStudent(student);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    @Override
    public Students findStudentById(long id) {
        return studentRepo.findStudentById(id);
    }
}
