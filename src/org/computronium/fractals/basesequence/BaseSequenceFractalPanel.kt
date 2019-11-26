package org.computronium.fractals.basesequence

import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

class BaseSequenceFractalPanel(private val start: Int, private val maxSequenceLength: Int) : JPanel() {

    private val pixelSize = 1

    override fun paint(g: Graphics?) {

        val colorMultiplier = 255 / maxSequenceLength

        var x = start
        while (x - start < width) {
            var y = 2
            while (y < height) {
                val sequenceLength = findSequenceLength(x, y)
                val color = sequenceLength * colorMultiplier
                g!!.color = Color(0, color, color)
                g.fillRect((x-start)*pixelSize, y*pixelSize, pixelSize, pixelSize)
                y += pixelSize
            }
            x += pixelSize
        }
    }

    private fun findSequenceLength(start: Int, base: Int): Int {
        var currentBase = 0
        var nextBase = base
        var length = 0
        while (currentBase != nextBase) {
            length++
            currentBase = nextBase
            nextBase = findNextBase(currentBase, start)
        }
        return length
    }

    private fun findNextBase(base: Int, value: Int): Int {
        var x = value
        var max = 0
        while (x > 0) {
            val digit = x % base
            if (digit > max) max = digit
            x /= base
        }
        return max + 1
    }
}
