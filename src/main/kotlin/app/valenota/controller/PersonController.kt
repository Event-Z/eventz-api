package app.valenota.controller

import app.valenota.exception.LoginException
import app.valenota.model.form.LoginFormDTO
import app.valenota.model.form.PersonForm
import app.valenota.repository.ISessionTokenRepository
import app.valenota.service.IPersonService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController(
    val personService: IPersonService,
    sessionTokenRepository: ISessionTokenRepository
): AppController(sessionTokenRepository) {
    @PostMapping
    fun create(@RequestBody personForm: PersonForm) = try {
        personService.create(personForm)
    } catch (error: Exception) {
        ResponseEntity.badRequest()
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginFormDTO: LoginFormDTO, bindingResult: BindingResult) = try {
        if (bindingResult.hasErrors()) {
            formatErrors(bindingResult)
        }
        personService.login(loginFormDTO)
    } catch (e: LoginException) {
        ResponseEntity.status(e.code).body(e.message)
    } catch (e: Exception) {
        ResponseEntity.status(500).body(e.message)
    }
}