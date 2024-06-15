package org.example.view.auth

import org.example.common.mainFont20
import org.example.common.mainFont40
import org.example.common.passWordFont
import org.example.controller.LoginPageController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.awt.Color
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

/**
 * 로그인 페이지
 */
class LoginPage : JFrame(), ActionListener {
    private val logger: Logger = LoggerFactory.getLogger(LoginPage::class.java)
    private val controller = LoginPageController(this)

    var mainlabel1: JLabel
    var tx_ID: JTextField
    var tx_PassWord: JPasswordField
    var LoginButton: JButton
    var RegisterButton: JButton

    /**
     * 생성자
     */
    init {
        title = "LoginTest Screen"
        setSize(1280, 720)

        setLocationRelativeTo(null)
        contentPane.layout = null
        defaultCloseOperation = EXIT_ON_CLOSE

        val panelMainWhite = JPanel() //배경 만들기
        val lineID = JPanel()
        val linePW = JPanel()

        panelMainWhite.setBounds(26, 28, 684, 612) //배경 만들기
        lineID.setBounds(200, 330, 300, 2)
        linePW.setBounds(200, 430, 300, 2)


        val mint = Color(62, 185, 180) //색상 정하기
        val gray1 = Color(192, 192, 192)


        mainlabel1 = JLabel("오점뭐 (오늘 점심 뭐 먹지)")
        mainlabel1.setBounds(140, 56, 619, 61)
        mainlabel1.font = mainFont40

        tx_ID = JTextField("email")
        tx_ID.setBounds(200, 280, 300, 43)
        tx_ID.font = mainFont20
        tx_ID.foreground = gray1

        tx_PassWord = JPasswordField("password")
        tx_PassWord.setBounds(200, 380, 300, 43)
        tx_PassWord.font = passWordFont
        tx_PassWord.foreground = gray1

        tx_ID.border = BorderFactory.createEmptyBorder()
        tx_PassWord.border = BorderFactory.createEmptyBorder()

        LoginButton = JButton("로그인")
        LoginButton.setBounds(290, 490, 115, 34)
        LoginButton.font = mainFont20

        LoginButton.isBorderPainted = false //버튼 테두리 없에기
        LoginButton.isContentAreaFilled = false
        LoginButton.actionCommand = "signIn"
        LoginButton.addActionListener(this)

        RegisterButton = JButton("회원가입")
        RegisterButton.setBounds(285, 540, 130, 34)
        RegisterButton.font = mainFont20

        RegisterButton.isBorderPainted = false //버튼 테두리 없에기
        RegisterButton.actionCommand = "signUp"
        RegisterButton.addActionListener(this)


        panelMainWhite.background = Color.white
        RegisterButton.foreground = Color.white
        RegisterButton.background = mint

        contentPane.background = mint

        contentPane.add(mainlabel1)
        contentPane.add(tx_ID)
        contentPane.add(tx_PassWord)
        contentPane.add(lineID)
        contentPane.add(linePW)
        contentPane.add(LoginButton)
        contentPane.add(RegisterButton)

        contentPane.add(panelMainWhite)


        isResizable = false //화면 크기 고정
        isVisible = true
    }


    /**
     * 이벤트 처리
     *
     * @param actionEvent ActionEvent
     */
    override fun actionPerformed(actionEvent: ActionEvent) {
        when (actionEvent.source) {
            LoginButton -> controller.login(tx_ID.text, tx_PassWord.text)
            RegisterButton -> controller.register()
        }
    }
}
