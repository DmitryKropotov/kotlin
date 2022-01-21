package kotlinn.application.repository

import kotlinn.application.entity.Student
import org.springframework.stereotype.Repository

@Repository
open class StudentRepository: EntityDao<Student, Int>() {
    override var entity : Class<Student>? = Student::class.java

    /*fun findByName(
        name : String
    ) : List<Student> {
        val criteriaBuilder = getCriteriaBuilder()
        val criteriaQuery = getCriteriaQuery()
        val root = criteriaQuery.from(entity)

        val query =
            criteriaQuery
                .select(root)
                .where(
                    criteriaBuilder.like(root.get(Student.name), "%$name%")
                )

        return getQuery(query).resultList
    }*/
}