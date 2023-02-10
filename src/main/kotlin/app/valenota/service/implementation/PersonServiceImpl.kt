package app.valenota.service.implementation

import app.valenota.mapper.PersonMapper
import app.valenota.model.dto.PersonDTO
import app.valenota.model.form.PersonForm
import app.valenota.repository.IPersonRepository
import app.valenota.service.IPersonService
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(val personRepository: IPersonRepository) : IPersonService {
    override fun create(personForm: PersonForm): PersonDTO {
        val mapper = PersonMapper()
        return mapper.toPersonDTO(personRepository.save(mapper.toPerson(personForm)))
    }
}