package nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport


/**
 * This is the Path object from the nodejs path module (https://nodejs.org/api/path.html).
 * In JavaScript, it is required via
 * const path = require("path")
 * In order to get the module itself, we have to use JSImport.Namespace.
 *
 * Importing from a module is documented at
 *   https://www.scala-js.org/doc/interoperability/facade-types.html
 * under the "Imports from other JavaScript modules" section.
 */
@js.native
@JSImport("path", JSImport.Namespace)
object Path extends js.Object {

  def join(args: String*): String = js.native

}
