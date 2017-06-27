package domain.security

case class TokenFailException(message: String = "", cause: Throwable = null)
    extends Exception(message, cause)
