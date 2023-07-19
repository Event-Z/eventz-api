package app.valenota.controller

import app.valenota.exception.LoginException
import app.valenota.exception.UserExistsException
import app.valenota.model.dto.ErrorDTO
import app.valenota.model.feedback.Message.DEFAULT_ERROR
import app.valenota.model.form.CompanyForm
import app.valenota.model.form.LoginFormDTO
import app.valenota.model.form.PersonForm
import app.valenota.service.ISessionTokenService
import app.valenota.service.IUserService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: IUserService,
    sessionTokenService: ISessionTokenService
): AppController(sessionTokenService) {
    @PostMapping
    fun create(@RequestBody personForm: PersonForm) = try {
        userService.create(personForm)
    } catch (error: UserExistsException) {
        ResponseEntity.status(error.code).body(ErrorDTO(error.message!!))
    } catch (error: Exception) {
        ResponseEntity.internalServerError().body(ErrorDTO(DEFAULT_ERROR))
    }

    @PostMapping("/company")
    fun create(@RequestBody companyForm: CompanyForm) = try {
        userService.create(companyForm)
    } catch (error: UserExistsException) {
        ResponseEntity.status(error.code).body(ErrorDTO(error.message!!))
    } catch (error: Exception) {
        ResponseEntity.internalServerError().body(ErrorDTO(DEFAULT_ERROR))
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginFormDTO: LoginFormDTO, bindingResult: BindingResult) = try {
        if (bindingResult.hasErrors()) {
            formatErrors(bindingResult)
        }
        userService.login(loginFormDTO)
    } catch (error: LoginException) {
        ResponseEntity.status(error.code).body(ErrorDTO(error.message!!))
    } catch (error: Exception) {
        ResponseEntity.internalServerError().body(ErrorDTO(DEFAULT_ERROR))
    }
}