package org.computronium.fractals.basesequence

class CenteredBaseSequenceIntegerFractalPanel(start: Int, maxSequenceLength: Int) : IntegerFractalPanel(start, maxSequenceLength) {

    override fun getX(value: Int, base: Int): Int {
        return value - startValue
    }

    override fun getY(value: Int, base: Int): Int {
        return height/2 - value/2 + base
    }
}
