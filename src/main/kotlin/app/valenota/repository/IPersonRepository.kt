package app.valenota.repository

import app.valenota.model.entity.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface IPersonRepository : CrudRepository<Person, String> {
    fun findByCpfAndPassword(cpf: String, password: String): Optional<Person>
}