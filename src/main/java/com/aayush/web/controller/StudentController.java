/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aayush.web.controller;

import com.aayush.web.dao.StudentDAO;
import com.aayush.web.entity.Student;
import com.aayush.web.util.ResponseEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dell
 */
@Controller
@RequestMapping (value = "/student")

public class StudentController {
    
    @Autowired
    private StudentDAO studentDAO;
    
    @RequestMapping (method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("students", studentDAO.getAll());
        return "student/index";
    }
    
    @RequestMapping (value="/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id")int id,Model model){
        model.addAttribute("student", studentDAO.getById(id));
        return "student/detail";
    }
       
    @RequestMapping (value="/json",method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Student> json(){
        return new ResponseEntity<>(studentDAO.getAll());
    } 
    
    @RequestMapping (value="/json/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Student jsonId(@PathVariable("id")int id){
        return studentDAO.getById(id);
    }
    
}
