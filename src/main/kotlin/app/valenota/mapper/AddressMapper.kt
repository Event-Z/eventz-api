package app.valenota.mapper

import app.valenota.model.dto.AddressDTO
import app.valenota.model.entity.Address
import app.valenota.model.form.AddressForm

class AddressMapper {
    fun toAddress(addressForm: AddressForm) = Address(
        street = addressForm.street,
        city = addressForm.city,
        district = addressForm.district,
        number = addressForm.number,
        cep = addressForm.cep
    )

    fun toAddressDTO(address: Address) = AddressDTO(
        street = address.street,
        city = address.city,
        district = address.district,
        number = address.number,
        cep = address.cep
    )
}