package at.atvgstudios.gitlab.app.Spirograph

import processing.core.PApplet
import processing.core.PVector

/**
 * Spirograph Animation
 * @author Thomas Obernosterer
 * @since 18.7.29.2
 */
class Spirograph : PApplet() {

    private var path: MutableList<PVector> = ArrayList()
    private var angle = 0f
    private var resolution = 50
    private lateinit var rootOrbit: Orbit
    private lateinit var lastOrbit: Orbit

    /**
     * Set window size 600x600
     */
    override fun settings() {
        size(600,600)
        rootOrbit = Orbit(this,width/2f,height/2f,width/4f,0)
        var next = rootOrbit
        for(i in 0 until 10)
            next = next.addChild()
        lastOrbit = next
    }

    override fun setup() {

    }

    override fun draw() {
        background(51)

        for(i in 0 until resolution)
        {
            var next: Orbit? = rootOrbit
            while(next != null)
            {
                next.update()
                next = next.child
            }
            path.add(PVector(lastOrbit.x,lastOrbit.y))
        }

        var next: Orbit? = rootOrbit
        while(next != null)
        {
            next.show()
            next = next.child
        }

        beginShape()
        stroke(255)
        noFill()
        for(pos in path)
            vertex(pos.x,pos.y)
        endShape()
    }
}