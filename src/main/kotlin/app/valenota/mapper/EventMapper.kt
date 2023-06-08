package app.valenota.mapper

import app.valenota.model.dto.EventDTO
import app.valenota.model.entity.Address
import app.valenota.model.entity.Event
import app.valenota.model.form.AddressForm
import app.valenota.model.form.CompanyForm
import app.valenota.model.form.EventForm


class EventMapper {

    fun toEvent(eventForm: EventForm) = Event(

            date_event = eventForm.date_event,
            price = eventForm.price,
            name = eventForm.name,

            address = AddressForm(

                    street = eventForm.addressForm.street,
                    city = eventForm.addressForm.city,
                    district = eventForm.addressForm.district,
                    number = eventForm.addressForm.number,
                    cep = eventForm.addressForm.cep
            ),

            company = CompanyForm(

                    name = eventForm.companyForm.name,
                    cnpj = eventForm.companyForm.cnpj,
                    password = eventForm.companyForm.password,
                    address = eventForm.companyForm.address

            ),


    )

    fun toEventDTO(event: Event) = EventDTO(

            id = event.id,
            date_event = event.date_event,
            price = event.price,
            name = event.name

    )
}