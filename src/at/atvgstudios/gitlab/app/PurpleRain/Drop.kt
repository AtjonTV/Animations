package at.atvgstudios.gitlab.app.PurpleRain

import processing.core.PApplet

class Drop {
    private var x = 0f
    private var y = 0f
    private var z = 0f
    private var yspeed = 1f
    private var length = 0f
    private var app: PApplet
    private var width = 0f
    private var height = 0f

    constructor(app: PApplet)
    {
        this.app = app
        width = app.width.toFloat()
        height = app.height.toFloat()
        x = app.random(width)
        y = app.random(-500f,-100f)
        z = app.random(0f,20f)
        yspeed = PApplet.map(z,0f,20f,1f,20f)
        length = PApplet.map(z,0f,20f,10f,20f)
    }

    fun fall()
    {
        y += yspeed
        yspeed += PApplet.map(z,0f,20f,0f,0.2f)

        if(y > height)
        {
            y = app.random(-200f,-100f)
            yspeed = PApplet.map(z,0f,20f,4f,20f)
        }
    }

    fun show()
    {
        app.strokeWeight(PApplet.map(z,0f,20f,1f,3f))
        app.stroke(138f,43f,226f)
        app.line(x,y,x,y+length)
    }
}