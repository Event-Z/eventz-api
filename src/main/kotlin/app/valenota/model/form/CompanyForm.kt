package app.valenota.model.form

data class CompanyForm(
        val name: String,
        val cnpj: String,
        val password: String,
        val address: AddressForm
)
