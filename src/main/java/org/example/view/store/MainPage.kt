package org.example.view.store

import org.example.common.FontConfig.buttonFont
import org.example.common.FontConfig.mainFont22
import org.example.common.FontConfig.mainFont30
import org.example.common.FontConfig.mainFont40
import org.example.controller.MainPageController
import org.example.data.dto.store.FoodType
import org.example.data.dto.store.Location.Companion.getAllKoreanNames
import org.example.data.repository.local_repository.UserLocalRepository.user
import java.awt.Color
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import javax.swing.*

/**
 * 메인 페이지  화면
 */
class MainPage : JFrame(), ActionListener, ItemListener {
    private var mainPageController: MainPageController = MainPageController(this)

    // UI Components
    private var selectLocation: JComboBox<String>
    private var textMainSearch: JTextField //search_bar
    private var quickSearch: JButton // bar_button
    private var mainButton_kr: JButton //한식버튼
    private var mainButton_ch: JButton //중식버튼
    private var mainButton_jp: JButton //일식버튼
    private var mainButton_DS: JButton //디저트버튼
    private var mainButton_FD: JButton //패스트푸드 버튼
    private var mainButton_SB: JButton //분식 버튼
    private var mainButton_DC: JCheckBox // 지역화폐
    private var mainButton_CC: JCheckBox // 아동급식카드
    private var mainButton_ZC: JCheckBox // 모범음식점
    private var mainButton_Search: JButton //가게찾기 버튼
    private var mainButton_Random: JButton //랜덤 가게 추천 버튼
    private var buttonAdminPage: JButton // 관리자 페이지 버튼
    private var buttonEditUser: JButton // 개인정보수정 버튼
    private var buttonLogout: JButton // 로그아웃 버튼

