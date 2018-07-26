package at.atvgstudios.gitlab.app.Lorenz

import processing.core.PApplet

class Lorenz : PApplet() {

    private var x = 0.01f
    private var y = 0f
    private var z = 0f

    private var a = 10f
    private var b = 28f
    private var c = 8f/3f

    override fun settings() {
        size(800,600)
    }

    override fun setup() {
        background(0)
    }

    override fun draw() {
        var dt = 0.01f
        var dx = (a * (y-x)) * dt
        var dy = (x * (b-z) - y) * dt
        var dz = (x * y - c*z) * dt
        x += dx
        y += dy
        z += dz

        translate(width/2f, height/2f)
        scale(5f)
        stroke(255)
        point(x,y)

        println("$x, $y, $z")
    }
}