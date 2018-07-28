package at.atvgstudios.gitlab.app.Starfield

import processing.core.PApplet

/**
 * Starfield Animation
 * @author Thomas Obernosterer
 * @since 18.7.27
 */
class Starfield : PApplet() {

    private var stars: MutableList<Star> = ArrayList()
    private var starsCount = 800
    private var speed = 0f

    /**
     * Set window size 600x600
     */
    override fun settings() {
        size(600, 600)
    }

    /**
     * Create Stars
     * @see Star
     */
    override fun setup() {
        for (i in 0 until starsCount) {
            stars.add(Star(this))
        }
    }

    /**
     * Update and Show Stars
     * @see Star.update
     * @see Star.show
     */
    override fun draw() {
        speed = map(mouseX.toFloat(), 0f, width.toFloat(), 0f, 50f)
        background(0)
        translate(width / 2f, height / 2f)
        for (i in 0 until starsCount) {
            stars[i].update(speed)
            stars[i].show()
        }
    }
}