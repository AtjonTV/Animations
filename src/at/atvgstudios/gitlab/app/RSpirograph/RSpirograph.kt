package at.atvgstudios.gitlab.app.RSpirograph

import processing.core.PApplet
import processing.core.PVector
import java.util.*

/**
 * Random Spirograph Animation
 * @author Thomas Obernosterer
 * @since 18.7.28
 */
class RSpirograph(rnd: Boolean) : PApplet() {

    private var path: MutableList<PVector> = ArrayList()
    private lateinit var master: Orbit
    private lateinit var end: Orbit
    private var type = 4f

    init {
        if (rnd) {
            val rand = Random()
            type = rand.nextInt(8) + 2f
        }
    }

    /**
     * Set window size 600x600
     */
    override fun settings() {
        size(600, 600)
    }

    /**
     * Create Orbits
     * @see Orbit
     */
    override fun setup() {
        master = Orbit(this, width / 2f, height / 2f, 150f, 0.01f, type)

        var next: Orbit = master
        for (i in 0 until 3) {
            next = next.addChild()
        }
        end = next
    }

    /**
     * Update and Draw Orbits; Draw Path
     * @see Orbit.update
     * @see Orbit.show
     */
    override fun draw() {
        background(51)

        var cur: Orbit? = master
        while (cur != null) {
            cur.update()
            cur.show()
            cur = cur.child
        }

        path.add(PVector(end.x, end.y))

        beginShape()
        stroke(255f, 0f, 255f)
        path.forEach {
            vertex(it.x, it.y)
        }
        endShape()
    }
}