package repositories.votes

import com.outworkers.phantom.dsl._
import conf.connections.DataConnection
import repositories.votes.tables.{UserDownVotesTableImpl, VoteDownTableImpl}



class VoteDownDatabase(override val connector: KeySpaceDef) extends Database[VoteDownDatabase](connector) {

  object userDownVotesTable extends UserDownVotesTableImpl with connector.Connector

  object votesDownTable extends VoteDownTableImpl with connector.Connector

}

object VoteDownDatabase extends VoteDownDatabase(DataConnection.connector)

trait VoteDownRepository {
  def database = VoteDownDatabase
}


