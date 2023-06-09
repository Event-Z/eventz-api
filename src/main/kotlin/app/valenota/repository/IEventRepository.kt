package app.valenota.repository

import app.valenota.model.entity.Event
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IEventRepository : CrudRepository<Event, String> {
}