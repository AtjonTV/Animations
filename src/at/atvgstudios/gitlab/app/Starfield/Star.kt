package at.atvgstudios.gitlab.app.Starfield

import processing.core.PApplet

/**
 * @author Thomas Obernosterer
 * @since 18.7.27
 */
class Star(private var app: PApplet) {

    private var x = 0f
    private var y = 0f
    private var z = 0f
    private var pz = 0f
    private var width = 0f
    private var height = 0f

    init {
        width = app.width.toFloat()
        height = app.height.toFloat()
        randPos()
    }

    /**
     * Create new Random position
     */
    private fun randPos() {
        x = app.random(-width, width)
        y = app.random(-height, height)
        z = app.random(width)
        pz = z
    }

    /**
     * Update location
     */
    fun update(speed: Float) {
        z -= speed

        if (z < 1)
            randPos()
    }

    /**
     * Draw to screen
     */
    fun show() {
        app.fill(255)
        app.noStroke()

        val sx = PApplet.map(x / z, 0f, 1f, 0f, width)
        val sy = PApplet.map(y / z, 0f, 1f, 0f, height)

        val px = PApplet.map(x / pz, 0f, 1f, 0f, width)
        val py = PApplet.map(y / pz, 0f, 1f, 0f, height)

        pz = z

        app.stroke(255)
        app.line(px, py, sx, sy)
    }
}