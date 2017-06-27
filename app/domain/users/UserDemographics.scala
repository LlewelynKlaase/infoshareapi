package domain.users

import java.time.{LocalDateTime => Date}
import play.api.libs.json.Json

case class UserDemographics(emailId: String,
                            id: String,
                            genderId: String,
                            raceId: String,
                            dateOfBirth: Date,
                            maritalStatusId: String,
                            numberOfDependencies: Int,
                            date: Date,
                            state: String)

object UserDemographics {
  implicit val userDemoFmt = Json.format[UserDemographics]
  def identity: UserDemographics = UserDemographics("", "", "", "", Date.now(), "", 0, Date.now(), "")
}
