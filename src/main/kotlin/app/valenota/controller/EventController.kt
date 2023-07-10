package app.valenota.controller

import app.valenota.model.form.EventForm
import app.valenota.service.IEventService
import app.valenota.service.ISessionTokenService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/event")
class EventController(
    private val eventService: IEventService,
    sessionTokenService: ISessionTokenService
): AppController(sessionTokenService) {
    @PostMapping
    fun create(@RequestBody eventForm: EventForm, @RequestHeader sessionToken: String) = try {
        if (verifyToken(sessionToken)) {
            eventForm.owner = get(sessionToken).user!!.id
            ResponseEntity.ok(eventService.create(eventForm))
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null)
        }
    } catch (error: Exception) {
        ResponseEntity.badRequest()
    }

    @PatchMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @RequestBody eventForm: EventForm,
        @RequestHeader sessionToken: String
    ) = try {
        if (verifyToken(sessionToken)) {
            eventForm.owner = get(sessionToken).user!!.id
            ResponseEntity.ok(eventService.update(id, eventForm))
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null)
        }
    } catch (error: Exception) {
        ResponseEntity.badRequest()
    }

    @GetMapping("/list")
    fun list(@RequestHeader sessionToken: String) = try {
        if (verifyToken(sessionToken)) {
            ResponseEntity.ok(eventService.list(get(sessionToken).user!!.id))
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null)
        }
    } catch (error: Exception) {
        ResponseEntity.badRequest()
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: String,
        @RequestHeader sessionToken: String
    ) = try {
        if (verifyToken(sessionToken)) {
            ResponseEntity.ok(eventService.delete(id, get(sessionToken).user!!.id))
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null)
        }
    } catch (error: Exception) {
        ResponseEntity.badRequest()
    }
}