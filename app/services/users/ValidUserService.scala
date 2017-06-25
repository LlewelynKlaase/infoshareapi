package services.users

import javax.inject.Singleton

import com.outworkers.phantom.dsl.ResultSet
import domain.users.ValidUser
import repositories.users.ValidUserRepository

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by hashcode on 2017/06/11.
  */
trait ValidUserService extends ValidUserRepository {

  def save(user: ValidUser): Future[ResultSet] = {
    for {
      _ <- database.validUserTable.save(user)
      saveValidUser <- database.timeLineValidUserTable.save(user)
    } yield saveValidUser

  }

  def isUserValid(userId: String): Future[Boolean] = {
    database.validUserTable.isUserValid(userId)
  }

  def getValidUserEvents(userId: String): Future[Seq[ValidUser]] = {
    database.validUserTable.getValidUserEvents(userId)
  }

  def getValidUsers: Future[Int] = {
    database.validUserTable.getValidUsers
  }

  def getValidUsersInLast24hours: Future[Seq[ValidUser]] = {
    database.timeLineValidUserTable.getValidUsersInLast24hours
  }

}

@Singleton
object ValidUserService extends ValidUserService with ValidUserRepository
