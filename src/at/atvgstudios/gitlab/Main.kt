package at.atvgstudios.gitlab

import at.atvgstudios.gitlab.app.Fern.Fern
import at.atvgstudios.gitlab.app.Lorenz.Lorenz
import at.atvgstudios.gitlab.app.Pendulum.Pendulum
import at.atvgstudios.gitlab.app.PurpleRain.PurpleRain
import at.atvgstudios.gitlab.app.Starfield.Starfield
import processing.core.PApplet

fun main(args: Array<String>)
{
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
        "Pendulum" -> {
            var anim = Pendulum()
            PApplet.runSketch(arrayOf("Pendulum"), anim)
        }
        "Fern" -> {
            var anim = Fern()
            PApplet.runSketch(arrayOf("Fern"), anim)
        }
        else -> {
            println("Unknown Animation '$name'!")
            print("")
            printAnims()
        }
    }
}

fun printAnims()
{
    println("Available Animations:")
    print("")
    println("+------------+")
    println("| PurpleRain |")
    println("| Starfield  |")
    println("| Lorenz     |")
    println("| Pendulum   |")
   // println("| Fern       |")
    println("+------------+")
}