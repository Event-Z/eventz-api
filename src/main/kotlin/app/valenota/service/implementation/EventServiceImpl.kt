package app.valenota.service.implementation


import app.valenota.mapper.AddressMapper
import app.valenota.mapper.EventMapper
import app.valenota.model.dto.EventDTO
import app.valenota.model.form.EventForm
import app.valenota.repository.IEventRepository
import app.valenota.service.ICompanyService
import app.valenota.service.IEventService
import org.springframework.stereotype.Service
import kotlin.RuntimeException

@Service
class EventServiceImpl(
    val eventRepository: IEventRepository,
    val companyService: ICompanyService
) : IEventService {
    override fun create(eventForm: EventForm): EventDTO {
        val mapper = EventMapper()
        val event = mapper.toEvent(eventForm)
        val company = companyService.findById(eventForm.companyId)
        event.company = company
        return mapper.toEventDTO(eventRepository.save(event))
    }

    override fun update(id: String, eventForm: EventForm): EventDTO {
        val mapper = EventMapper()
        val eventOp = eventRepository.findById(id)
        if (eventOp.isPresent && eventOp.get().company.id == eventForm.companyId) {
            val event = eventOp.get()
            event.name = eventForm.name
            event.dateEvent = eventForm.dateEvent
            event.price = eventForm.price
            event.address = AddressMapper().toAddress(eventForm.address)
            return mapper.toEventDTO(eventRepository.save(event))
        }
        throw RuntimeException("O evento não pertence à empresa (${eventForm.companyId})")
    }

    override fun list(id: String): List<EventDTO> {
        return eventRepository.findAll()
            .filter { it.company.id == id }
            .map { EventMapper().toEventDTO(it) }
    }

    override fun delete(id: String, companyId: String) {
        val event = eventRepository.findById(id)
        if (event.get().company.id == companyId)
            eventRepository.deleteById(id)
        else
            throw RuntimeException("O evento não pertence à empresa ($companyId)")
    }
}