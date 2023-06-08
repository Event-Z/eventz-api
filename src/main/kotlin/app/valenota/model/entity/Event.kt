package app.valenota.model.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.time.LocalDateTime
import java.util.*

@Builder // Gerar um Objeto com a classe
@Data  // Fazer Get, Set e To String
@Entity // Para dizer uma Entidade
@AllArgsConstructor // Cria um construtor com todos os argumentos
@NoArgsConstructor // Cria um construtor sem nenhum argumento
@Table(name = "event")
class Event {

    @Id
    @Column(name = "id")
    val id = UUID.randomUUID().toString()

    @Column(name = "date_event")
    lateinit var date_event: LocalDateTime

    @Column(name = "price")
    var price: Double = 0.0
    
    @Column(name = "name")
    lateinit var name: String

    @OneToOne(cascade = [CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "address_id")
    lateinit var address: Address

    constructor(date_event: LocalDateTime, price: Double, name: String, address: Address) {

        this.date_event = date_event
        this.price = price
        this.name = name
        this.address = address
    }

    constructor()

}