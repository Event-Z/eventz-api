package app.valenota.service.implementation

import app.valenota.exception.LoginException
import app.valenota.mapper.PersonMapper
import app.valenota.model.dto.PersonDTO
import app.valenota.model.dto.TokenDTO
import app.valenota.model.entity.Person
import app.valenota.model.entity.SessionToken
import app.valenota.model.form.LoginFormDTO
import app.valenota.model.form.PersonForm
import app.valenota.repository.IPersonRepository
import app.valenota.repository.ISessionTokenRepository
import app.valenota.service.IPersonService
import app.valenota.util.CryptographyUtil.Companion.encodeWithMD5
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PersonServiceImpl(
    val personRepository: IPersonRepository,
    val sessionTokenRepository: ISessionTokenRepository
) : IPersonService {
    override fun create(personForm: PersonForm): PersonDTO {
        val mapper = PersonMapper()
        val person = mapper.toPerson(personForm)
        return mapper.toPersonDTO(personRepository.save(person))
    }

    override fun login(loginFormDTO: LoginFormDTO): TokenDTO {
        val opPerson = personRepository.findByCpfAndPassword(loginFormDTO.cpf, encodeWithMD5(loginFormDTO.password))
        if (opPerson.isPresent) {
            val person = opPerson.get()
            return TokenDTO(configureSessionToken(person), PersonMapper().toPersonDTO(person))
        }
        throw LoginException()
    }

    private fun configureSessionToken(person: Person): String {
        val opSessionTokenActive = sessionTokenRepository.findByPersonIdAndExpired(person.id, false)

        if (opSessionTokenActive.isPresent) {
            val sessionTokenActive = opSessionTokenActive.get()
            sessionTokenActive.expired = true
            sessionTokenRepository.save(sessionTokenActive)
        }

        val token = "${person.id}--${UUID.randomUUID()}"
        val tokenEncoded = encodeWithMD5(token)

        val newSessionToken = SessionToken(tokenEncoded, person, false)
        sessionTokenRepository.save(newSessionToken)

        return token
    }
}