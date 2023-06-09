package app.valenota.controller

import app.valenota.exception.LoginException
import app.valenota.model.form.CompanyForm
import app.valenota.model.form.LoginCompanyForm
import app.valenota.model.form.LoginFormDTO
import app.valenota.repository.ISessionTokenRepository
import app.valenota.service.ICompanyService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/company")
class CompanyController(
    val companyService: ICompanyService,
    sessionTokenRepository: ISessionTokenRepository
): AppController(sessionTokenRepository) {
    @PostMapping
    fun create(@RequestBody companyForm: CompanyForm) = try {
        companyService.create(companyForm)
    } catch (error:Exception) {
        ResponseEntity.badRequest()
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginCompanyForm: LoginCompanyForm, bindingResult: BindingResult) = try {
        if (bindingResult.hasErrors()) {
            formatErrors(bindingResult)
        }
        companyService.login(loginCompanyForm)
    } catch (e: LoginException) {
        ResponseEntity.status(e.code).body(e.message)
    } catch (e: Exception) {
        ResponseEntity.status(500).body(e.message)
    }
}