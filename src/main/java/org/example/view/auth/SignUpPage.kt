package org.example.view.auth

import org.example.common.FontConfig.mainFont18
import org.example.common.FontConfig.mainFont22
import org.example.common.FontConfig.mainFont30
import org.example.common.FontConfig.mainFont40
import org.example.common.logger
import org.example.common.mintColor
import org.example.controller.SignUpPageController
import org.example.data.dto.user.UserRequestDto
import java.awt.Color
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class SignUpPage : JFrame(), ActionListener {

    private var signUpPageController: SignUpPageController = SignUpPageController(this)

    private var emailTextField: JTextField
    private var passwordTextField: JTextField
    private var nameTextField: JTextField
    private var registerButton: JButton
    private var buttonBack: JButton


    init {
        title = "SignUpPage"
        setSize(1280, 720)

        setLocationRelativeTo(null)
        contentPane.layout = null
        defaultCloseOperation = EXIT_ON_CLOSE


        val panelMainWhite = JPanel()
        panelMainWhite.setBounds(30, 30, 1204, 614)
        panelMainWhite.background = Color.white

        val panelMainMint = JPanel()
        panelMainMint.setBounds(322, 30, 620, 80)
        panelMainMint.background = mintColor

        val mainLabel = JLabel("오점뭐 (오늘 점심 뭐 먹지)")
        mainLabel.horizontalAlignment = JLabel.CENTER
        mainLabel.setBounds(382, 30, 500, 70) //나머지 페이지들도 적용
        mainLabel.font = mainFont40

        val pageLabel = JLabel("-회원가입-")
        pageLabel.horizontalAlignment = JLabel.CENTER
        pageLabel.setBounds(382, 120, 500, 70) //나머지 페이지들도 적용
        pageLabel.font = mainFont30

        nameTextField = JTextField("이름")
        nameTextField.setBounds(482, 220, 300, 43)
        nameTextField.font = mainFont22
        nameTextField.foreground = Color.lightGray
        nameTextField.border = BorderFactory.createEmptyBorder()

        emailTextField = JTextField("아이디")
        emailTextField.setBounds(482, 280, 300, 43)
        emailTextField.font = mainFont22
        emailTextField.foreground = Color.lightGray
        emailTextField.border = BorderFactory.createEmptyBorder()

        passwordTextField = JTextField("비밀번호")
        passwordTextField.setBounds(482, 340, 300, 43)
        passwordTextField.font = mainFont22
        passwordTextField.foreground = Color.lightGray
        passwordTextField.border = BorderFactory.createEmptyBorder()


        registerButton = JButton("회원가입")
        registerButton.setBounds(563, 503, 138, 43)
        registerButton.font = mainFont22
        registerButton.isBorderPainted = false //버튼 테두리 없에기

        registerButton.foreground = Color.white
        registerButton.background = mintColor
        registerButton.actionCommand = "Register"
        registerButton.addActionListener(this)

        buttonBack = JButton("취소")
        buttonBack.setBounds(572, 560, 120, 30)
        buttonBack.font = mainFont18
        buttonBack.isBorderPainted = false //버튼 테두리 없에기
        buttonBack.isContentAreaFilled = false //버튼 내부 색 채움 여부

        //buttonBack.setFocusPainted(false);        //버튼 포커스(클릭시 테두리)
        buttonBack.actionCommand = "BackPage"
        buttonBack.addActionListener(this)


        val lineName = JPanel()
        lineName.setBounds(482, 265, 300, 2)
        val lineID = JPanel()
        lineID.setBounds(482, 325, 300, 2)
        val linePW = JPanel()
        linePW.setBounds(482, 385, 300, 2)



        contentPane.add(pageLabel)
        contentPane.add(lineName)
        contentPane.add(lineID)
        contentPane.add(linePW)

        contentPane.add(nameTextField)
        contentPane.add(passwordTextField)
        contentPane.add(emailTextField)
        contentPane.add(registerButton)
        contentPane.add(buttonBack)
        contentPane.add(mainLabel)

        contentPane.add(panelMainMint)
        contentPane.add(panelMainWhite)
        contentPane.background = mintColor


        isResizable = false //화면 크기 고정
        isVisible = true

    }


    override fun actionPerformed(actionEvent: ActionEvent) {
        when (actionEvent.source) {
            buttonBack -> this.dispose()
            registerButton -> signUpPageController.signUp(
                UserRequestDto(
                    name = nameTextField.text,
                    email = emailTextField.text,
                    password = passwordTextField.text
                )
            )

            else -> logger.error { "actionPerformed Error" }
        }
    }
}
