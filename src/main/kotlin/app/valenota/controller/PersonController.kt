package app.valenota.controller

import app.valenota.model.form.PersonForm
import app.valenota.service.IPersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController(val personService: IPersonService) {
    @PostMapping
    fun create(@RequestBody personForm: PersonForm) = try {
        personService.create(personForm)
    } catch (error: Exception) {
        ResponseEntity.badRequest()
    }
}