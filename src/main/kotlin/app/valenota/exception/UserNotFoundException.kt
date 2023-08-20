package app.valenota.exception

import app.valenota.model.feedback.Message.USER_NOT_FOUND
import org.springframework.http.HttpStatus
class UserNotFoundException(
    val code: HttpStatus = HttpStatus.NOT_FOUND
): RuntimeException(USER_NOT_FOUND)