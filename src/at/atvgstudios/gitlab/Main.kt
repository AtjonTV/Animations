package at.atvgstudios.gitlab

import at.atvgstudios.gitlab.app.Fern.Fern
import at.atvgstudios.gitlab.app.Lorenz.Lorenz
import at.atvgstudios.gitlab.app.DPendulum.DPendulum
import at.atvgstudios.gitlab.app.PurpleRain.PurpleRain
import at.atvgstudios.gitlab.app.Spirograph.Spirograph
import at.atvgstudios.gitlab.app.Starfield.Starfield
import processing.core.PApplet

fun main(args: Array<String>)
{
    printInfo()
    if(args.isNotEmpty() && args.size == 1)
    {
        launch(args[0])
    }
    else
    {
        printAnims()

        println("\nEnter a Animation name to launch or type exit")
        print("> ")
        var inp = readLine()

        if (inp != null) {
            if(inp == "exit")
                System.exit(0)
            launch(inp)
        }
    }
}

fun launch(name: String)
{
    when(name)
    {
        "PurpleRain" -> {
            var anim = PurpleRain()
            PApplet.runSketch(arrayOf("PurpleRain"), anim)
        }
        "Starfield" -> {
            var anim = Starfield()
            PApplet.runSketch(arrayOf("Starfield"), anim)
        }
        "Lorenz" -> {
            var anim = Lorenz()
            PApplet.runSketch(arrayOf("Lorenz"), anim)
        }
        "DPendulum" -> {
            var anim = DPendulum()
            PApplet.runSketch(arrayOf("DPendulum"), anim)
        }
        "Fern" -> {
            var anim = Fern()
            PApplet.runSketch(arrayOf("Fern"), anim)
        }
        "Spirograph" -> {
            var anim = Spirograph()
            PApplet.runSketch(arrayOf("Spirograph"), anim)
        }
        else -> {
            println("Unknown Animation '$name'!")
            print("")
            printAnims()
        }
    }
}

fun printInfo()
{
    println("")
    println("+----------------------------------+")
    println("|  2D Animations using Processing  |")
    println("+----------------------------------+")
    println("| This application contains 5      |")
    println("| animations that have been        |")
    println("| translated from Java to Kotlin   |")
    println("+----------------------------------+")
    println("| Java-Developer: Daniel Shiffman  |")
    println("| Kt-Developer: Thomas Obernosterer|")
    println("+----------------------------------+")
    println("| Version: 18.7.27                 |")
    println("| License: MIT (Open Source)       |")
    println("+----------------------------------+")
    println("| Kotlin:          v1.2.51         |")
    println("| Java JVM:        v${System.getProperty("java.version").split("_")[0]}          |")
    println("| Processing Core: v3.3.7          |")
    println("+----------------------------------+")
    println("")
}

fun printAnims()
{
    println("Available Animations:")
    print("")
    println("+------------+")
    println("| PurpleRain |")
    println("| Starfield  |")
    println("| Lorenz     |")
    println("| DPendulum  |")
    println("| Fern       |")
    //println("| Spirograph |")
    println("+------------+")
}