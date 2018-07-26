package at.atvgstudios.gitlab.app.Pendulum

import processing.core.PApplet
import processing.core.PGraphics

class Pendulum : PApplet() {

    private var r1 = 200f
    private var r2 = 200f
    private var m1 = 40f
    private var m2 = 40f
    private var a1 = PI/2
    private var a2 = PI/2
    private var a1V = 0f
    private var a2V = 0f
    private var gl = 1f
    private var px2 = -1f
    private var py2 = -1f
    private var cx = 0f
    private var cy = 0f
    private lateinit var canvas: PGraphics

    override fun settings() {
        size(900,600)
        cx = width/2f
        cy = 90f
    }

    override fun setup() {
        canvas = createGraphics(width,height)
        canvas.beginDraw()
        canvas.background(255)
        canvas.endDraw()
    }

    override fun draw() {
        var num1 = -gl * (2 * m1 + m2) * sin(a1)
        var num2 = -m2 * gl * sin(a1-2*a2)
        var num3 = -2*sin(a1-a2)*m2
        var num4 = a2V*a2V*r2+a1V*a1V*r1*cos(a1-a2)
        var den = r1 * (2*m1+m2-m2*cos(2*a1-2*a2))
        var a1A = (num1 + num2 + num3 *num4) / den

        num1 = 2 * sin(a1-a2)
        num2 = (a1V*a1V*r1*(m1+m2))
        num3 = gl * (m1 + m2) * cos(a1)
        num4 = a2V*a2V*r2*m2*cos(a1-a2)
        den = r2 * (2*m1+m2-m2*cos(2*a1-2*a2))
        var a2A = (num1*(num2+num3+num4)) / den

        image(canvas,0f,0f)
        stroke(0)
        strokeWeight(2f)

        translate(cx,cy)

        var x1 = r1 * sin(a1)
        var y1 = r1 * cos(a1)

        var x2 = x1 + r2 * sin(a2)
        var y2 = y1 + r2 * cos(a2)

        line(0f,0f,x1,y1)
        fill(0)
        ellipse(x1,y1,m1,m1)

        line(x1,y1,x2,y2)
        fill(0)
        ellipse(x2,y2,m2,m2)

        a1V += a1A
        a2V += a2A
        a1 += a1V
        a2 += a2V

        a1 *= 0.999f
        a2 *= 0.999f

        canvas.beginDraw()
        canvas.translate(cx,cy)
        canvas.strokeWeight(1f)
        canvas.stroke(0f)
        if(frameCount > 1)
            canvas.line(px2,py2,x2,y2)
        canvas.endDraw()

        px2 = x2
        py2 = y2
    }
}