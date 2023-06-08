package app.valenota.service

import app.valenota.model.dto.PersonDTO
import app.valenota.model.dto.TokenDTO
import app.valenota.model.form.LoginFormDTO
import app.valenota.model.form.PersonForm
import org.springframework.stereotype.Service

@Service
interface IPersonService {
    fun create(personForm: PersonForm): PersonDTO
    fun login(loginFormDTO: LoginFormDTO): TokenDTO
}