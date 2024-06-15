package org.example.common

import java.awt.Font
import java.awt.GraphicsEnvironment

/**
 * 폰트 설정
 * 자바 소스에서는 전역변수를 사용할 수 없기 때문에 다음과 같이 object로 선언하여 사용
 */
object FontConfig {

    fun loadFont() {
        val ge: GraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment()
        val font = Font.createFont(Font.TRUETYPE_FONT, javaClass.getResourceAsStream("/font/BMDOHYEON_ttf.ttf"))
        ge.registerFont(font)
    }

    private const val BMDOHYEON: String = "배달의민족 도현"

    val mainFont18: Font = Font(BMDOHYEON, Font.PLAIN, 18)
    val mainFont20: Font = Font(BMDOHYEON, Font.PLAIN, 20)
    val mainFont22: Font = Font(BMDOHYEON, Font.PLAIN, 22)
    val mainFont26: Font = Font(BMDOHYEON, Font.PLAIN, 26)
    val mainFont30: Font = Font(BMDOHYEON, Font.PLAIN, 30)
    val mainFont40: Font = Font(BMDOHYEON, Font.PLAIN, 40)
    val passWordFont: Font = Font("맑은 고딕", Font.BOLD, 22)

    val searchFont30 = Font("맑은 고딕", Font.BOLD, 30)
    val searchIconFont = Font("Segoe MDL2 Assets", Font.PLAIN, 20)
    val buttonFont = Font(BMDOHYEON, Font.PLAIN, 20)

}
