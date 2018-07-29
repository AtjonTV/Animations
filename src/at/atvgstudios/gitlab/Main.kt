package at.atvgstudios.gitlab

import at.atvgstudios.gitlab.app.ApproxPi.ApproxPi
import at.atvgstudios.gitlab.app.DPendulum.DPendulum
import at.atvgstudios.gitlab.app.Fern.Fern
import at.atvgstudios.gitlab.app.Lorenz.Lorenz
import at.atvgstudios.gitlab.app.PurpleRain.PurpleRain
import at.atvgstudios.gitlab.app.RSpirograph.RSpirograph
import at.atvgstudios.gitlab.app.Spirograph.Spirograph
import at.atvgstudios.gitlab.app.Starfield.Starfield
import processing.core.PApplet

/**
 * Application Main
 * @author Thomas Obernosterer
 * @since 18.7.27
 * @param args Console Arguments
 */
fun main(args: Array<String>) {
    printInfo()
    if (args.isNotEmpty() && args.size == 1) {
        launch(args[0])
    } else {
        printAnims()

        println("\nEnter a Animation name to launch or type exit")
        print("> ")
        val inp = readLine()

        if (inp != null) {
            if (inp == "exit")
                System.exit(0)
            launch(inp)
        }
    }
}

/**
 * Launches a Animation by Name
 * @param name Name of the Animation
 */
fun launch(name: String) {
    when (name) {
        "PurpleRain" -> {
            PApplet.runSketch(arrayOf("PurpleRain"), PurpleRain())
        }
        "Starfield" -> {
            PApplet.runSketch(arrayOf("Starfield"), Starfield())
        }
        "Lorenz" -> {
            PApplet.runSketch(arrayOf("Lorenz"), Lorenz())
        }
        "DPendulum" -> {
            PApplet.runSketch(arrayOf("DPendulum"), DPendulum())
        }
        "Fern" -> {
            PApplet.runSketch(arrayOf("Fern"), Fern())
        }
        "RSpirograph" -> {
            PApplet.runSketch(arrayOf("Spirograph"), RSpirograph(true))
        }
        "Spirograph" -> {
            PApplet.runSketch(arrayOf("Spirograph"), Spirograph())
        }
        "ApproxPi" -> {
            PApplet.runSketch(arrayOf("ApproxPi"), ApproxPi())
        }
        "-ui" -> {
            PApplet.runSketch(arrayOf("AnimationsUi"), AnimationsUi())
        }
        else -> {
            println("Unknown Animation '$name'!")
            print("")
            printAnims()
        }
    }
}

/**
 * Prints information about the application
 */
fun printInfo() {
    println("")
    println("+----------------------------------+")
    println("|  2D Animations using Processing  |")
    println("+----------------------------------+")
    println("| This application contains 8      |")
    println("| animations that have been        |")
    println("| translated from Java to Kotlin   |")
    println("+----------------------------------+")
    println("| Java-Developer: Daniel Shiffman  |")
    println("| Kt-Developer: Thomas Obernosterer|")
    println("+----------------------------------+")
    when {
        Utils.getVersion().length == 6 -> println("| Version: ${Utils.getVersion()}                  |")
        Utils.getVersion().length == 7 -> println("| Version: ${Utils.getVersion()}                 |")
        Utils.getVersion().length == 8 -> println("| Version: ${Utils.getVersion()}                |")
        Utils.getVersion().length == 9 -> println("| Version: ${Utils.getVersion()}               |")
    }
    println("| License: MIT (Open Source)       |")
    println("+----------------------------------+")
    println("| Kotlin:          v1.2.51         |")
    println("| Java JVM:        v${System.getProperty("java.version").split("_")[0]}          |")
    println("| Processing Core: v3.4            |")
    println("| ControlP5:       v2.2.6          |")
    println("+----------------------------------+")
    println("")
}

/**
 * Prints a list of Animation names
 */
fun printAnims() {
    println("Available Animations:")
    print("")
    println("+-------------+")
    println("| PurpleRain  |")
    println("| Starfield   |")
    println("| Lorenz      |")
    println("| DPendulum   |")
    println("| Fern        |")
    println("| RSpirograph |")
    println("| Spirograph  |")
    println("| ApproxPi    |")
    println("+-------------+")
}