package university_management.repo;

import university_management.entity.Students;

import java.util.List;

public interface StudentRepo {
    boolean saveStudent(Students student);
    boolean updateStudent(Students student);
    boolean removeStudent(Students student);
    List<Students> getAllStudents();
    Students findStudentById(long id);
}
