package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");

        String subject = "Spring Boot";
        model.addAttribute("subject",subject);

        int studentID = new Random().nextInt();
        model.addAttribute("id",studentID);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        model.addAttribute("numbers", numbers);

        LocalDateTime dt = LocalDateTime.now();
        model.addAttribute("dt", dt);

        Student student = new Student(1,"Mike","Smith");
        model.addAttribute("student",student);


        return "student/welcome";
    }
}
