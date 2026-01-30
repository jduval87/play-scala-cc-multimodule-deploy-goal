lazy val common = (project in file("modules/common"))
  .enablePlugins(PlayScala)
  .settings(
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "2.4.240",
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test
    ),
    name := "common",
    scalaVersion := "2.13.18",
  )

lazy val moduleone = (project in file("modules/moduleone"))
  .enablePlugins(PlayScala, JavaAppPackaging)
  .settings(
    name := "moduleone",
    scalaVersion := "2.13.18",
    Compile / packageDoc / mappings := Seq()
  )
  .dependsOn(common)

lazy val moduletwo = (project in file("modules/moduletwo"))
  .enablePlugins(PlayScala, JavaAppPackaging)
  .settings(
    name := "moduletwo",
    scalaVersion := "2.13.18",
    Compile / packageDoc / mappings := Seq()
  )
  .dependsOn(common)

lazy val root = (project in file("."))
  .settings(
    name := """play-scala-starter-example""",
    scalaVersion := "2.13.18",
    scalacOptions ++= Seq("-feature", "-deprecation")
  )
  .aggregate(moduleone, moduletwo)
