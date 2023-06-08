package app.valenota.repository

import app.valenota.model.dto.CompanyDTO
import app.valenota.model.entity.Company
import app.valenota.model.form.CompanyForm
import org.springframework.data.repository.CrudRepository

interface ICompanyRepository : CrudRepository<Company, String> {

}