    init {
        title = "TestMain Screen"
        setSize(1280, 720)

        setLocationRelativeTo(null)
        contentPane.layout = null
        defaultCloseOperation = EXIT_ON_CLOSE


        val mint = Color(62, 185, 180)
        val gray1 = Color(192, 192, 192)


        val panelMainWhite = JPanel()
        panelMainWhite.setBounds(30, 30, 1204, 614)
        panelMainWhite.background = Color.white

        val panelMainMint = JPanel()
        panelMainMint.setBounds(332, 30, 600, 170)
        panelMainMint.background = mint

        val panelSearch = JPanel()
        panelSearch.setBounds(370, 125, 524, 43)
        panelSearch.background = Color.white


        val labelMain = JLabel("오점뭐 (오늘 점심 뭐 먹지)")
        labelMain.setBounds(382, 34, 500, 100)
        labelMain.horizontalAlignment = JLabel.CENTER
        labelMain.font = mainFont40

        val locations = getAllKoreanNames()

        selectLocation = JComboBox(locations)
        selectLocation.setBounds(370, 105, 100, 20)
        selectLocation.addActionListener(this)
        selectLocation.actionCommand = "location"

        textMainSearch = JTextField("상호명 검색")
        textMainSearch.setBounds(378, 125, 420, 43)
        textMainSearch.border = BorderFactory.createEmptyBorder()
        textMainSearch.font = mainFont30
        textMainSearch.foreground = gray1

        quickSearch = JButton("\uE71E")
        quickSearch.setBounds(831, 130, 60, 34)
        quickSearch.font = mainFont30

        //quickSearch.setBorderPainted(false);      //버튼 테두리 없에기
        quickSearch.isContentAreaFilled = false
        quickSearch.actionCommand = "bSearch"
        quickSearch.addActionListener(this)
        quickSearch.isFocusPainted = false

        buttonEditUser = JButton("개인정보수정")
        buttonEditUser.setBounds(1020, 50, 180, 40)
        buttonEditUser.verticalTextPosition = JButton.BOTTOM
        buttonEditUser.horizontalTextPosition = JButton.CENTER
        buttonEditUser.font = buttonFont
        buttonEditUser.isBorderPainted = false //버튼 테두리 없에기

        buttonEditUser.background = mint
        buttonEditUser.actionCommand = "editUser"
        buttonEditUser.addActionListener(this)
        buttonEditUser.isFocusPainted = false


        mainButton_kr = JButton("한식", ImageIcon(javaClass.getResource("/image/bibimbap.png")))
        mainButton_kr.setBounds(411, 210, 107, 100)
        mainButton_kr.verticalTextPosition = JButton.BOTTOM
        mainButton_kr.horizontalTextPosition = JButton.CENTER
        mainButton_kr.font = mainFont22
        mainButton_kr.isBorderPainted = false //버튼 테두리 없에기
        mainButton_kr.isContentAreaFilled = false
        mainButton_kr.actionCommand = "bKorean"
        mainButton_kr.addActionListener(this)


        mainButton_ch = JButton("중식", ImageIcon(javaClass.getResource("/image/dimsum.png")))
        mainButton_ch.setBounds(575, 210, 107, 100)
        mainButton_ch.verticalTextPosition = JButton.BOTTOM
        mainButton_ch.horizontalTextPosition = JButton.CENTER
        mainButton_ch.font = mainFont22
        mainButton_ch.isBorderPainted = false //버튼 테두리 없에기
        mainButton_ch.isContentAreaFilled = false
        mainButton_ch.actionCommand = "bChinese"
        mainButton_ch.addActionListener(this)


        mainButton_jp = JButton("일식", ImageIcon(javaClass.getResource("/image/sushi.png")))
        mainButton_jp.setBounds(721, 210, 107, 100)
        mainButton_jp.verticalTextPosition = JButton.BOTTOM
        mainButton_jp.horizontalTextPosition = JButton.CENTER
        mainButton_jp.font = mainFont22
        mainButton_jp.isBorderPainted = false //버튼 테두리 없에기
        mainButton_jp.isContentAreaFilled = false
        mainButton_jp.actionCommand = "bJapanese"
        mainButton_jp.addActionListener(this)


        mainButton_DS = JButton("제과점", ImageIcon(javaClass.getResource("/image/cake.png")))
        mainButton_DS.setBounds(406, 307, 115, 100)
        mainButton_DS.verticalTextPosition = JButton.BOTTOM
        mainButton_DS.horizontalTextPosition = JButton.CENTER
        mainButton_DS.font = mainFont22
        mainButton_DS.isBorderPainted = false //버튼 테두리 없에기
        mainButton_DS.isContentAreaFilled = false
        mainButton_DS.actionCommand = "bDessert"
        mainButton_DS.addActionListener(this)


        mainButton_FD = JButton("패스트푸드", ImageIcon(javaClass.getResource("/image/fastfood.png")))
        mainButton_FD.setBounds(558, 307, 140, 100)
        mainButton_FD.verticalTextPosition = JButton.BOTTOM
        mainButton_FD.horizontalTextPosition = JButton.CENTER
        mainButton_FD.font = mainFont22
        mainButton_FD.isBorderPainted = false //버튼 테두리 없에기
        mainButton_FD.isContentAreaFilled = false
        mainButton_FD.actionCommand = "bFastfood"
        mainButton_FD.addActionListener(this)


        mainButton_SB = JButton("분식", ImageIcon(javaClass.getResource("/image/ramen.png")))
        mainButton_SB.setBounds(721, 307, 107, 100)
        mainButton_SB.verticalTextPosition = JButton.BOTTOM
        mainButton_SB.horizontalTextPosition = JButton.CENTER
        mainButton_SB.font = mainFont22
        mainButton_SB.isBorderPainted = false //버튼 테두리 없에기
        mainButton_SB.isContentAreaFilled = false
        mainButton_SB.actionCommand = "bSnackfood"
        mainButton_SB.addActionListener(this)


        mainButton_DC = JCheckBox("착한가격")
        mainButton_DC.setBounds(400, 450, 120, 34)
        mainButton_DC.font = mainFont22
        mainButton_DC.isBorderPainted = false //버튼 테두리 없에기
        mainButton_DC.isContentAreaFilled = false
        mainButton_DC.addItemListener(this)


        mainButton_CC = JCheckBox("아동급식카드")
        mainButton_CC.setBounds(543, 450, 170, 34)
        mainButton_CC.font = mainFont22
        mainButton_CC.isBorderPainted = false //버튼 테두리 없에기
        mainButton_CC.isContentAreaFilled = false
        mainButton_CC.addItemListener(this)


        mainButton_ZC = JCheckBox("모범음식점")
        mainButton_ZC.setBounds(709, 450, 150, 34)
        mainButton_ZC.font = mainFont22
        mainButton_ZC.isBorderPainted = false //버튼 테두리 없에기
        mainButton_ZC.isContentAreaFilled = false
        mainButton_ZC.addItemListener(this)


        mainButton_Search = JButton("식당 찾기")
        mainButton_Search.setBounds(563, 503, 138, 43)
        mainButton_Search.font = mainFont22
        mainButton_Search.background = mint
        mainButton_Search.isBorderPainted = false
        mainButton_Search.actionCommand = "VIEW_LIST"
        mainButton_Search.addActionListener(this)

        mainButton_Random = JButton("오늘의 추천 메뉴")
        mainButton_Random.setBounds(482, 570, 300, 53)
        mainButton_Random.font = mainFont30
        mainButton_Random.foreground = Color.YELLOW
        mainButton_Random.background = mint
        mainButton_Random.isBorderPainted = false
        mainButton_Random.actionCommand = "TODAY MENU"
        mainButton_Random.addActionListener(this)

        buttonAdminPage = JButton("관리자 화면")
        buttonAdminPage.setBounds(1020, 100, 180, 40)
        buttonAdminPage.font = buttonFont
        buttonAdminPage.background = mint
        buttonAdminPage.isBorderPainted = false
        buttonAdminPage.actionCommand = "ViewAdminPage"
        buttonAdminPage.addActionListener(this)
        buttonAdminPage.isVisible = user!!.role.contains("ADMIN")


        buttonLogout = JButton("로그아웃")
        buttonLogout.setBounds(1020, 100, 180, 40)
        buttonLogout.font = buttonFont
        buttonLogout.isContentAreaFilled = false
        buttonLogout.isBorderPainted = false
        buttonLogout.actionCommand = "Logout"
        buttonLogout.addActionListener(this)
        buttonLogout.isVisible = true


        contentPane.background = mint

        contentPane.add(labelMain)
        contentPane.add(textMainSearch)
        contentPane.add(quickSearch)
        contentPane.add(selectLocation)
        contentPane.add(buttonEditUser)

        contentPane.add(mainButton_kr)
        contentPane.add(mainButton_ch)
        contentPane.add(mainButton_jp)
        contentPane.add(mainButton_DS)
        contentPane.add(mainButton_FD)
        contentPane.add(mainButton_SB)
        contentPane.add(mainButton_DC)
        contentPane.add(mainButton_CC)
        contentPane.add(mainButton_ZC)
        contentPane.add(mainButton_Search)
        contentPane.add(mainButton_Random)
        contentPane.add(buttonAdminPage)
        contentPane.add(buttonLogout)

        contentPane.add(panelSearch)
        contentPane.add(panelMainMint)
        contentPane.add(panelMainWhite)


        isResizable = false //화면 크기 고정
        isVisible = true

    }

