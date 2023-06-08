package app.valenota.model.entity

<<<<<<< HEAD
import jakarta.persistence.*

=======
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
>>>>>>> e8c626ed2a1bf57c2668729984f1fd0739da9439
import java.util.UUID

@Entity(name = "company")
class Company {
<<<<<<< HEAD

    @Id
    @Column(name = "id")
    val id = UUID.randomUUID().toString()

    @Column(name = "name")
    lateinit var name: String

    @Column(name = "cnpj")
    lateinit var cnpj: String

    @Column(name = "password")
    lateinit var password: String

=======
    @Id
    @Column(name = "id")
    val id = UUID.randomUUID().toString()
    @Column(name = "name")
    lateinit var name: String
    @Column(name = "cnpj")
    lateinit var cnpj: String
    @Column(name = "password")
    lateinit var password: String
>>>>>>> e8c626ed2a1bf57c2668729984f1fd0739da9439
    @OneToOne(cascade = [CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "address_id")
    lateinit var address: Address

    constructor(name: String, cnpj: String, password: String, address: Address) {
<<<<<<< HEAD

=======
>>>>>>> e8c626ed2a1bf57c2668729984f1fd0739da9439
        this.name = name
        this.cnpj = cnpj
        this.password = password
        this.address = address
    }

    constructor()
<<<<<<< HEAD


=======
>>>>>>> e8c626ed2a1bf57c2668729984f1fd0739da9439
}