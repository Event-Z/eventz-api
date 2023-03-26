package app.valenota.repository

import app.valenota.model.entity.SessionToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ISessionTokenRepository: CrudRepository<SessionToken, String> {
    fun findByPersonIdAndExpired(personId: String, expired: Boolean): Optional<SessionToken>
    fun findByTokenAndExpired(token: String, expired: Boolean): Optional<SessionToken>
}