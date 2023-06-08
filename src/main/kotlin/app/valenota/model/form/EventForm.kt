package app.valenota.model.form
import java.time.LocalDateTime

data class EventForm(

        val date_event: LocalDateTime,
        val price: Double,
        val name: String,
        val addressForm: AddressForm,
        val companyForm: CompanyForm
) {

}
