package app.valenota.model.form
import java.time.LocalDateTime

data class EventForm(
        val dateEvent: LocalDateTime,
        val price: Double,
        val name: String,
        val address: AddressForm,
        var owner: String
)
