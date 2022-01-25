package kotlinn.application.service

import kotlinn.application.entity.Student

interface StudentService {
    fun findAllStudents(): List<Student>
    fun saveStudent(student: Student): Student
}