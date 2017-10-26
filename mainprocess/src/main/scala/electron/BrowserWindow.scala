package electron

import nodejs.EventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport


/**
 * BrowserWindows are the Renderer Processes in electron. They are Internet Browsers-like instances that allow you to
 * renderer HTML web pages.
 *
 * Documentation is available here: https://github.com/electron/electron/blob/master/docs/api/browser-window.md
 *
 * In the Main Process, BrowserWindows are imported from electron module. Importing from modules in JavaScript is
 * documented at
 *   https://www.scala-js.org/doc/interoperability/facade-types.html
 * under the "Imports from other JavaScript modules" section.
 *
 * @param options A BrowserWindowOptions instance that sets all the default options you want for your window.
 */
@js.native
@JSImport("electron", "BrowserWindow")
class BrowserWindow(options: BrowserWindowOptions) extends EventEmitter {

  /**
   * Every window comes with a unique instance of the WebContents class.
   */
  val webContents: WebContents = js.native

  def loadURL(url: String): Unit = js.native

}


/**
 * In JavaScript, the BrowserWindow class constructor needs a json option object. In Scala.js, this is translated into
 * a trait specifying all the available options values as js.UndefOr[T] instances.
 * Required fields should be left abstract. Required fields must be set to js.undefined.
 */
trait BrowserWindowOptions extends js.Object {

  val width: js.UndefOr[Int] = js.undefined

  val height: js.UndefOr[Int] = js.undefined

}