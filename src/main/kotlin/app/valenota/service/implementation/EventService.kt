package app.valenota.service.implementation

import app.valenota.exception.EventException
import app.valenota.mapper.AddressMapper
import app.valenota.mapper.EventMapper
import app.valenota.model.dto.EventDTO
import app.valenota.model.form.EventForm
import app.valenota.repository.IEventRepository
import app.valenota.service.IUserService
import app.valenota.service.IEventService
import org.springframework.stereotype.Service

@Service
class EventService(
    private val eventRepository: IEventRepository,
    private val userService: IUserService
) : IEventService {
    override fun create(eventForm: EventForm): EventDTO {
        val mapper = EventMapper()
        val event = mapper.toEvent(eventForm)
        val user = userService.findById(eventForm.owner)
        event.owner = user
        return mapper.toEventDTO(eventRepository.save(event))
    }

    override fun update(id: String, eventForm: EventForm): EventDTO {
        val mapper = EventMapper()
        val eventOp = eventRepository.findById(id)
        if (eventOp.isPresent && eventOp.get().owner.id == eventForm.owner) {
            val event = eventOp.get()
            event.name = eventForm.name
            event.dateEvent = eventForm.dateEvent
            event.price = eventForm.price
            event.address = AddressMapper().toAddress(eventForm.address)
            return mapper.toEventDTO(eventRepository.save(event))
        }
        throw EventException()
    }

    override fun list(id: String): List<EventDTO> {
        return eventRepository.findAll()
            .filter { it.owner.id == id }
            .map { EventMapper().toEventDTO(it) }
    }

    override fun delete(id: String, companyId: String) {
        val event = eventRepository.findById(id)
        if (event.get().owner.id == companyId)
            eventRepository.deleteById(id)
        else
            throw EventException()
    }
}