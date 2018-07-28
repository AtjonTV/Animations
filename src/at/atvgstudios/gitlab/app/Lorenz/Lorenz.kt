package at.atvgstudios.gitlab.app.Lorenz

import processing.core.PApplet

/**
 * Lorenz Attractor Animation
 * @author Thomas Obernosterer
 * @since 18.7.27
 */
class Lorenz : PApplet() {

    private var x = 0.01f
    private var y = 0f
    private var z = 0f

    private var a = 10f
    private var b = 28f
    private var c = 8f / 3f

    /**
     * Set window size 800x600
     */
    override fun settings() {
        size(800, 600)
    }

    /**
     * Set background 0
     */
    override fun setup() {
        background(0)
    }

    /**
     * Update and Draw
     */
    override fun draw() {
        val dt = 0.01f
        val dx = (a * (y - x)) * dt
        val dy = (x * (b - z) - y) * dt
        val dz = (x * y - c * z) * dt
        x += dx
        y += dy
        z += dz

        translate(width / 2f, height / 2f)
        scale(5f)
        stroke(255)
        point(x, y)
    }
}