package kotlinn.application.service.impl

import kotlinn.application.entity.Student
import kotlinn.application.repository.StudentRepository
import kotlinn.application.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl : StudentService {

    @Autowired
    private lateinit var studentRepository: StudentRepository;

    @Override
    open override fun findAllStudents(): List<Student> {
        var result = studentRepository.findAll()
        var students: MutableList<Student> = MutableList(result.count()) {Student(1, "")}
        var i = 0
        result.forEach{student: Student ->
            students.set(i, student)
            i++
        }
       return students
    }

    override fun saveStudent(student: Student): Student {
        var savedStudent = studentRepository.save(student)
        return savedStudent
    }
}