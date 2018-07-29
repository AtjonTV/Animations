package at.atvgstudios.gitlab.app.ApproxPi

import processing.core.PApplet

/**
 * Approximate Pi Animation
 * @author Thomas Obernosterer
 * @since 18.7.29.3
 */
class ApproxPi : PApplet() {

    private val r = 200f
    private var total = 0
    private var circle = 0
    private var recordPi = 0.0

    /**
     * Set window size 402x402
     */
    override fun settings() {
        size(402,402)
    }

    /**
     * Draw ellipse and rect
     */
    override fun setup() {
        background(0)
        translate(width/2f,height/2f)
        stroke(255)
        strokeWeight(4f)
        noFill()
        ellipse(0f,0f,r*2,r*2)
        rectMode(CENTER)
        rect(0f,0f,r*2,r*2)
    }

    /**
     * Approx PI
     */
    override fun draw() {
        translate(width/2f,height/2f)

        for(i in 0 until 10000)
        {
            val x = random(-r,r)
            val y = random(-r,r)
            total++

            val d = x.toDouble() * x.toDouble() + y.toDouble() * y.toDouble()
            if(d < r.toDouble() * r.toDouble())
            {
                circle++
                stroke(100f,255f,0f,100f)
            }
            else
                stroke(0f,100f,255f,100f)
            strokeWeight(1f)
            point(x,y)

            val pi = 4.0 * (circle.toDouble() / total.toDouble())
            var recordDiff = Math.abs(Math.PI - recordPi)
            val diff = Math.abs(Math.PI - pi)
            if(diff < recordDiff)
            {
                recordDiff = diff
                recordPi = pi
            }
        }
    }
}