package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobalScope


/**
 * We need to access the global scope in order to retrieve the value of __dirname.
 * This is documented here: https://www.scala-js.org/doc/interoperability/global-scope.html
 */
@js.native
@JSGlobalScope
object ElectronGlobals extends js.Object {

  val __dirname: String = js.native

}
