package app.valenota.mapper

import app.valenota.model.dto.CompanyDTO
import app.valenota.model.entity.Address
import app.valenota.model.entity.Company
import app.valenota.model.form.CompanyForm

class CompanyMapper {

    fun toCompany(companyForm: CompanyForm) = Company(

            name = companyForm.name,
            cnpj = companyForm.cnpj,
            password = companyForm.password,

            address = Address(

                street = companyForm.address.street,
                city = companyForm.address.city,
                district = companyForm.address.district,
                number = companyForm.address.number,
                cep = companyForm.address.cep
            )
    )

    fun toCompanyDTO(company: Company) = CompanyDTO(

            id = company.id,
            name = company.name,
            cnpj = company.cnpj
    )
}