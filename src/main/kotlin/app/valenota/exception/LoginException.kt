package app.valenota.exception

import app.valenota.model.feedback.Message.INCORRECT_CREDENTIALS
import org.springframework.http.HttpStatus

class LoginException(
    val code: HttpStatus = HttpStatus.UNAUTHORIZED
): RuntimeException(INCORRECT_CREDENTIALS)