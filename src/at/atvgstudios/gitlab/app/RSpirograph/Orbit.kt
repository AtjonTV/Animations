package at.atvgstudios.gitlab.app.RSpirograph

import processing.core.PApplet
import kotlin.math.cos
import kotlin.math.sin

class Orbit {
    private var app: PApplet
    internal var x = 0f
    internal var y = 0f
    private var r = 0f
    private var parent: Orbit? = null
    internal var child: Orbit? = null
    private var speed = 0.1f
    private var angle = 0f
    private var type = 4f

    constructor(app: PApplet, x: Float, y: Float, r: Float, s: Float, t: Float) : this(app, x, y, r, s, t, null)

    constructor(app: PApplet, x: Float, y: Float, r: Float, s: Float, t: Float, p: Orbit?) {
        this.app = app
        this.x = x
        this.y = y
        this.r = r
        speed = s
        parent = p
        type = t
    }

    /**
     * Update
     */
    fun update() {
        if (parent == null)
            return
        angle += speed
        val rsum = r + parent!!.r
        x = parent!!.x + rsum * cos(angle)
        y = parent!!.y + rsum * sin(angle)
    }

    /**
     * Draw to screen
     */
    fun show() {
        app.stroke(255, 100f)
        app.strokeWeight(1f)
        app.noFill()
        app.ellipse(x, y, r * 2, r * 2)
    }

    /**
     * Create a new Child
     * @see Orbit
     */
    fun addChild(): Orbit {
        val nr = r / 3.0f
        val nx = x + r + nr
        val ny = y
        child = Orbit(app, nx, ny, nr, -type * speed, type, this)
        return child!!
    }
}