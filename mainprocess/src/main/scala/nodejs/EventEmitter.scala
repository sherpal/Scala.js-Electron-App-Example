package nodejs

import scala.scalajs.js


/**
 * This is the nodejs EventEmitter class.
 * It is documented here: https://nodejs.org/dist/latest-v8.x/docs/api/events.html#events_class_eventemitter
 *
 * In electron, both the Main and Renderer processes are EventEmitter.
 * Since we don't need to create our own EventEmitters, we just make it a trait.
 */
@js.native
trait EventEmitter extends js.Object {

  def on(eventName: String, callback: js.Function): Unit =
    js.native


}
