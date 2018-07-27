package at.atvgstudios.gitlab.app.RSpirograph

import processing.core.PApplet
import processing.core.PVector
import java.util.*

class RSpirograph : PApplet {

    private var path: MutableList<PVector> = ArrayList()
    private lateinit var master: Orbit
    private lateinit var end: Orbit
    private var type = 4f

    constructor(rnd: Boolean)
    {
        if(rnd)
        {
            var rand = Random()
            type = rand.nextInt(8)+2f
        }
    }

    override fun settings() {
        size(600,600)
    }

    override fun setup() {
        master = Orbit(this,width/2f,height/2f,150f, 0.01f, type)

        var next: Orbit = master
        for(i in 0 until 3)
        {
            next = next.addChild()
        }
        end = next
    }

    override fun draw() {
        background(51)

        var cur: Orbit? = master
        while(cur != null)
        {
            cur.update()
            cur.show()
            cur = cur.child
        }

        path.add(PVector(end.x, end.y))

        beginShape()
        stroke(255f,0f,255f)
        path.forEach {
            vertex(it.x,it.y)
        }
        endShape()
    }
}