package com.ywb.springboot.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ywb.springboot.model.Student;
import com.ywb.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    private StudentService studentService;

    @RequestMapping("/student/{id}")
    public String queryStudentById(Model model,
                                   @PathVariable("id") Integer id){
        Student student=studentService.queryStudentById(id);
        model.addAttribute("student",student);
        return "studentDetail";
    }
}
