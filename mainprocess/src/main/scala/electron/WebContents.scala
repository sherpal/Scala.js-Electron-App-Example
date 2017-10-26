package electron

import scala.scalajs.js


/**
 * Every BrowserWindow comes with its own WebContents. A WebContents
 *   "renders and control the contents of a BrowserWindow instance."
 *
 * You never needs to create WebContents yourself, so we make it a trait.
 *
 * It is documented here: https://github.com/electron/electron/blob/master/docs/api/web-contents.md
 */
@js.native
trait WebContents extends js.Object {

  def openDevTools(): Unit = js.native

}
