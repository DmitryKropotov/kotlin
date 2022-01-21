package kotlinn.application.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Student(@Id var id: Int, var name: String) {
    /*@Id
    var id: Int
    var name: String*/

    fun getId_(): Int {
        return id;
    }

    fun getName_(): String {
        return name;
    }
}