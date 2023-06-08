package app.valenota.model.entity

import jakarta.persistence.*

import java.util.UUID

@Entity(name = "company")
class Company {

    @Id
    @Column(name = "id")
    val id = UUID.randomUUID().toString()

    @Column(name = "name")
    lateinit var name: String

    @Column(name = "cnpj")
    lateinit var cnpj: String

    @Column(name = "password")
    lateinit var password: String

    @OneToOne(cascade = [CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "address_id")
    lateinit var address: Address

    constructor(name: String, cnpj: String, password: String, address: Address) {

        this.name = name
        this.cnpj = cnpj
        this.password = password
        this.address = address
    }

    constructor()


}