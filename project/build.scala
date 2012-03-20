import sbt._

import Keys._
import AndroidKeys._

object General {
  val settings = Defaults.defaultSettings ++ Seq (
    name := "android_sbt",
    version := "0.1",
    versionCode := 0,
    scalaVersion := "2.9.1",
    platformName in Android := "android-8"
  )

  val proguardSettings = Seq (
    useProguard in Android := true
  )

  lazy val fullAndroidSettings =
    General.settings ++
    AndroidProject.androidSettings ++
    TypedResources.settings ++
    proguardSettings ++
    AndroidManifestGenerator.settings ++
    AndroidMarketPublish.settings ++ Seq (
      keyalias in Android := "change-me",
      libraryDependencies += "org.scalatest" %% "scalatest" % "1.7.RC1" % "test"
    )
}

object AndroidBuild extends Build {
  lazy val overrideAndroidSettings = Seq (
    autoScalaLibrary in GlobalScope := true,
    scalaSource in Compile <<= (baseDirectory) (_ / "src_scala"),
    useProguard := true // need for https://github.com/jberkel/android-plugin/issues/114
  )

  lazy val main = Project (
    "android_sbt",
    file("."),
    settings = General.fullAndroidSettings ++ PlainJavaProject.settings ++ inConfig(Android)(overrideAndroidSettings)
  )
}

