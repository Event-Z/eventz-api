package app.valenota.service

import app.valenota.model.dto.EventDTO
import app.valenota.model.form.EventForm

interface IEventService {

    fun create(eventForm: EventForm): EventDTO
}