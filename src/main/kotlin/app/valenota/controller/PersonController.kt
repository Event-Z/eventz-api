package app.valenota.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {
    @PostMapping
    fun create() = try {

    } catch (error: Exception) {
        ResponseEntity.badRequest()
    }
}