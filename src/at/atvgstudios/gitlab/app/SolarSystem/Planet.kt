package at.atvgstudios.gitlab.app.SolarSystem

import processing.core.PApplet

/**
 * Solar System Animation
 * @author Thomas Obernosterer
 * @since 18.7.29.3
 */
class Planet {

    private var r = 0f
    private var d = 0f
    private var planets: MutableList<Planet> = ArrayList()
    private var angle = 0f
    private var speed = 0f
    private var app: PApplet

    constructor(app: PApplet, r: Float, d: Float, o: Float)
    {
        this.app = app
        this.r = r
        this.d = d
        this. speed = o
        angle = app.random(PApplet.TWO_PI)
    }

    fun orbit()
    {
        angle += speed
        if(planets.isNotEmpty())
            for(i in 0 until planets.size)
                planets[i].orbit()
    }

    fun spawnMoons(t: Int, l: Int)
    {
        for(i in 0 until t)
        {
            val r_ = r / (l*2)
            val d_ = app.random(50f,150f)
            val o_ = app.random(-0.1f,0.1f)
            planets.add(Planet(app,r_,d_/l,o_))
            if(l < 3)
            {
                val num = app.random(0f,4f).toInt()
                planets[i].spawnMoons(num, l+1)
            }
        }
    }

    fun show()
    {
        app.pushMatrix()
        app.fill(255,100f)
        app.rotate(angle)
        app.translate(d,0f)
        app.ellipse(0f,0f,r*2f,r*2f)
        planets.forEach { it.show() }
        app.popMatrix()
    }
}