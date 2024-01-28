package com.example.student1_management_system;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    HashMap<Integer,Student> hashMap = new HashMap<>();
    @PostMapping("/addStudent" )

    public void addStudent(@RequestBody Student student){
        int key =student.getRollNo();
        hashMap.put(key,student);

    }
    @GetMapping("/getStudentInfo")
    public Student getStudent(@RequestParam("rollNo")Integer rollNo){
        Student student =hashMap.get(rollNo);
        return student ;

    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>(hashMap.values());
        return studentList;
    }

    @DeleteMapping("/{rollNo}")
    public void deleteStudent(@PathVariable Long id) {
        hashMap.remove(id);
    }

    @PutMapping("/{rollNo}")
    public Student updateStudent(@PathVariable int rollNo, @RequestBody Student updatedStudent) {
        // Check if the student with the given ID exists
        if (hashMap.containsKey(rollNo)) {
            // Update the existing student
            Student existingStudent = hashMap.get(rollNo);
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());

            // You can update other fields as needed

            // Save the updated student
            hashMap.put(rollNo, existingStudent);

            return existingStudent;
        } else {
            // If the student with the given ID doesn't exist, you might want to handle this case accordingly.
            // In this example, I'm returning null, but you can throw an exception or handle it based on your requirements.
            return null;
        }
    }

    @GetMapping("/getStudentsByAgeRange")
    public List<Student> getStudentsByAgeRange(@RequestParam("minAge") int minAge, @RequestParam("maxAge") int maxAge) {
        List<Student> result = new ArrayList<>();

        for (Student student : hashMap.values()) {
            if (student.getAge() >= minAge && student.getAge() <= maxAge) {
                result.add(student);
            }
        }

        return result;
    }
    @PutMapping("/{rollNo}/updateGrade")
    public Student updateStudentGrade(@PathVariable int rollNo, @RequestParam("newGrade") String newGrade) {
        if (hashMap.containsKey(rollNo)) {
            Student student = hashMap.get(rollNo);
            student.setGrade(newGrade);
            hashMap.put(rollNo, student);
            return student;
        } else {
            // Handle the case where the student with the given rollNo doesn't exist
            return null;
        }
    }

}
