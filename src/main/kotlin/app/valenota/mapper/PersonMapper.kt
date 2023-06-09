package app.valenota.mapper

import app.valenota.model.dto.PersonDTO
import app.valenota.model.entity.Address
import app.valenota.model.entity.Person
import app.valenota.model.form.PersonForm
import app.valenota.util.CryptographyUtil.Companion.encodeWithMD5

class PersonMapper {

    fun toPerson(personForm: PersonForm) = Person(
        name = personForm.name,
        cpf = personForm.cpf,
        password = encodeWithMD5(personForm.password),
        address = Address(
            street = personForm.address.street,
            city = personForm.address.city,
            district = personForm.address.district,
            number = personForm.address.number,
            cep = personForm.address.cep
        )
    )

    fun toPersonDTO(person: Person) = PersonDTO(
        id = person.id,
        name = person.name,
        cpf = person.cpf
    )
}