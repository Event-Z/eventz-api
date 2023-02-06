package app.valenota.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Id
import java.util.UUID

class Address {
    @Id
    @Column(name = "id")
    val id = UUID.randomUUID().toString()
    @Column(name = "street")
    lateinit var street: String
    @Column(name = "city")
    lateinit var city: String
    @Column(name = "number")
    lateinit var number: Number
    @Column(name = "cep")
    lateinit var cep: String

    constructor(street: String, city: String, number: Number, cep: String) {
        this.street = street
        this.city = city
        this.number = number
        this.cep = cep
    }

    constructor()
}