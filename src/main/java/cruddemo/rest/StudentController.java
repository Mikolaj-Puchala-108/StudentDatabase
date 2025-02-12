package cruddemo.rest;
import cruddemo.service.StudentService;
import cruddemo.entity.Student;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
/*
    private final StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Operation(summary = "Show the main menu", description = "Displays the main menu of the application.")
    @GetMapping("/menu")
    public String showMenu() {
        return "menu";
    }

    @Operation(summary = "List all students", description = "Retrieves a list of all students and displays them in a view.")
    @GetMapping("/students")
    public String showStudents(Model model) {
        List<Student> students = studentDAO.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @Operation(summary = "Show the form to add a student", description = "Displays the form to add a new student.")
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @Operation(summary = "Process the student form", description = "Processes the form data and adds a new student to the database.")
    @PostMapping("/form")
    public String processForm(
            @Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        studentDAO.save(student);

        return "redirect:/students";
    }

    @Operation(summary = "Show the search page", description = "Displays a page where the user can search for a student by ID.")
    @GetMapping("/search-page")
    public String showSearchPage() {
        return "search";
    }

    @Operation(summary = "Search for a student by ID", description = "Searches for a student in the database by their ID and displays the result.")
    @GetMapping("/search")
    public String searchStudentById(@RequestParam("id") int id, Model model) {
        Student student = studentDAO.findById(id);
        if (student == null) {
            model.addAttribute("errorMessage", "Nie ma takiego użytkownika.");
        } else {
            model.addAttribute("studentById", student);
        }
        return "search";
    }

    @Operation(summary = "Delete a student by ID", description = "Deletes a student from the database by their ID.")
    @PostMapping("/delete")
    public String deleteStudentById(@RequestParam("id") int id) {
        studentDAO.delete(id);
        return "redirect:/students";
    }

    @Operation(summary = "Show the edit form", description = "Displays the form to edit a student's details.")
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        Student student = studentDAO.findById(id);
        model.addAttribute("student", student);
        return "edit";
    }

    @Operation(summary = "Update a student's details", description = "Processes the form data to update a student's details in the database.")
    @PostMapping("/update")
    public String updateStudent(
            @RequestParam("id") int id,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            Model model) {
        Student student = studentDAO.findById(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        studentDAO.update(student);
        return "redirect:/students";
    }

    @Operation(summary = "Show the documentation page", description = "Displays the application documentation.")
    @GetMapping("/docs")
    public String showDocs() {
        return "docs";
    }
    */

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/menu")
    public String showMenu() {
        return "menu";
    }

    @GetMapping("/students")
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping("/form")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/form")
    public String addStudent(@ModelAttribute @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit")
    public String showEditStudentForm(@RequestParam Long id, Model model) {
        Student student = studentService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono studenta o ID: " + id));
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        studentService.save(student);
        return "redirect:/students";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/search")
    public String searchStudentById(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            studentService.findById(id).ifPresentOrElse(
                    student -> model.addAttribute("studentById", student),
                    () -> model.addAttribute("errorMessage", "Nie znaleziono studenta o ID: " + id)
            );
        }
        return "search";
    }

    @Operation(summary = "Show the search page", description = "Displays a page where the user can search for a student by ID.")
    @GetMapping("/search-page")
    public String showSearchPage() {
        return "search";
    }




}
