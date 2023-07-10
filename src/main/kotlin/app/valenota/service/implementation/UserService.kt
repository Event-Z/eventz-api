package app.valenota.service.implementation

import app.valenota.exception.LoginException
import app.valenota.mapper.UserMapper
import app.valenota.model.dto.PersonDTO
import app.valenota.model.dto.TokenDTO
import app.valenota.model.entity.User
import app.valenota.model.entity.User.Role.COMPANY
import app.valenota.model.entity.User.Role.PERSON
import app.valenota.model.form.LoginFormDTO
import app.valenota.model.form.PersonForm
import app.valenota.repository.IUserRepository
import app.valenota.service.ISessionTokenService
import app.valenota.service.IUserService
import app.valenota.util.CryptographyUtil
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: IUserRepository,
    private val sessionTokenService: ISessionTokenService
) : IUserService {
    override fun create(personForm: PersonForm): PersonDTO {
        val mapper = UserMapper()
        val person = mapper.toPerson(personForm)
        return mapper.toPersonDTO(userRepository.save(person))
    }

    override fun login(loginFormDTO: LoginFormDTO): TokenDTO {
        val opUser = userRepository.findByEmailAndPassword(loginFormDTO.email,
            CryptographyUtil.encodeWithMD5(loginFormDTO.password)
        )
        if (opUser.isPresent) {
            val user = opUser.get()
            val userMapper = UserMapper()
            return TokenDTO(
                sessionTokenService.configureSessionToken(user),
                when (user.role) {
                    COMPANY -> userMapper.toCompanyDTO(user)
                    PERSON -> userMapper.toPersonDTO(user)
                }
            )
        }
        throw LoginException()
    }

    override fun findById(id: String): User {
        return userRepository.findById(id).get()
    }
}