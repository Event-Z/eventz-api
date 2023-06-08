package app.valenota.controller

import app.valenota.model.form.CompanyForm
import app.valenota.service.ICompanyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/company")
class CompanyController(val companyService: ICompanyService) {

    @PostMapping
    fun create(@RequestBody companyForm: CompanyForm) = try {

        companyService.create(companyForm)

    } catch (error:Exception) {

        ResponseEntity.badRequest()
    }
}