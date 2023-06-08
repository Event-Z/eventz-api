package app.valenota.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity(name = "session_token")
class SessionToken {
    @Id
    @Column(name = "token")
    lateinit var token: String
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    var person: Person? = null
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    var company: Company? = null
    @Column(name = "expired")
    var expired: Boolean = false
    @Column(name = "created_at")
    val createdAt: LocalDateTime? = null
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime? = null

    constructor(token: String, person: Person, expired: Boolean) {
        this.token = token
        this.person = person
        this.expired = expired
    }

    constructor(token: String, company: Company, expired: Boolean) {
        this.token = token
        this.company = company
        this.expired = expired
    }

    constructor()
}