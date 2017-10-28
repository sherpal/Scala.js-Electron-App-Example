# Electron application with Scala.js

[Electron](https://electron.atom.io/) is a framework that allows you to "Build cross platform desktop apps with JavaScript, HTML, and CSS". [Scala.js](https://www.scala-js.org/), for its part, compiles Scala code into optimized JavaScript. This project is a demonstration of how to use them both together, in order to get a powerful tool for building desktop applications with HTML, CSS and Scala.


The code presented here is the (slightly modified) result of a live coding presented in a [BeScala](https://www.meetup.com/fr-FR/BeScala/) meetup held at [N-Side](https://www.n-side.com/) in Louvain-la-Neuve, Belgium, on October 24, 2017.


The project simply translates the [Electron Quick Start Guide](https://electron.atom.io/docs/tutorial/quick-start/) `main.js` file into Scala, building on the fly the required facade for used JavaScript modules. Documentation is available in the Scala comments in the source code, into `mainprocess/src/main/scala`.

### Try it yourself

The first thing you need to do is having electron installed globally on your machine. For that, you need to have [npm](https://nodejs.org/en/download/) installed. Then, in the command shell, simply type in `npm install -g electron`.

The build.sbt file comes with two custom tasks,

- `fastOptCompileCopy`, and
- `fullOptCompileCopy`.

They respectively use the tasks `fastOptJS` and `fullOptJS` that compiles your Scala code into JavaScript, and then copy paste the files into the `electron/mainprocess` directory. They also create the relevant `package.json` file, targeting to either of the relevant file.


Use either of the two tasks in [sbt](http://www.scala-sbt.org/). Then, once compiled, use `electron ./electron` in the command line set to the project directory, and your application will launch automatically (note that the dev tools will open only if you use the fast optimization).
