package app.valenota.exception

import app.valenota.model.feedback.Message.INVALID_FOLLOWED
import org.springframework.http.HttpStatus

class InvalidFollowedException(
    val code: HttpStatus = HttpStatus.BAD_REQUEST
): RuntimeException(INVALID_FOLLOWED)