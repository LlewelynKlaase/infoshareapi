package domain.security

import javax.inject.Singleton

@Singleton
object RolesID {
  def ANONYMOUS: String = "ANONYMOUS"

  def ROLE_ADMIN: String = "ROLE_ADMIN"

  def ROLE_EDITOR: String = "ROLE_EDITOR"

  def ROLE_PUBLISHER: String = "ROLE_PUBLISHER"

  def ORG_ADMIN: String = "Business Technical Administrator"

  def ADMIN: String = "System Administrator"
}
