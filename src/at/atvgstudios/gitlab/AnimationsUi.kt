package at.atvgstudios.gitlab

import at.atvgstudios.gitlab.app.ApproxPi.ApproxPi
import at.atvgstudios.gitlab.app.DPendulum.DPendulum
import at.atvgstudios.gitlab.app.Fern.Fern
import at.atvgstudios.gitlab.app.FireEffect.FireEffect
import at.atvgstudios.gitlab.app.Lorenz.Lorenz
import at.atvgstudios.gitlab.app.PurpleRain.PurpleRain
import at.atvgstudios.gitlab.app.RSpirograph.RSpirograph
import at.atvgstudios.gitlab.app.SolarSystem.SolarSystem
import at.atvgstudios.gitlab.app.Spirograph.Spirograph
import at.atvgstudios.gitlab.app.Starfield.Starfield
import controlP5.ControlP5
import processing.core.PApplet
import processing.core.PFont

/**
 * Contains the Animation UI
 * @author Thomas Obernosterer
 * @since 18.7.28.2
 */
class AnimationsUi : PApplet() {

    private lateinit var control: ControlP5
    private lateinit var font: PFont

    /**
     * Set window size to 400x400
     */
    override fun settings() {
        size(400, 400)
    }

    /**
     * Generate UI (Buttons and their Actions)
     */
    override fun setup() {
        font = createFont(Utils.getFile(javaClass, "/res/Sawasdee.ttf"), 32f)
        control = ControlP5(this)
        control.setFont(font, 12)

        control.addButton("Purple Rain")
                .setPosition(20f, 80f)
                .setSize(100, 40)
                .onClick {
                    runSketch(arrayOf("PurpleRain"), PurpleRain())
                }
        control.addButton("Starfield")
                .setPosition(135f, 80f)
                .setSize(90, 40)
                .onClick {
                    runSketch(arrayOf("Starfield"), Starfield())
                }
        control.addButton("Double Pendulum")
                .setPosition(240f, 80f)
                .setSize(140, 40)
                .onClick {
                    runSketch(arrayOf("DPendulum"), DPendulum())
                }
        control.addButton("Barnsley Fern")
                .setPosition(20f, 140f)
                .setSize(120, 40)
                .onClick {
                    runSketch(arrayOf("Fern"), Fern())
                }
        control.addButton("Lorenz")
                .setPosition(155f, 140f)
                .setSize(80, 40)
                .onClick {
                    runSketch(arrayOf("Lorenz"), Lorenz())
                }
        control.addButton("Spirograph 1")
                .setPosition(250f, 140f)
                .setSize(110, 40)
                .onClick {
                    runSketch(arrayOf("RSpirograph"), RSpirograph(true))
                }
        control.addButton("Spirograph 2")
                .setPosition(20f, 200f)
                .setSize(110, 40)
                .onClick {
                    runSketch(arrayOf("Spirograph"), Spirograph())
                }
        control.addButton("ApproxPi")
                .setPosition(145f, 200f)
                .setSize(90, 40)
                .onClick {
                    runSketch(arrayOf("ApproxPi"), ApproxPi())
                }
        control.addButton("SolarSystem")
                .setPosition(250f, 200f)
                .setSize(110, 40)
                .onClick {
                    runSketch(arrayOf("SolarSystem"), SolarSystem())
                }
        control.addButton("FireEffect")
                .setPosition(20f, 260f)
                .setSize(110, 40)
                .onClick {
                    runSketch(arrayOf("FireEffect"), FireEffect())
                }
    }

    /**
     * Draw labels on the UI
     */
    override fun draw() {
        background(15f, 35f, 51f)

        textFont(font)
        textSize(30f)
        text("Animations", 120f, 50f)
        textSize(12f)
        text("v${Utils.getVersion()} | Processing Core 3.4 | ControlP5 2.2.6", 10f, 375f)
        text("Copyright 2018 ATVG-Studios | Licensed under MIT", 10f, 390f)
    }

}