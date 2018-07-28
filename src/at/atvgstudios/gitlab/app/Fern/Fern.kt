package at.atvgstudios.gitlab.app.Fern

import processing.core.PApplet

/**
 * Barnsley Fern Animation
 * @author Thomas Obernosterer
 * @since 18.7.27
 */
class Fern : PApplet() {

    private var x = 0f
    private var y = 0f

    /**
     * Set window size 600x600
     */
    override fun settings() {
        size(600, 600)
    }

    /**
     * Set background 0
     */
    override fun setup() {
        background(0)
    }

    /**
     * Call Draw and Update
     */
    override fun draw() {
        for (i in 0 until 100) {
            drawP()
            nextP()
        }
    }

    /**
     * Draw to screen
     */
    private fun drawP() {
        stroke(255)
        strokeWeight(2f)
        val px = map(x, -2.1820f, 2.6558f, 0f, width.toFloat())
        val py = map(y, 0f, 9.9983f, height.toFloat(), 0f)
        point(px, py)
    }

    /**
     * Update
     */
    private fun nextP() {
        val (nx, ny) = calc()
        x = nx
        y = ny
    }

    /**
     * Calculate a new Position
     */
    private fun calc(): Pair<Float, Float> {
        val r = random(1f)
        val nx: Float
        val ny: Float

        when {
            r < 0.01f -> {
                nx = 0f
                ny = 0.16f * y
            }
            r < 0.86f -> {
                nx = 0.85f * x + 0.04f * y
                ny = -0.04f * x + 0.85f * y + 1.6f
            }
            r < 0.93f -> {
                nx = 0.20f * x + -0.26f * y
                ny = 0.23f * x + 0.22f * y + 1.6f
            }
            else -> {
                nx = -0.15f * x + 0.28f * y
                ny = 0.26f * x + 0.24f * y + 0.44f
            }
        }

        return Pair(nx, ny)
    }
}