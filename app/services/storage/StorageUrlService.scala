package services.storage


import javax.inject.Singleton

import com.outworkers.phantom.dsl.ResultSet
import domain.storage.StorageUrl
import repositories.storage.StorageUrlRepository

import scala.concurrent.Future

trait StorageUrlService extends StorageUrlRepository{

  def save(link: StorageUrl): Future[ResultSet] = {
    database.storageUrlTable.save(link)
  }

  def getLinkById(id: String): Future[Option[StorageUrl]] = {
    database.storageUrlTable.getLinkById(id)
  }

  def getAllLinks: Future[Seq[StorageUrl]] = {
    database.storageUrlTable.getAllLinks
  }
}

@Singleton
object StorageUrlService extends StorageUrlService with StorageUrlRepository