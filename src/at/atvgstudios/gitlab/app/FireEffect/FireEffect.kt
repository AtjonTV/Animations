package at.atvgstudios.gitlab.app.FireEffect

import processing.core.PApplet
import processing.core.PGraphics
import processing.core.PImage

/**
 * FireEffect Animation
 * @author Thomas Obernosterer
 * @since 18.7.29.5
 */
class FireEffect : PApplet() {

    private lateinit var buffer1: PGraphics
    private lateinit var buffer2: PGraphics
    private lateinit var cooling: PImage
    private var w = 600
    private var h = 400
    private var ystart = 0f

    /**
     * Set window size 1200x400
     */
    override fun settings() {
        size(1200,400)
    }

    /**
     * Create Buffers and Cooling
     */
    override fun setup() {
        buffer1 = createGraphics(w,h)
        buffer2 = createGraphics(w,h)
        cooling = createImage(w,h,RGB)
    }

    /**
     * Perform Cooling
     */
    private fun cool()
    {
        cooling.loadPixels()
        var xoff = 0.0f
        val increment = 0.02f
        for (x in 0 until w) {
            xoff += increment
            var yoff = ystart
            for (y in 0 until h) {
                yoff += increment
                val n = noise(xoff, yoff)
                val bright = PApplet.pow(n, 3f) * 255
                cooling.pixels[x + y * w] = color(bright)
            }
        }
        cooling.updatePixels()
        ystart += increment
    }

    /**
     * Create Fire
     */
    private fun fire(rows: Int)
    {
        buffer1.beginDraw()
        buffer1.loadPixels()
        for (x in 0 until w) {
            for (j in 0 until rows) {
                val y = h - (j + 1)
                val index = x + y * w
                buffer1.pixels[index] = color(255)
            }
        }
        buffer1.updatePixels()
        buffer1.endDraw()
    }

    /**
     * Draw to screen
     */
    override fun draw() {
        fire(2)
        if (mousePressed) {
            buffer1.beginDraw()
            buffer1.fill(255)
            buffer1.noStroke()
            buffer1.ellipse(mouseX.toFloat(), mouseY.toFloat(), 100f, 100f)
            buffer1.endDraw()
        }
        cool()
        background(0)
        buffer2.beginDraw()
        buffer1.loadPixels()
        buffer2.loadPixels()
        for (x in 1 until w - 1) {
            for (y in 1 until h - 1) {
                val index0 = x + y * w
                val index1 = (x + 1) + y * w
                val index2 = (x - 1) + y * w
                val index3 = x + (y + 1) * w
                val index4 = x + (y - 1) * w
                val c1 = buffer1.pixels[index1]
                val c2 = buffer1.pixels[index2]
                val c3 = buffer1.pixels[index3]
                val c4 = buffer1.pixels[index4]

                val c5 = cooling.pixels[index0]
                var newC = brightness(c1) + brightness(c2) + brightness(c3) + brightness(c4)
                newC = (newC * 0.25 - brightness(c5)).toFloat()

                buffer2.pixels[index4] = color(newC)
            }
        }
        buffer2.updatePixels()
        buffer2.endDraw()

        val temp = buffer1
        buffer1 = buffer2
        buffer2 = temp

        image(buffer2,0f,0f)
        image(cooling,w.toFloat(),0f)
    }
}