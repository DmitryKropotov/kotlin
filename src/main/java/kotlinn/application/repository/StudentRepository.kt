package kotlinn.application.repository

import kotlinn.application.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student, Int>