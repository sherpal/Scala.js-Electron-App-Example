package nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport


/**
 * This is the nodejs url object from the url module (https://nodejs.org/api/url.html).
 * In JavaScript, it is required via
 * const path = require("path")
 * In order to get the module itself, we have to use JSImport.Namespace.
 *
 * Importing from a module is documented at
 *   https://www.scala-js.org/doc/interoperability/facade-types.html
 * under the "Imports from other JavaScript modules" section.
 */
@js.native
@JSImport("url", JSImport.Namespace)
object URL extends js.Object {

  def format(options: FormatOptions): String = js.native

}


/**
 * The format method from the URL modules need a JavaScript json object as argument.
 * In Scala.js, this is translated into a trait specifying all the available options values as js.UndefOr[T] instances.
 * Required fields should be left abstract. Required fields must be set to js.undefined.
 */
trait FormatOptions extends js.Object {

  val pathname: js.UndefOr[String] = js.undefined

  val protocol: js.UndefOr[String] = js.undefined

  val slashes: js.UndefOr[Boolean] = js.undefined

}