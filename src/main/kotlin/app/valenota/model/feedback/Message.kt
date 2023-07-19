package app.valenota.model.feedback

object Message {
    val DEFAULT_ERROR: String
        get() = "Erro não experado!"

    val EVENT_DOES_NOT_BELONG_TO_USER: String
        get() = "O evento não pertence ao usuário!"

    val USER_EXISTS: String
        get() = "Esse email já está em uso!"

    val INCORRECT_CREDENTIALS: String
        get() = "Crendenciais de acesso incorretas!"
}