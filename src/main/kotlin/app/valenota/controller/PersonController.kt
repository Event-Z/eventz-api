package app.valenota.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {
    @PostMapping
    fun test() = try {
        ResponseEntity.ok("Rodando na porta 8080")
    } catch (error: Exception) {
        ResponseEntity.badRequest()
    }

    @GetMapping
    fun test2() = try {
        ResponseEntity.ok("Rodando na porta 8080")
    } catch (error: Exception) {
        ResponseEntity.badRequest()
    }
}