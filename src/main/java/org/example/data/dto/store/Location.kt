package org.example.data.dto.store

enum class Location(val koreanName: String) {
    BUSANJIN_GU("부산진구"),
    SASANG_GU("사상구"),
    HAEUNDAE_GU("해운대구"),
    BUK_GU("북구"),
    SAHA_GU("사하구"),
    NAM_GU("남구"),
    SEO_GU("서구"),
    DONG_GU("동구"),
    YEONJE_GU("연제구"),
    JUNG_GU("중구"),
    GIJANG_GUN("기장군"),
    SUYEONG_GU("수영구"),
    GEUMJEONG_GU("금정구"),
    YEONGDO_GU("영도구"),
    GANGSEO_GU("강서구");

    override fun toString(): String {
        return koreanName
    }

    companion object {
        fun getAllKoreanNames(): Array<String> {
            return values().map { it.koreanName }.toTypedArray()
        }
    }
}
