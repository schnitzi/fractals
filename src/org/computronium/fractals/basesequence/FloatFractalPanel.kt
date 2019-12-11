package org.computronium.fractals.basesequence

import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

/**
 * Base class for fractal panels based on integer values.
 */
class FloatFractalPanel(val startValue: Int, maxSequenceLength: Int) : JPanel() {

    private val colorMultiplier = 255 / maxSequenceLength

    override fun paint(g: Graphics?) {

        for (x in 1..width) {
            for (y in 1..height) {
                val value = valueAt(x)
                val base = baseAt(y)
                g!!.color = getColor(value, base)
                g.fillRect(x, y, 1, 1)
            }
        }
    }

    private fun valueAt(x: Int): Float {
        return x / 4F
    }

    private fun baseAt(y: Int): Float {
        return y / 4F
    }

    private fun getColor(value: Float, base: Float): Color {
        var currentBase = Float.MAX_VALUE
        var nextBase = base
        var length = 0
        while (currentBase > nextBase) {
            length++
            currentBase = nextBase
            nextBase = findNextBase(currentBase, value)
        }
        val color = length * colorMultiplier
        return Color(0, color, color)
    }

    private fun findNextBase(base: Float, value: Float): Float {
        var x = value
        var max = 0F
        while (x > 0) {
            val digit = x % base
            if (digit > max) max = digit
            x /= base
        }
        return max + 1
    }
}