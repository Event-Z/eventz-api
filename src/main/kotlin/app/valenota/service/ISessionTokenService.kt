package app.valenota.service

import app.valenota.model.entity.SessionToken
import app.valenota.model.entity.User
import org.springframework.stereotype.Service
import java.util.*

@Service
interface ISessionTokenService {
    fun findByUserIdAndExpired(userId: String, expired: Boolean): Optional<SessionToken>
    fun findByTokenAndExpired(token: String, expired: Boolean): Optional<SessionToken>
    fun configureSessionToken(user: User): String
}