package electron

import nodejs.EventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport


/**
 * The App object is available in the Main Process.
 *
 * You need to wait for the App to be ready before starting to create BrowserWindow instances.
 *
 * Documentation is available here: https://electron.atom.io/docs/api/app/
 *
 * In JavaScript, the app object is within the electron module. Importing from a module is documented here:
 *   https://www.scala-js.org/doc/interoperability/facade-types.html
 * under the "Imports from other JavaScript modules" section.
 */
@js.native
@JSImport("electron", "app")
object App extends EventEmitter {

  def quit(): Unit = js.native

}
