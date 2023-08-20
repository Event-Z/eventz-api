package app.valenota.service

import app.valenota.model.entity.User
import app.valenota.model.form.NetworkForm
import org.springframework.stereotype.Service

@Service
interface INetworkService {
    fun follow(networkForm: NetworkForm, user: User)
}
