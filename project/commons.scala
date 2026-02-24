import sbt.*
import sbt.Keys.*

object commons {

  val scala_version = "2.13.18"

  def withCommonSetting(theName: String) = Seq(
    ivyLoggingLevel := {
      if (sys.env.getOrElse("DISABLE_IVY_LOG", "false") == "true")
        UpdateLogging.Quiet
      else UpdateLogging.Default
    },
    name := theName,
    organization := "com.tikeasy",
    scalaVersion := scala_version,
    Compile / doc := target.map(_ / "none").value,
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-language:reflectiveCalls",
      "-language:postfixOps",
      "-language:implicitConversions",
      "-Ywarn-unused",
      "-Ymacro-annotations"
    ),
    resolvers += Resolver.mavenCentral,
    resolvers += Resolver.sonatypeCentralSnapshots
  )

}
