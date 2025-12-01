import mill._
import mill.scalalib._

object aoc2025 extends ScalaModule {

  def scalaVersion = "3.4.0"

  def mainClass = Some("com.chinying.aoc25.Main")

  def ivyDeps = Agg(
    ivy"org.typelevel::cats-core::2.12.0"
  )

  object test extends ScalaTests with TestModule.Munit {
    def ivyDeps = Agg(
      ivy"org.scalameta::munit::1.0.1"
    )
  }
}
