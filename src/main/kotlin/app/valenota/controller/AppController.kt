package app.valenota.controller

import app.valenota.repository.ISessionTokenRepository
import app.valenota.util.CryptographyUtil.Companion.encodeWithMD5
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult

open class AppController(private val sessionTokenRepository: ISessionTokenRepository) {
    protected fun formatErrors(bindingResult: BindingResult): ResponseEntity<Any> {
        val errors = ArrayList<String>()
        bindingResult.allErrors.forEach {
            errors.add(it.defaultMessage!!)
        }
        return ResponseEntity.badRequest().body(errors)
    }

    protected fun verifyToken(sessionToken: String) = try {
        sessionTokenRepository
            .findByTokenAndExpired(encodeWithMD5(sessionToken), false)
            .isPresent
    } catch (e: Exception) {
        false
    }

    protected fun get(sessionToken: String) =
        sessionTokenRepository
            .findByTokenAndExpired(encodeWithMD5(sessionToken), false)
            .get()
}