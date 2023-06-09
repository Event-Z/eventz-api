package app.valenota.service.implementation

import app.valenota.exception.LoginException
import app.valenota.mapper.CompanyMapper
import app.valenota.mapper.PersonMapper
import app.valenota.model.dto.CompanyDTO
import app.valenota.model.dto.TokenDTO
import app.valenota.model.entity.Company
import app.valenota.model.entity.SessionToken
import app.valenota.model.form.CompanyForm
import app.valenota.model.form.LoginCompanyForm
import app.valenota.repository.ICompanyRepository
import app.valenota.repository.ISessionTokenRepository
import app.valenota.service.ICompanyService
import app.valenota.util.CryptographyUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyServiceImpl(
    val companyRepository: ICompanyRepository,
    val sessionTokenRepository: ISessionTokenRepository
) : ICompanyService {
    override fun create(companyForm: CompanyForm): CompanyDTO {

        val mapper = CompanyMapper()
        val company = mapper.toCompany(companyForm)

        return mapper.toCompanyDTO(companyRepository.save(company))
    }

    override fun findById(id: String): Company {
        return companyRepository.findById(id).get()
    }

    override fun login(loginCompanyForm: LoginCompanyForm): TokenDTO {
        val opCompany = companyRepository.findByCnpjAndPassword(loginCompanyForm.cnpj,
            CryptographyUtil.encodeWithMD5(loginCompanyForm.password))
        if (opCompany.isPresent) {
            val company = opCompany.get()
            return TokenDTO(configureSessionToken(company), CompanyMapper().toCompanyDTO(company))
        }
        throw LoginException()
    }

    private fun configureSessionToken(company: Company): String {
        val opSessionTokenActive = sessionTokenRepository.findByPersonIdAndExpired(company.id, false)

        if (opSessionTokenActive.isPresent) {
            val sessionTokenActive = opSessionTokenActive.get()
            sessionTokenActive.expired = true
            sessionTokenRepository.save(sessionTokenActive)
        }

        val token = "${company.id}--${UUID.randomUUID()}"
        val tokenEncoded = CryptographyUtil.encodeWithMD5(token)

        val newSessionToken = SessionToken(tokenEncoded, company, false)
        sessionTokenRepository.save(newSessionToken)

        return token
    }
}