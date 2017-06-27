package repositories.location.tables

import com.outworkers.phantom.dsl._
import com.outworkers.phantom.streams._
import domain.location.ContactType

import scala.concurrent.Future

abstract class ContactTypeTable extends Table[ContactTypeTable, ContactType] {

  object id extends StringColumn with PartitionKey

  object name extends StringColumn

  object state extends StringColumn
}

abstract class ContactTypeTableImpl extends ContactTypeTable with RootConnector {
  override lazy val tableName = "contTypes"

  def save(contypes: ContactType): Future[ResultSet] = {
    insert
      .value(_.id, contypes.id)
      .value(_.name, contypes.name)
      .value(_.state, contypes.state)
      .future()
  }

  def findById(id: String): Future[Option[ContactType]] = {
    select.where(_.id eqs id).one()
  }
  def findAll: Future[Seq[ContactType]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(id: String): Future[ResultSet] = {
    delete.where(_.id eqs id).future()
  }
}
