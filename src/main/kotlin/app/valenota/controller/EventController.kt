package app.valenota.controller

import app.valenota.model.form.EventForm
import app.valenota.service.IEventService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/event")
class EventController(val eventService: IEventService) {

    @PostMapping
    fun create(@RequestBody eventForm: EventForm) = try {

        eventService.create(eventForm)

    } catch (error:Exception) {

        ResponseEntity.badRequest()
    }

}