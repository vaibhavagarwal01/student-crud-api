package com.example.MyStudentCrudAPI.controller;

import com.example.MyStudentCrudAPI.model.Student;
import com.example.MyStudentCrudAPI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    public String healthCheck() {
        return "Pong";
    }

    @RequestMapping(value = "/api/v1/student", method = RequestMethod.POST)
    @ResponseBody
    public Student insert(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @RequestMapping(value = "/api/v1/student/id", method = RequestMethod.GET)
    @ResponseBody
    public Student findById(@RequestParam("id") int id) {
        return studentRepository.findById(id);
    }

    @RequestMapping(value = "/api/v1/students", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/api/v1/student/roll", method = RequestMethod.GET)
    @ResponseBody
    public Student findByRoll(@RequestParam("roll") int roll) {
        return studentRepository.findByRoll(roll);
    }

    @RequestMapping(value = "/api/v1/student", method = RequestMethod.PUT)
    @ResponseBody
    public Student update(@RequestBody Student student) {
        Student st = studentRepository.findByRoll(student.getRoll());
        st.setName(student.getName());
        st.setDept(student.getDept());
        st.setMarks(student.getMarks());
        return studentRepository.save(st);
    }

    @RequestMapping(value = "/api/v1/student/id", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteById(@RequestParam("id") int id) {
        studentRepository.deleteById(id);
    }

    @RequestMapping(value = "/api/v1/student/roll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteByRoll(@RequestParam("roll") int roll) {
        Student student = studentRepository.findByRoll(roll);
        int id = student.getId();
        studentRepository.deleteById(id);
    }
}
