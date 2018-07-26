package at.atvgstudios.gitlab.app.Fern

import processing.core.PApplet

class Fern : PApplet() {

    private var x = 0f
    private var y = 0f

    override fun settings() {
        size(600,600)
    }

    override fun setup() {

    }

    /**
     *
     * Currently left of right here: https://youtu.be/JFugGF1URNo?t=7m
     *
     */

    override fun draw() {
        background(0)

        stroke(255)
        strokeWeight(8f)
        point(x,y)

        var nx =  0.85f * x + 0.04f * y
        var ny = -0.04f * x + 0.85f * y + 1.6f

        x = nx
        y = ny
    }

}