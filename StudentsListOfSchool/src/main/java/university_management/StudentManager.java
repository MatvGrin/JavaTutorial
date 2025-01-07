package university_management;

import university_management.entity.Courses;
import university_management.entity.Students;
import university_management.entity.Teachers;
import university_management.repo.CourseRepoSql;
import university_management.repo.StudentRepoSql;
import university_management.repo.TeacherRepoSql;
import university_management.service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManager extends JFrame {
    private final StudentService studentService;
    private final CourseService courseService;
    private final TeacherService teacherService;

    public StudentManager(StudentService studentService, CourseService courseService, TeacherService teacherService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.teacherService = teacherService;
        init();
    }

    private void init() {
        setTitle("University Management");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels for each section
        JPanel studentsPanel = createStudentsPanel();
        JPanel coursesPanel = createCoursesPanel();
        JPanel teachersPanel = createTeachersPanel();

        // Add panels to the tabbed pane
        tabbedPane.addTab("Students", studentsPanel);
        tabbedPane.addTab("Courses", coursesPanel);
        tabbedPane.addTab("Teachers", teachersPanel);

        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createStudentsPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));

        // Create buttons for student actions
        JButton addButton = new JButton("Add Student");
        JButton updateButton = new JButton("Update Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton listButton = new JButton("List All Students");
        JButton findButton = new JButton("Find Student");

        // Add buttons to the panel
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(listButton);
        panel.add(findButton);

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listAllStudents();
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findStudent();
            }
        });

        return panel;
    }

    private JPanel createCoursesPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));

        // Create buttons for course actions
        JButton addButton = new JButton("Add Course");
        JButton updateButton = new JButton("Update Course");
        JButton deleteButton = new JButton("Delete Course");
        JButton listButton = new JButton("List All Courses");
        JButton findButton = new JButton("Find Course");

        // Add buttons to the panel
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(listButton);
        panel.add(findButton);

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCourse();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCourse();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCourse();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listAllCourses();
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findCourse();
            }
        });

        return panel;
    }

    private JPanel createTeachersPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));

        // Create buttons for teacher actions
        JButton addButton = new JButton("Add Teacher");
        JButton updateButton = new JButton("Update Teacher");
        JButton deleteButton = new JButton("Delete Teacher");
        JButton listButton = new JButton("List All Teachers");
        JButton findButton = new JButton("Find Teacher");

        // Add buttons to the panel
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(listButton);
        panel.add(findButton);

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTeacher();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTeacher();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTeacher();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listAllTeachers();
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findTeacher();
            }
        });

        return panel;
    }

    // Students-related actions
    private void addStudent() {
        String name = JOptionPane.showInputDialog(this, "Enter student name:");
        String email = JOptionPane.showInputDialog(this, "Enter student email:");
        long courseId = Long.parseLong(JOptionPane.showInputDialog(this, "Enter course ID:"));

        Students student = new Students(0, name, email, courseId);
        studentService.saveStudent(student);
        JOptionPane.showMessageDialog(this, "Student added!");
    }

    private void updateStudent() {
        long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter student ID to update:"));
        Students student = studentService.findStudentById(id);
        if (student != null) {
            String name = JOptionPane.showInputDialog(this, "Enter new name:", student.getName());
            String email = JOptionPane.showInputDialog(this, "Enter new email:", student.getEmail());
            long courseId = Long.parseLong(JOptionPane.showInputDialog(this, "Enter new course ID:", student.getCourse_id()));

            student.setName(name);
            student.setEmail(email);
            student.setCourse_id(courseId);
            studentService.updateStudent(student);
            JOptionPane.showMessageDialog(this, "Student updated!");
        } else {
            JOptionPane.showMessageDialog(this, "Student not found!");
        }
    }

    private void deleteStudent() {
        long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter student ID to delete:"));
        Students student = studentService.findStudentById(id);
        if (student != null) {
            studentService.removeStudent(student);
            JOptionPane.showMessageDialog(this, "Student deleted!");
        } else {
            JOptionPane.showMessageDialog(this, "Student not found!");
        }
    }

    private void listAllStudents() {
        // Display all students
        StringBuilder studentsList = new StringBuilder("Students:\n");
        for (Students student : studentService.getAllStudents()) {
            studentsList.append(student.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, studentsList.toString());
    }

    private void findStudent() {
        long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter student ID to find:"));
        Students student = studentService.findStudentById(id);
        if (student != null) {
            JOptionPane.showMessageDialog(this, "Student found: " + student);
        } else {
            JOptionPane.showMessageDialog(this, "Student not found!");
        }
    }

    // Courses-related actions
    private void addCourse() {
        String name = JOptionPane.showInputDialog(this, "Enter course name:");
        int duration = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter course duration (in weeks):"));
        Courses course = new Courses(0, name, duration);
        courseService.saveCourse(course);
        JOptionPane.showMessageDialog(this, "Course added!");
    }

    private void updateCourse() {
        long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter course ID to update:"));
        Courses course = courseService.findCourseById(id);
        if (course != null) {
            String name = JOptionPane.showInputDialog(this, "Enter new name:", course.getName());
            int duration = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter new duration (in weeks):", course.getDuration()));

            course.setName(name);
            course.setDuration(duration);
            courseService.updateCourse(course);
            JOptionPane.showMessageDialog(this, "Course updated!");
        } else {
            JOptionPane.showMessageDialog(this, "Course not found!");
        }
    }

    private void deleteCourse() {
        long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter course ID to delete:"));
        Courses course = courseService.findCourseById(id);
        if (course != null) {
            courseService.removeCourse(course);
            JOptionPane.showMessageDialog(this, "Course deleted!");
        } else {
            JOptionPane.showMessageDialog(this, "Course not found!");
        }
    }

    private void listAllCourses() {
        // Display all courses
        StringBuilder coursesList = new StringBuilder("Courses:\n");
        for (Courses course : courseService.getAllCourses()) {
            coursesList.append(course.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, coursesList.toString());
    }

    private void findCourse() {
        long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter course ID to find:"));
        Courses course = courseService.findCourseById(id);
        if (course != null) {
            JOptionPane.showMessageDialog(this, "Course found: " + course);
        } else {
            JOptionPane.showMessageDialog(this, "Course not found!");
        }
    }

    // Teachers-related actions
    private void addTeacher() {
        String name = JOptionPane.showInputDialog(this, "Enter student name:");
        long courseId = Long.parseLong(JOptionPane.showInputDialog(this, "Enter course ID:"));

        // Перевірка введених даних
        if (name == null || name.trim().isEmpty() || courseId <= 0) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid name and course ID.");
            return;
        }

        // Створюємо нового студента
        Students student = new Students(0, name, "", courseId);  // Email залишено порожнім
        studentService.saveStudent(student);
        JOptionPane.showMessageDialog(this, "Student added!");
    }

    private void updateTeacher() {
        try {
            long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter teacher ID to update:"));
            Teachers teacher = teacherService.findTeacherById(id);

            if (teacher == null) {
                JOptionPane.showMessageDialog(this, "Teacher not found!");
                return;
            }

            // Оновлюємо тільки ім'я
            String name = JOptionPane.showInputDialog(this, "Enter new name:", teacher.getName());

            // Оновлюємо викладача
            teacher.setName(name);

            teacherService.updateTeacher(teacher);
            JOptionPane.showMessageDialog(this, "Teacher updated!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void deleteTeacher() {
        long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter teacher ID to delete:"));
        Teachers teacher = teacherService.findTeacherById(id);
        if (teacher != null) {
            teacherService.removeTeacher(teacher);
            JOptionPane.showMessageDialog(this, "Teacher deleted!");
        } else {
            JOptionPane.showMessageDialog(this, "Teacher not found!");
        }
    }

    private void listAllTeachers() {
        // Display all teachers
        StringBuilder teachersList = new StringBuilder("Teachers:\n");
        for (Teachers teacher : teacherService.getAllTeachers()) {
            teachersList.append(teacher.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, teachersList.toString());
    }

    private void findTeacher() {
        long id = Long.parseLong(JOptionPane.showInputDialog(this, "Enter teacher ID to find:"));
        Teachers teacher = teacherService.findTeacherById(id);
        if (teacher != null) {
            JOptionPane.showMessageDialog(this, "Teacher found: " + teacher);
        } else {
            JOptionPane.showMessageDialog(this, "Teacher not found!");
        }
    }

    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl(new StudentRepoSql());
        CourseService courseService = new CourseServiceImpl(new CourseRepoSql());
        TeacherService teacherService = new TeacherServiceImpl(new TeacherRepoSql());

        SwingUtilities.invokeLater(() -> new StudentManager(studentService, courseService, teacherService));
    }
}
