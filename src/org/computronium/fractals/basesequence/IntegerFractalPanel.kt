package org.computronium.fractals.basesequence

import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

/**
 * Base class for fractal panels based on integer values.
 */
abstract class IntegerFractalPanel(val startValue: Int, maxSequenceLength: Int) : JPanel() {

    private val colorMultiplier = 255 / maxSequenceLength

    override fun paint(g: Graphics?) {

        var value = startValue
        while (value - startValue < width) {
            var base = 2
            while (base < height) {
                g!!.color = getColor(value, base)
                g.fillRect(getX(value, base), getY(value, base), 1, 1)
                base += 1
            }
            value += 1
        }
    }

    abstract fun getX(value : Int, base: Int) : Int

    abstract fun getY(value : Int, base: Int) : Int

    private fun getColor(value: Int, base: Int): Color {
        var currentBase = 0
        var nextBase = base
        var length = 0
        while (currentBase != nextBase) {
            length++
            currentBase = nextBase
            nextBase = findNextBase(currentBase, value)
        }
        val color = length * colorMultiplier
        return Color(0, color, color)
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