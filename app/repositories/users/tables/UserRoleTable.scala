package repositories.users.tables

import java.time.LocalDateTime

import com.outworkers.phantom.dsl._
import com.outworkers.phantom.jdk8._
import com.outworkers.phantom.streams._
import domain.users.UserRole

import scala.concurrent.Future


abstract class UserRoleTable extends Table[UserRoleTable, UserRole] {

  object emailId extends StringColumn with PartitionKey

  object date extends Col[LocalDateTime]  with PrimaryKey with ClusteringOrder with Ascending

  object roleId extends StringColumn

}

abstract class UserRoleTableImpl extends UserRoleTable with RootConnector {

  override lazy val tableName = "userroles"

  def save(role: UserRole): Future[ResultSet] = {
    insert
      .value(_.emailId, role.emailId)
      .value(_.roleId, role.roleId)
      .value(_.date, role.date)
      .future()
  }

  def getUserRoles(emailId: String): Future[Seq[UserRole]] = {
    select
      .where(_.emailId eqs emailId)
      .fetchEnumerator() run Iteratee.collect()
  }

  def deleteUserRoles(emailId:String):Future[ResultSet] ={
    delete.where(_.emailId eqs emailId).future()
  }
}
