package app.valenota.mapper

import app.valenota.model.dto.EventDTO
import app.valenota.model.entity.Address
import app.valenota.model.entity.Event
import app.valenota.model.form.EventForm


class EventMapper {

    fun toEvent(eventForm: EventForm) = Event(

            date_event = eventForm.date_event,
            price = eventForm.price,
            name = eventForm.name,

            address = Address(

                    street = eventForm.address.street,
                    city = eventForm.address.city,
                    district = eventForm.address.district,
                    number = eventForm.address.number,
                    cep = eventForm.address.cep
            )
    )

    fun toEventDTO(event: Event) = EventDTO(

            id = event.id,
            date_event = event.date_event,
            price = event.price,
            name = event.name

    )
}