package mainprocess

import electron.{App, BrowserWindow, BrowserWindowOptions, ElectronGlobals}
import nodejs.{FormatOptions, Path, URL}

import scala.collection.mutable
import scala.scalajs.js.UndefOr


/**
 * This object represents the translation into Scala.js of the main.js file presented in the Electron Quick Start guide,
 * available at https://electron.atom.io/docs/tutorial/quick-start/
 */
object MainProcess {

  /** Every created windows will be put into the windows mutable.Set. */
  val windows: mutable.Set[BrowserWindow] = mutable.Set()

  def createWindow(): Unit = {
    /** Printing "hello" in the main process, just to see it in action. */
    println("hello")

    /**
     * Creating the BrowserWindow object, with the desired options.
     */
    val window = new BrowserWindow(
      new BrowserWindowOptions {
        override val height: UndefOr[Int] = 600
        override val width: UndefOr[Int] = 800
      }
    )


    window.loadURL(URL.format(new FormatOptions {
      override val pathname: UndefOr[String] =
        Path.join(ElectronGlobals.__dirname, "../index.html") // js file will be in electron/mainprocess
      override val protocol: UndefOr[String] = "file:"
      override val slashes: UndefOr[Boolean] = true
    }))

    /**
     * In Scala.js, you have two modes for compiling your code. A fast and a full optimized way. Fast optimisation
     * should be used in development only. Compilation time is significantly shorted, and to a lesser extent, produces
     * more "human readable" JavaScript code in case you really want to have a look.
     * Full optimized compilation leads to more optimized JavaScript code, as well as lighter JavaScript files.
     *
     * As a result, Scala.js also allows you to perform snippets of codes depending on the mode of compilation you
     * chose. In this case, we only want to open the dev tools of a window if we are in development mode, but it is
     * something that you clearly want to avoid in production code.
     */
    if (scala.scalajs.LinkingInfo.developmentMode) {
      window.webContents.openDevTools()
    }

    window.on("closed", () => {
      windows -= window
    })

    windows += window
  }

  /**
   * The main method is called automatically when the JavaScript file is loaded, thanks to the sbt setting
   *   scalaJSUseMainModuleInitializer := true
   * in the build.sbt file. Removing this method will fail at compile time.
   */
  def main(args: Array[String]): Unit = {

    App.on("ready", () => createWindow())

    App.on("window-all-closed", () => App.quit())

  }

}
