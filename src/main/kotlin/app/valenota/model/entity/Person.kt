package app.valenota.model.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import java.util.UUID

@Entity(name = "person")
class Person {
    @Id
    @Column(name = "id")
    val id = UUID.randomUUID().toString()
    @Column(name = "name")
    lateinit var name: String
    @Column(name = "cpf")
    lateinit var cpf: String
    @Column(name = "password")
    lateinit var password: String
    @OneToOne(cascade = [CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "address_id")
    lateinit var address: Address
    constructor(name: String, cpf: String, password: String, address: Address) {
        this.name = name
        this.cpf = cpf
        this.password = password
        this.address = address
    }

    constructor()
}