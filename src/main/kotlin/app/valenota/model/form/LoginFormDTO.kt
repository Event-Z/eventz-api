package app.valenota.model.form

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.br.CPF

data class LoginFormDTO(
    @field:NotNull(message = "CPF não pode ser nulo!")
    @field:CPF(message = "CPF inválido!")
    val cpf: String,

    @field:NotNull(message = "password não pode ser nulo!")
    @field:Pattern(
        regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\$*&@#])[0-9a-zA-Z\$*&@#]{8,}\$",
        message = "Senha fraca ou inválida!"
    )
    val password: String
)