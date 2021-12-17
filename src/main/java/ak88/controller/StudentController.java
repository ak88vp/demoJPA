package ak88.controller;

import ak88.model.Student;
import ak88.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping("")
    public String showList(Model model){
        Iterable<Student> studentIterable=studentService.findAll();
        model.addAttribute("students",studentIterable);
        return "/student/list";
    }
    @GetMapping("create")
    public String showCreate(){
        return "/student/create";
    }
    @PostMapping("create")
    public String createStudent(Student student){
        studentService.save(student);
        return "redirect:/students";
    }
    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.remove(id);
        return "redirect:/students";
    }
    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable Long id,Model model){
        Optional<Student> student = studentService.findById(id);
        Student student1=student.get();
        model.addAttribute("student",student1);
        return "/student/edit";
    }
    @PostMapping("edit/{id}")
    public String editStudent(Student student){
        studentService.save(student);
        return "redirect:/students";
    }




}
