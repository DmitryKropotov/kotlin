package kotlinn.application.service.impl

import kotlinn.application.entity.Student
import kotlinn.application.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl /*: StudentService*/  {

    @Autowired
    private lateinit var studentRepository: StudentRepository;

    fun findAllStudents(): List<Student> {
        return studentRepository.findAll()
    }
}