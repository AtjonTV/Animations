package at.atvgstudios.gitlab.app.Spirograph

import processing.core.PApplet

/**
 * Spirograph Animation
 * @author Thomas Obernosterer
 * @since 18.7.29.2
 */
class Orbit {
    var x = 0f
    var y = 0f
    private var r = 0f
    private var n = 0
    private var parent: Orbit? = null
    var child: Orbit? = null
    private var speed = 0f
    private var angle = 0f
    private var app: PApplet

    constructor(app: PApplet, x_: Float, y_: Float, r_: Float, n_: Int) : this(app,x_,y_,r_,n_,null)

    constructor(app: PApplet, x_: Float, y_: Float, r_: Float, n_: Int, p:Orbit?)
    {
        this.app = app
        x = x_
        y = y_
        r = r_
        n = n_
        speed = (PApplet.radians(PApplet.pow(-4f,n-1f)))/50
        parent = p
        angle = -PApplet.PI/2f
    }

    fun addChild(): Orbit {
        val newr = r / 3f
        val newx = x + r + newr
        val newy = y
        child = Orbit(app,newx, newy, newr, n + 1, this)
        return child as Orbit
    }

    fun update() {
        if (parent != null) {
            angle += speed
            val rsum = r + parent!!.r
            x = parent!!.x + rsum * PApplet.cos(angle)
            y = parent!!.y + rsum * PApplet.sin(angle)
        }
    }

    fun show()
    {
        app.stroke(255,100f)
        app.strokeWeight(1f)
        app.noFill()
        if(parent != null)
            app.line(parent!!.x, parent!!.y, x,y)
        app.ellipse(x,y,r*2,r*2)
    }
}