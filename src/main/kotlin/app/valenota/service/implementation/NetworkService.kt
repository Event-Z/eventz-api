package app.valenota.service.implementation

import app.valenota.exception.InvalidFollowedException
import app.valenota.model.dto.FollowerListDTO
import app.valenota.model.dto.FollowerDTO
import app.valenota.model.entity.Network
import app.valenota.model.entity.User
import app.valenota.model.form.NetworkForm
import app.valenota.repository.INetworkRepository
import app.valenota.service.INetworkService
import app.valenota.service.IUserService
import org.springframework.stereotype.Service

@Service
class NetworkService(
    val userService: IUserService,
    val networkRepository: INetworkRepository
): INetworkService {
    override fun follow(networkForm: NetworkForm, user: User) {
        if (networkForm.userId == user.id) {
            throw InvalidFollowedException()
        }
        val userFollowed = userService.findById(networkForm.userId)
        val networkOp = networkRepository
            .findByFollowerAndFollowed(user, userFollowed)
        if (networkOp.isEmpty) {
            val network = Network(
                follower = user,
                followed = userFollowed
            )
            networkRepository.save(network)
        }
    }

    override fun listFollowers(followed: User): FollowerListDTO =
        FollowerListDTO(
            networkRepository.findAllByFollowed(followed).map {
                FollowerDTO(it.follower.id, it.follower.name)
            }
        )
}