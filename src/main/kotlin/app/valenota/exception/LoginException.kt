package app.valenota.exception

class LoginException: RuntimeException("Crendenciais de acesso incorretas!") {
    val code = 401
}