package org.example.view.components

import java.awt.BorderLayout
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

class LoadingFrame : JFrame() {
    private val loadingImage: ImageIcon = ImageIcon(javaClass.getResource("/image/loading.gif"))

    init {
        setSize(600, 400)
        title = "로딩중"
        layout = BorderLayout()
        add(JPanel(), BorderLayout.NORTH)
        add(JPanel(), BorderLayout.SOUTH)
        add(JPanel(), BorderLayout.WEST)
        add(JPanel(), BorderLayout.EAST)
        add(JLabel(loadingImage), BorderLayout.CENTER)
        setLocationRelativeTo(null)
        isVisible = true
    }
}
