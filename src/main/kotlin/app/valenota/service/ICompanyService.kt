package app.valenota.service

import app.valenota.model.dto.CompanyDTO
import app.valenota.model.form.CompanyForm

interface ICompanyService {

    fun create(companyForm: CompanyForm) : CompanyDTO
}