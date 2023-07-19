package app.valenota.exception

import app.valenota.model.feedback.Message.USER_EXISTS
import org.springframework.http.HttpStatus

class UserExistsException: RuntimeException(USER_EXISTS) {
    val code = HttpStatus.BAD_REQUEST
}