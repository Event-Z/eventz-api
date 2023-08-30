package app.valenota.repository

import app.valenota.model.entity.Network
import app.valenota.model.entity.User
import java.util.Optional
import org.springframework.data.repository.CrudRepository

interface INetworkRepository: CrudRepository<Network, String> {
    fun findByFollowerAndFollowed(follower: User, followed: User): Optional<Network>
    fun findAllByFollowed(followed: User): List<Network>
}