package org.computronium.fractals.basesequence

import java.awt.Color
import java.awt.Graphics

class BaseSequenceFractalPanel(start: Int, private val maxSequenceLength: Int) : FractalPanel(start) {

    private val pixelSize = 1

    override fun paint(g: Graphics?) {

        val colorMultiplier = 255 / maxSequenceLength

        var x = start
        while (x - start < width) {
            var y = 2
            while (y < height) {
                val sequenceLength = Computation.findSequenceLength(x, y)
                val color = sequenceLength * colorMultiplier
                g!!.color = Color(0, color, color)
                g.fillRect((x-start)*pixelSize, y*pixelSize, pixelSize, pixelSize)
                y += pixelSize
            }
            x += pixelSize
        }
    }
}
