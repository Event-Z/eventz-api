package app.valenota.service.implementation


import app.valenota.mapper.EventMapper
import app.valenota.model.dto.EventDTO
import app.valenota.model.form.EventForm
import app.valenota.repository.IEventRepository
import app.valenota.service.IEventService
import org.springframework.stereotype.Service

@Service
class EventServiceImpl(val eventRepository: IEventRepository) : IEventService {
    override fun create(eventForm: EventForm): EventDTO {
        val mapper = EventMapper()
        val event = mapper.toEvent(eventForm)

        return mapper.toEventDTO(eventRepository.save(event));
    }
}