package app.valenota.model.dto

import java.time.LocalDateTime

data class EventDTO(

    val id: String,
    val dateEvent: LocalDateTime,
    val price: Double,
    val name: String,
    val company: CompanyDTO,
    val address: AddressDTO
)
