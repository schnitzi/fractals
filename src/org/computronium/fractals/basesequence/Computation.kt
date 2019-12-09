package org.computronium.fractals.basesequence

import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

class Computation() {

    companion object {

        fun findSequenceLength(start: Int, base: Int): Int {
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
}
