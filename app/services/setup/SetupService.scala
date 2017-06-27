package services.setup

import com.outworkers.phantom.dsl.{ResultSet, context}
import repositories.content._
import repositories.demographics._
import repositories.location._
import repositories.organisation._
import repositories.storage._
import repositories.syslog._
import repositories.users._
import repositories.util._

import scala.concurrent.Future

/**
  * Created by hashcode on 2017/04/21.
  */
object SetupService {

  def setup: Future[ResultSet] = {
    implicit val session = UserDatabase.session
    implicit val keyspace = UserDatabase.space

    for {
      //    util
      setup <- ItemStatusDatabase.itemStatusTable.create.ifNotExists().future()
      setup <- KeysDatabase.keysTable.create.ifNotExists().future()
      setup <- MailDatabase.mailTable.create.ifNotExists().future()
      setup <- TokenDatabase.tokenTable.create.ifNotExists().future()
      setup <- RolesDatabase.rolesTable.create.ifNotExists().future()

      //     user
      setup <- UserAddressDatabase.userAddressTable.create.ifNotExists().future()
      setup <- UserContactDatabase.userContactTable.create.ifNotExists().future()
      setup <- UserDemographicsDatabase.userDemographicsTable.create.ifNotExists().future()
      setup <- UserLanguageDatabase.userLanguageTable.create.ifNotExists().future()
      setup <- UserImagesDatabase.userImagesTable.create.ifNotExists().future()
      setup <- UserDatabase.userTable.create.ifNotExists().future()
      setup <- UserDatabase.userTimeLineTable.create.ifNotExists().future()
      setup <- UserRoleDatabase.userRoleTable.create.ifNotExists().future()
      setup <- UserDatabase.siteUserTable.create.ifNotExists().future()
      //      content
      setup <- CategoryDatabase.categoryTable.create.ifNotExists().future()
      setup <- ContentTypeDatabase.contentTypeTable.create.ifNotExists().future()
      setup <- EditedContentDatabase.editedContentTable.create.ifNotExists().future()
      setup <- MediaDatabase.mediaTable.create.ifNotExists().future()
      setup <- PublishedContentDatabase.publishedContentTable.create.ifNotExists().future()
      setup <- RawContentDatabase.rawContentTable.create.ifNotExists().future()
      setup <- SourceDatabase.sourceTable.create.ifNotExists().future()

      //    demographics
      setup <- GenderDatabase.genderTable.create.ifNotExists().future()
      setup <- LanguageDatabase.languageTable.create.ifNotExists().future()
      setup <- LanguageProficiencyDatabase.languageProficiencyTable.create.ifNotExists().future()
      setup <- RaceDatabase.raceTable.create.ifNotExists().future()
      setup <- MaritalStatusDatabase.maritalStatusTable.create.ifNotExists().future()
      setup <- RoleDatabase.roleTable.create.ifNotExists().future()

      //    location
      setup <- AddressTypeDatabase.addressTypeTable.create.ifNotExists().future()
      setup <- ContactTypeDatabase.contactTypeTable.create.ifNotExists().future()
      setup <- LocationTypeDatabase.locationTypeTable.create.ifNotExists().future()

      //    storage
      setup <- StorageUrlDatabase.storageUrlTable.create.ifNotExists().future()
      setup <- FileResultsDatabase.fileResultsTable.create.ifNotExists().future()

      // Valid User
      setup <-ValidUserDatabase.validUserTable.create.ifNotExists().future()
      setup <-ValidUserDatabase.timeLineValidUserTable.create.ifNotExists().future()
      // system log event
      setup <-SystemLogEventsDatabase.systemLogEventsTable.create.ifNotExists().future()

      // Organization
      setup <-LocationDatabase.locationTable.create.ifNotExists().future()
      setup <-OrganisationDatabase.organisationTable.create.ifNotExists().future()
      setup <-OrganisationLogoDatabase.organisationLogoTable.create.ifNotExists().future()

    }yield setup
  }

}