    /**
     * Action Event (버튼 클릭 시)
     */
    override fun actionPerformed(actionEvent: ActionEvent) {
        when (actionEvent.source) {
            selectLocation -> mainPageController.selectedLocation = selectLocation.selectedItem.toString()
            textMainSearch -> mainPageController.searchStore()
            quickSearch -> mainPageController.searchStore()
            mainButton_kr -> mainPageController.category = FoodType.KOREAN
            mainButton_ch -> mainPageController.category = FoodType.CHINESE
            mainButton_jp -> mainPageController.category = FoodType.JAPANESE
            mainButton_DS -> mainPageController.category = FoodType.DESSERT
            mainButton_FD -> mainPageController.category = FoodType.FASTFOOD
            mainButton_SB -> mainPageController.category = FoodType.SNACK
            mainButton_Search -> mainPageController.searchStore()
            mainButton_Random -> mainPageController.randomStore()
            buttonLogout -> mainPageController.logout()
            buttonEditUser -> mainPageController.modifyUserInfo()
        }
    }

    /**
     *  Item Event (체크박스 선택 시)
     */
    override fun itemStateChanged(e: ItemEvent) {
        when (e.source) {
            mainButton_DC -> mainPageController.localCurrency = mainButton_DC.isSelected
            mainButton_CC -> mainPageController.forChild = mainButton_CC.isSelected
            mainButton_ZC -> mainPageController.roleModel = mainButton_ZC.isSelected
        }
    }
}
