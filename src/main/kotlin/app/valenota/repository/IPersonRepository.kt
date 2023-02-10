package app.valenota.repository

import app.valenota.model.entity.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IPersonRepository : CrudRepository<Person, String> {}