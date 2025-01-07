package university_management.repo;

import university_management.entity.Students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepoImpl implements StudentRepo{
    private final Map<Long, Students> students = new HashMap<>();

    @Override
    public boolean saveStudent(Students student) {
        Students studentFromMap = students.get(student.getId());
        if (studentFromMap!=null){
            return false;
        }
        students.put(student.getId(), student);
        return true;
    }

    @Override
    public boolean updateStudent(Students student) {
        Students studentFromMap = students.get(student.getId());
        if (studentFromMap==null){
            return false;
        }
        students.put(student.getId(), student);
        return true;
    }

    @Override
    public boolean removeStudent(Students student) {
        Students studentFromMap = students.get(student.getId());
        if (studentFromMap==null){
            return false;
        }
        students.remove(student.getId());
        return true;
    }

    @Override
    public List<Students> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Students findStudentById(long id) {
        return students.get(id);
    }

}
