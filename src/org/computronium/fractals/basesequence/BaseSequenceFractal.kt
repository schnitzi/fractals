package org.computronium.fractals.basesequence
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.event.*
import javax.swing.*
import kotlin.system.exitProcess

/**
 * Panel to generate a 2D view of the algorithm described at
 * https://old.reddit.com/r/math/comments/e14zxi/what_number_creates_the_longest_sequence_using/f8nqwy0/.
 *
 * The x axis is the starting number, the y axis is the base, and the color
 * is based on the length of the resulting sequence.
 */
class BaseSequenceFractal : JFrame("Base Sequence Fractal") {

    private val centerPanel = JTabbedPane()

    init {

        addTab("Wedge start", BaseSequenceIntegerFractalPanel(2, 30))
        addTab("7000s range", BaseSequenceIntegerFractalPanel(7000, 35))
        addTab("70000s range", BaseSequenceIntegerFractalPanel(70000, 35))
        addTab("Centered", CenteredBaseSequenceIntegerFractalPanel(2, 30))

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
        layout = BorderLayout()
        add(centerPanel, BorderLayout.CENTER)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(windowEvent: WindowEvent?) {
                exitProcess(0)
            }
        })

        size = Dimension(1000, 600)
        setLocationRelativeTo(null)

        this.isFocusable = true
        this.requestFocus()
    }

    private fun addTab(title: String, panel: IntegerFractalPanel) {

        panel.addMouseMotionListener(object : MouseMotionAdapter() {
            override fun mouseMoved(e: MouseEvent?) {
                val graphics = panel.graphics
                graphics.color = Color.BLACK
                graphics.fillRect(15, panel.height-90-15, 100, 21)
                graphics.color = Color.WHITE
                graphics.drawString("" + (e!!.x + panel.startValue) + "," + e.y, 20, panel.height - 90)
            }
        })
        centerPanel.addTab(title, panel)
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            BaseSequenceFractal().isVisible = true
        }
    }
}