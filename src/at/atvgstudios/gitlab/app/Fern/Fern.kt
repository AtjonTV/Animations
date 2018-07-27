package at.atvgstudios.gitlab.app.Fern

import processing.core.PApplet

class Fern : PApplet() {

    private var x = 0f
    private var y = 0f

    override fun settings() {
        size(600,600)
    }

    override fun setup() {
        background(0)
    }

    /**
     *
     * Currently left of right here: https://youtu.be/JFugGF1URNo?t=7m
     *
     */

    override fun draw() {
        for(i in 0 until 100)
        {
            drawP()
            nextP()
        }
    }

    private fun drawP()
    {
        stroke(255)
        strokeWeight(2f)
        var px = map(x,-2.1820f,2.6558f,0f,width.toFloat())
        var py = map(y,0f,9.9983f,height.toFloat(),0f)
        point(px,py)
    }

    private fun nextP()
    {
        var (nx,ny) = calc()
        x = nx
        y = ny
    }

    private fun calc(): Pair<Float, Float>
    {
        var r = random(1f)
        var nx: Float
        var ny: Float

        when {
            r < 0.01f -> {
                nx = 0f
                ny = 0.16f * y
            }
            r < 0.86f -> {
                nx =  0.85f * x +  0.04f * y
                ny = -0.04f * x +  0.85f * y + 1.6f
            }
            r < 0.93f -> {
                nx =  0.20f * x + -0.26f * y
                ny =  0.23f * x +  0.22f * y + 1.6f
            }
            else -> {
                nx = -0.15f * x +  0.28f * y
                ny =  0.26f * x +  0.24f * y + 0.44f
            }
        }

        return Pair(nx,ny)
    }
}