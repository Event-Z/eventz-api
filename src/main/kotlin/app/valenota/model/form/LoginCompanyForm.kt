package app.valenota.model.form

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.br.CNPJ

class LoginCompanyForm (
    @field:NotNull(message = "CNPJ não pode ser nulo!")
    @field:CNPJ(message = "CNPJ inválido!")
    val cnpj: String,

    @field:NotNull(message = "password não pode ser nulo!")
    @field:Pattern(
        regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\$*&@#])[0-9a-zA-Z\$*&@#]{8,}\$",
        message = "Senha fraca ou inválida!"
    )
    val password: String
)