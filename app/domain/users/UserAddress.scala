package domain.users

import java.time.{LocalDateTime => Date}

import play.api.libs.json.Json

case class UserAddress(emailId: String,
                       id: String,
                       addressTypeId: String,
                       description: String,
                       postalCode: String,
                       date: Date,
                       state: String)

object UserAddress {
  implicit val userAddressFmt = Json.format[UserAddress]
  def identity: UserAddress = UserAddress("", "", "", "", "", Date.now(), "")
}
