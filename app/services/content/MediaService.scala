package services.content

import javax.inject.Singleton

import com.outworkers.phantom.dsl.ResultSet
import domain.content.Media
import repositories.content.MediaRepository

import scala.concurrent.Future

trait MediaService extends MediaRepository {

  def save(media: Media): Future[ResultSet] = {
    database.mediaTable.save(media)
  }

  def getById(map: Map[String, String]): Future[Option[Media]] = {
    database.mediaTable.getById(map)
  }
  def getAll(contentId: String): Future[Seq[Media]] = {
    database.mediaTable.getAll(contentId)
  }
}
@Singleton
object MediaService extends MediaService with MediaRepository
