package app.valenota.mapper

import app.valenota.model.dto.CompanyDTO
import app.valenota.model.dto.PersonDTO
import app.valenota.model.entity.Address
import app.valenota.model.entity.User
import app.valenota.model.form.CompanyForm
import app.valenota.model.form.PersonForm
import app.valenota.util.CryptographyUtil.Companion.encodeWithMD5

class UserMapper {

    fun toPerson(personForm: PersonForm) = User(
        name = personForm.name,
        email = personForm.email,
        password = encodeWithMD5(personForm.password),
        address = Address(
            street = personForm.address.street,
            city = personForm.address.city,
            district = personForm.address.district,
            number = personForm.address.number,
            cep = personForm.address.cep
        )
    )

    fun toPersonDTO(user: User) = PersonDTO(
        id = user.id,
        name = user.name,
        email = user.email
    )

    fun toCompany(companyForm: CompanyForm) = User(
        name = companyForm.name,
        email = companyForm.email,
        cnpj = companyForm.cnpj,
        password = encodeWithMD5(companyForm.password),
        address = Address(
            street = companyForm.address.street,
            city = companyForm.address.city,
            district = companyForm.address.district,
            number = companyForm.address.number,
            cep = companyForm.address.cep
        )
    )

    fun toCompanyDTO(user: User) = CompanyDTO(
        id = user.id,
        name = user.name,
        email = user.email,
        cnpj = user.cnpj!!
    )
}