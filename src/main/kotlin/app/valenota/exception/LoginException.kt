package app.valenota.exception

import app.valenota.model.feedback.Message.INCORRECT_CREDENTIALS

class LoginException: RuntimeException(INCORRECT_CREDENTIALS) {
    val code = 401
}