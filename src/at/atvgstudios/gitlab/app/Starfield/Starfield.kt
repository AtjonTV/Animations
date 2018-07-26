package at.atvgstudios.gitlab.app.Starfield

import processing.core.PApplet

class Starfield : PApplet() {

    private var stars:MutableList<Star> = ArrayList()
    private var starsCount = 800
    private var speed = 0f

    override fun settings() {
        size(600,600)
    }

    override fun setup() {
        for( i in 0 until starsCount)
        {
            stars.add(Star(this))
        }
    }


    override fun draw() {
        speed = map(mouseX.toFloat(),0f,width.toFloat(),0f,50f)
        background(0)
        translate(width/2f, height/2f)
        for( i in 0 until starsCount)
        {
            stars[i].update(speed)
            stars[i].show()
        }
    }
}