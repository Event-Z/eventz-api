package app.valenota.service

import app.valenota.model.dto.CompanyDTO
import app.valenota.model.dto.TokenDTO
import app.valenota.model.entity.Company
import app.valenota.model.form.CompanyForm
import app.valenota.model.form.LoginCompanyForm

interface ICompanyService {
    fun create(companyForm: CompanyForm) : CompanyDTO
    fun findById(id: String): Company
    fun login(loginCompanyForm: LoginCompanyForm): TokenDTO
}