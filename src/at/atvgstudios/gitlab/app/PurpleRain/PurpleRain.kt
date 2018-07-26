package at.atvgstudios.gitlab.app.PurpleRain

import processing.core.PApplet

class PurpleRain : PApplet() {

    private var drops:MutableList<Drop> =  ArrayList()
    private var dropAmount = 500

    override fun settings() {
        size(640, 360)
    }

    override fun setup() {
        for( i in 0 until dropAmount)
        {
            drops.add(Drop(this))
        }
    }

    override fun draw() {
        background(230f, 230f, 250f)
        for( i in 0 until dropAmount)
        {
            drops[i].fall()
            drops[i].show()
        }
    }
}