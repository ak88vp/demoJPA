package ak88.controller;

import ak88.model.Category;
import ak88.model.Student;
import ak88.service.CategoryService;
import ak88.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    CategoryService categoryService;

    public List<Category> allCategory(List<Student> studentList) {
        List<Category> list = new ArrayList<>();
        for (Student st : studentList) {
            Optional<Category> category = categoryService.findById(st.getCategory().getId());
            Category category1 = category.get();
            list.add(category1);
        }
        return list;
    }

    @GetMapping("")
    public String showList(Model model, String key) {
        List<Student> studentIterable ;

        if (key != null) {
          studentIterable= (List<Student>) studentService.findByNameContaining(key);


        } else {
            studentIterable = studentService.findAll();

        }
        model.addAttribute("students", studentIterable);
        return "/student/list";

    }
    @GetMapping("sort")
    public String showSort(Model model){
        List<Student> studentList= (List<Student>) studentService.findAllByOrderByAgeDesc();
        model.addAttribute("students",studentList);
        return "/student/list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categorys", categoryList);
        return "/student/create";
    }

    @PostMapping("create")
    public String createStudent(Student student, long idCategory) {
        Optional<Category> categoryOptional = categoryService.findById(idCategory);
        Category category = categoryOptional.get();
        student.setCategory(category);
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.remove(id);
        return "redirect:/students";
    }

    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Optional<Student> student = studentService.findById(id);
        List<Category> categoryList = categoryService.findAll();
        Student student1 = student.get();
        model.addAttribute("categorys", categoryList);
        model.addAttribute("student", student1);
        return "/student/edit";
    }

    @PostMapping("edit/{id}")
    public String editStudent(Student student, long idCategory) {

        Optional<Category> categoryOptional = categoryService.findById(idCategory);
        Category category = categoryOptional.get();
        student.setCategory(category);
        studentService.save(student);
        return "redirect:/students";
    }


}
