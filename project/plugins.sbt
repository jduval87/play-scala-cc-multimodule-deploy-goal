ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always
ThisBuild / evictionErrorLevel := Level.Info
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.9.9")
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.11.4")
