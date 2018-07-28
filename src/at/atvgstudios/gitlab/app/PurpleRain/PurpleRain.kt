package at.atvgstudios.gitlab.app.PurpleRain

import processing.core.PApplet

/**
 * Purple Rain Animation
 * @author Thomas Obernosterer
 * @since 18.7.27
 */
class PurpleRain : PApplet() {

    private var drops: MutableList<Drop> = ArrayList()
    private var dropAmount = 500

    /**
     * Set window size 640x360
     */
    override fun settings() {
        size(640, 360)
    }

    /**
     * Create Drops
     * @see Drop
     */
    override fun setup() {
        for (i in 0 until dropAmount) {
            drops.add(Drop(this))
        }
    }

    /**
     * Draw and Update Drops
     * @see Drop.fall
     * @see Drop.show
     */
    override fun draw() {
        background(230f, 230f, 250f)
        for (i in 0 until dropAmount) {
            drops[i].fall()
            drops[i].show()
        }
    }
}