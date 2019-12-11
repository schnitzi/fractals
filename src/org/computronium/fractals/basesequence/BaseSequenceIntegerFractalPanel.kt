package org.computronium.fractals.basesequence

class BaseSequenceIntegerFractalPanel(start: Int, maxSequenceLength: Int) : IntegerFractalPanel(start, maxSequenceLength) {

    override fun getX(value: Int, base: Int): Int {
        return value - startValue
    }

    override fun getY(value: Int, base: Int): Int {
        return base
    }
}
