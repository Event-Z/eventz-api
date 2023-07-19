package app.valenota.mapper

import app.valenota.model.dto.CompanyDTO
import app.valenota.model.dto.EventDTO
import app.valenota.model.entity.Event
import app.valenota.model.form.EventForm

class EventMapper {
    fun toEvent(eventForm: EventForm) = Event(
            dateEvent = eventForm.dateEvent,
            price = eventForm.price,
            name = eventForm.name,
            address = AddressMapper().toAddress(eventForm.address)
    )

    fun toEventDTO(event: Event) = EventDTO(
            id = event.id,
            dateEvent = event.dateEvent,
            price = event.price,
            name = event.name,
            address = AddressMapper().toAddressDTO(event.address),
            company = CompanyDTO(
                id = event.owner.id,
                name = event.owner.name,
                email = event.owner.email,
                cnpj = event.owner.cnpj!!
            )
    )
}