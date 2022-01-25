package kotlinn.application.controller

import kotlinn.application.entity.Student
import kotlinn.application.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController {

    @Autowired
    private lateinit var studentService: StudentService;

    @GetMapping("findAllStudents/")
    fun findAllStudents(): ResponseEntity<List<Student>> {
        return ResponseEntity(studentService.findAllStudents(),
            HttpStatus.OK)
    }

    @PostMapping("saveStudent/")
    fun saveStudent(@RequestBody student: Student): Student {
       return studentService.saveStudent(student)
    }
}