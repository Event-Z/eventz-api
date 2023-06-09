package app.valenota.mapper

import app.valenota.model.dto.CompanyDTO
import app.valenota.model.dto.EventDTO
import app.valenota.model.entity.Address
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
                id = event.company.id,
                name = event.company.name,
                cnpj = event.company.cnpj
            )
    )
}