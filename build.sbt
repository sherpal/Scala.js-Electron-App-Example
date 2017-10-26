name := "ElectronAppExample"

val copyMainProcess = taskKey[File]("Return main process fast compiled file directory.")
lazy val fastOptCompileCopy = taskKey[Unit]("Compile and copy paste projects and generate corresponding json file.")

val copyMainProcessFullOpt = taskKey[File]("Return main process full compiled file directory.")
lazy val fullOptCompileCopy = taskKey[Unit]("Compile and copy paste projects, and generate corresponding json file.")


fullOptCompileCopy := {

  /**
   * Compiles the mainProcess project, and copy paste it in the electron/mainprocess directory.
   */
  val mainProcessDirectory = (copyMainProcessFullOpt in `mainProcess`).value
  IO.delete(baseDirectory.value / "electron/mainprocess")
  IO.copyDirectory(
    mainProcessDirectory.getParentFile,
    baseDirectory.value / "electron/mainprocess",
    overwrite = true
  )

  /**
   * We read the default package.json file and copy paste it into electron folder, with reference to the compiled file.
   */

  def toFullOptFile(line: String): String = """COMPILEDFILE""".r.replaceAllIn(line, "opt")

  val sourcePackageJSON = IO.readLines(baseDirectory.value / "source-package-json/package.json")

  IO.writeLines(
    baseDirectory.value / "electron/package.json",
    sourcePackageJSON.map(toFullOptFile)
  )


}


fastOptCompileCopy := {

  /**
   * Compiles the mainProcess project, and copy paste it in the electron/mainprocess directory.
   */
  val mainProcessDirectory = (copyMainProcess in `mainProcess`).value
  IO.delete(baseDirectory.value / "electron/mainprocess")
  IO.copyDirectory(
    mainProcessDirectory.getParentFile,
    baseDirectory.value / "electron/mainprocess",
    overwrite = true
  )


  /**
   * We read the default package.json file and copy paste it into electron folder, with reference to the compiled file.
   */

  def toFastOptFile(line: String): String = """COMPILEDFILE""".r.replaceAllIn(line, "fastopt")

  val sourcePackageJSON = IO.readLines(baseDirectory.value / "source-package-json/package.json")

  IO.writeLines(
    baseDirectory.value / "electron/package.json",
    sourcePackageJSON.map(toFastOptFile)
  )

}

val commonSettings = Seq(
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.1"
)


lazy val mainProcess = project.in(file("./mainprocess"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(
    scalaJSUseMainModuleInitializer := true, // executes the main method of an object when compiled file is loaded.
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }, // turns the compiled file into a module.
    copyMainProcess := {
      (fastOptJS in Compile).value.data
    },
    copyMainProcessFullOpt := {
      (fullOptJS in Compile).value.data
    }
  )


