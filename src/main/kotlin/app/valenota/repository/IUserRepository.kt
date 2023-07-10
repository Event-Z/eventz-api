package app.valenota.repository

import app.valenota.model.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface IUserRepository : CrudRepository<User, String> {
    fun findByEmailAndPassword(cpf: String, password: String): Optional<User>
    fun findByCnpjAndPassword(cnpj: String, password: String): Optional<User>
}