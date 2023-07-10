package app.valenota.service

import app.valenota.model.dto.PersonDTO
import app.valenota.model.dto.TokenDTO
import app.valenota.model.entity.User
import app.valenota.model.form.LoginFormDTO
import app.valenota.model.form.PersonForm

interface IUserService {
    fun create(personForm: PersonForm): PersonDTO
    fun login(loginFormDTO: LoginFormDTO): TokenDTO
    fun findById(id: String): User
}