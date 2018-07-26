package at.atvgstudios.gitlab.app.Starfield

import processing.core.PApplet

class Star {

    private var x = 0f
    private var y = 0f
    private var z = 0f
    private var pz = 0f
    private var app: PApplet
    private var width = 0f
    private var height = 0f

    constructor(app:PApplet)
    {
        this.app = app
        width = app.width.toFloat()
        height = app.height.toFloat()
        randPos()
    }

    private fun randPos()
    {
        x = app.random(-width,width)
        y = app.random(-height,height)
        z = app.random(width)
        pz = z
    }

    fun update(speed: Float){
        z-=speed

        if(z < 1)
            randPos()
    }

    fun show(){
        app.fill(255)
        app.noStroke()

        var sx = PApplet.map(x/z,0f,1f,0f,width)
        var sy = PApplet.map(y/z,0f,1f,0f,height)

        var px = PApplet.map(x/pz,0f,1f,0f,width)
        var py = PApplet.map(y/pz,0f,1f,0f,height)

        pz = z

        app.stroke(255)
        app.line(px,py,sx,sy)
    }
}