package app.valenota.exception

import app.valenota.model.feedback.Message.EVENT_DOES_NOT_BELONG_TO_USER
import org.springframework.http.HttpStatus

class EventException: RuntimeException(EVENT_DOES_NOT_BELONG_TO_USER) {
    val code = HttpStatus.FORBIDDEN
}