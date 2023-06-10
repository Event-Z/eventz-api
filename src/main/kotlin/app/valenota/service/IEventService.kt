package app.valenota.service

import app.valenota.model.dto.EventDTO
import app.valenota.model.form.EventForm

interface IEventService {

    fun create(eventForm: EventForm): EventDTO
    fun update(id: String, eventForm: EventForm): EventDTO
    fun list(id: String): List<EventDTO>
    fun delete(id: String, companyId: String)
}