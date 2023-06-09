package app.valenota.repository

import app.valenota.model.entity.Company
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ICompanyRepository : CrudRepository<Company, String> {
    fun findByCnpjAndPassword(cnpj: String, password: String): Optional<Company>
}