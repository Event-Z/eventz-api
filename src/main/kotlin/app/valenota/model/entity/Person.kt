package app.valenota.model.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.util.UUID

@Builder // Gerar um Objeto com a classe
@Data  // Fazer Get, Set e To String
@Entity // Para dizer uma Entidade
@AllArgsConstructor // Cria um construtor com todos os argumentos
@NoArgsConstructor // Cria um construtor sem nenhum argumento
@Table(name = "person")
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