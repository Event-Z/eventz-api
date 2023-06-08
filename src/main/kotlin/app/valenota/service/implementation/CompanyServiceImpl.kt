package app.valenota.service.implementation

import app.valenota.mapper.CompanyMapper
import app.valenota.model.dto.CompanyDTO
import app.valenota.model.form.CompanyForm
import app.valenota.repository.ICompanyRepository
import app.valenota.service.ICompanyService

import org.springframework.stereotype.Service

@Service
class CompanyServiceImpl(val companyRepository: ICompanyRepository) : ICompanyService {

    override fun create(companyForm: CompanyForm): CompanyDTO {

        val mapper = CompanyMapper()
        val company = mapper.toCompany(companyForm)

        return mapper.toCompanyDTO(companyRepository.save(company))
    }

}