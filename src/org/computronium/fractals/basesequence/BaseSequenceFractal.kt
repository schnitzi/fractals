package org.computronium.fractals.basesequence
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame
import javax.swing.UIManager
import javax.swing.WindowConstants

/**
 * Panel to generate a 2D view of the algorithm described at
 * https://old.reddit.com/r/math/comments/e14zxi/what_number_creates_the_longest_sequence_using/f8nqwy0/.
 *
 * The x axis is the starting number, the y axis is the base, and the color
 * is based on the length of the resulting sequence.
 */
class BaseSequenceFractal : JFrame("Base Sequence Fractal") {

    private var centerPanel: BaseSequenceFractalPanel

    init {

        // Estimate for longest sequence in range.  Will error if too small.
        val maxSequenceLength = 30

        val startingValueOfN = 70000

        centerPanel = BaseSequenceFractalPanel(startingValueOfN, maxSequenceLength)

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
        layout = BorderLayout()
        add(centerPanel, BorderLayout.CENTER)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(windowEvent: WindowEvent?) {
                System.exit(0)
            }
        })

        size = Dimension(1000, 600)
        setLocationRelativeTo(null)

        this.isFocusable = true
        this.requestFocus()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            BaseSequenceFractal().isVisible = true
        }
    }
}