package cruddemo.rest;

import cruddemo.entity.Student;
import cruddemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.findAll();
        return ResponseEntity.ok(students);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)); // Jeśli nie znaleziono, zwróć 404 z `null`
    }


    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody @Valid Student student) {
        Student savedStudent = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent); // Zwraca utworzonego studenta z kodem 201
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody @Valid Student student) {
        if (!studentService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Student nie istnieje
        }

        student.setId(id); // Ustawiamy ID istniejącego studenta
        Student updatedStudent = studentService.save(student);
        return ResponseEntity.ok(updatedStudent); // Zwraca zaktualizowanego studenta
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        if (!studentService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Student nie istnieje
        }
        studentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); // Usunięto, zwracamy 204 bez treści
    }
}
