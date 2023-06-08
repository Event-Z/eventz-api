package app.valenota.model.dto

import java.time.LocalDateTime

data class EventDTO(

        val id: String,
        val date_event: LocalDateTime,
        val price: Double,
        val name: String,

        )
