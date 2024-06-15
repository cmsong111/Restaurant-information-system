package org.example.view.auth

import org.example.common.*
import org.example.controller.LoginPageController
import java.awt.Color
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

/**
 * 로그인 페이지
 */
class LoginPage : JFrame(), ActionListener {
    private val controller = LoginPageController(this)

    private var titleLabel: JLabel
    private var emailTextField: JTextField
    private var passWordTextField: JPasswordField
    private var loginButton: JButton
    private var registerButton: JButton

    /**
     * 생성자
     */
    init {
        title = "LoginTest Screen"
        setSize(750, 720)

        setLocationRelativeTo(null)
        contentPane.layout = null
        defaultCloseOperation = EXIT_ON_CLOSE

        val panelMainWhite = JPanel() //배경 만들기
        val lineID = JPanel()
        val linePW = JPanel()

        panelMainWhite.setBounds(26, 28, 684, 612) //배경 만들기
        lineID.setBounds(200, 330, 300, 2)
        linePW.setBounds(200, 430, 300, 2)


        // 타이틀 라벨 설정
        titleLabel = JLabel("오점뭐 (오늘 점심 뭐 먹지)")
        titleLabel.setBounds(140, 56, 619, 61)
        titleLabel.font = mainFont40

        // 이메일 입력 필드 설정
        emailTextField = JTextField("email")
        emailTextField.setBounds(200, 280, 300, 43)
        emailTextField.font = mainFont20
        emailTextField.foreground = gray1
        emailTextField.border = BorderFactory.createEmptyBorder()

        // 패스워드 입력 필드 설정
        passWordTextField = JPasswordField("password")
        passWordTextField.setBounds(200, 380, 300, 43)
        passWordTextField.font = passWordFont
        passWordTextField.foreground = gray1
        passWordTextField.border = BorderFactory.createEmptyBorder()

        // 로그인 버튼 설정
        loginButton = JButton("로그인")
        loginButton.setBounds(290, 490, 115, 34)
        loginButton.font = mainFont20
        loginButton.isBorderPainted = false //버튼 테두리 없에기
        loginButton.isContentAreaFilled = false
        loginButton.addActionListener(this)

        // 회원가입 버튼 설정
        registerButton = JButton("회원가입")
        registerButton.setBounds(285, 540, 130, 34)
        registerButton.font = mainFont20
        registerButton.isBorderPainted = false //버튼 테두리 없에기
        registerButton.addActionListener(this)
        registerButton.foreground = Color.white
        registerButton.background = mintColor

        // 메인 패널 설정
        panelMainWhite.background = Color.white
        contentPane.background = mintColor

        // Component 추가
        contentPane.add(titleLabel)
        contentPane.add(emailTextField)
        contentPane.add(passWordTextField)
        contentPane.add(lineID)
        contentPane.add(linePW)
        contentPane.add(loginButton)
        contentPane.add(registerButton)
        contentPane.add(panelMainWhite)

        // 화면 설정
        isResizable = false
        isVisible = true
    }


    /**
     * 이벤트 처리
     *
     * @param actionEvent ActionEvent
     */
    override fun actionPerformed(actionEvent: ActionEvent) {
        when (actionEvent.source) {
            loginButton -> controller.login(emailTextField.text, passWordTextField.text)
            registerButton -> controller.register()
        }
    }
}
