package at.atvgstudios.gitlab.app.SolarSystem

import processing.core.PApplet

/**
 * Solar System Animation
 * @author Thomas Obernosterer
 * @since 18.7.29.3
 */
class SolarSystem : PApplet() {

    private lateinit var sun: Planet

    /**
     * Set window size 600x600
     */
    override fun settings() {
        size(600,600)
    }

    /**
     * Create Sun and Moons
     * @see Planet.spawnMoons
     */
    override fun setup() {
        sun = Planet(this,50f,0f,0f)
        sun.spawnMoons(5,1)
    }

    /**
     * Draw Sun and Orbit
     * @see Planet.show
     * @see Planet.orbit
     */
    override fun draw() {
        background(0)
        translate(width/2f, height/2f)
        sun.show()
        sun.orbit()
    }
}