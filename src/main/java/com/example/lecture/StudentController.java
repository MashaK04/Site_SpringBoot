package com.example.lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    @RequestMapping("/")
    public String index(Model model, @Param("keyword") String keyword) {
        List<Student> listStudent = service.listAll(keyword);
        model.addAttribute("listStudent", listStudent);
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @RequestMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "new";
    }
    @RequestMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.save(student);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView editStudent(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("edit");
        Student student = service.findById(id);
        mav.addObject("student", student);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/";
    }

}