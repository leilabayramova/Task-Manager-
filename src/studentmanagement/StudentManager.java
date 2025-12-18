package studentmanagement;

import arraylist.Task;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students= new ArrayList<>();
    private int nextId=1;

    public void addStudent(String name, String group, Double score) {
        var student = new Student(nextId++, name, group, true, score );
        students.add(student);
    }
    public void removeStudent(Integer id) {
        var student=  getStudentById(id);
        if (student != null) {
            students.remove(student);
        }else {
            System.out.println("Student " + id + " not found");
        }
    }

    public void updateStudent(Integer id,String name, String group, Double score) {
          var student= getStudentById(id);
          if (student != null) {
              student.setName(name);
              student.setGroup(group);
              student.setScore(score);
          }else {
              System.out.println("Student " + id + " not found");
          }
    }
    public void deactivateStudent(Integer id) {
        var student= getStudentById(id);
        if (student != null) {
            student.setActive(false);
        }else  {
            System.out.println("Student " + id + " not found");
        }
    }
    public void search(String keyword) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    student.getGroup().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching students found.");
        }
    }
    public void showAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println(students);
        }
    }
    public void clearAll() {
        students.clear();
        System.out.println("All students are cleared.");
    }

    private Student getStudentById(Integer id) {
        for(var student : students) {
            if(student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}

