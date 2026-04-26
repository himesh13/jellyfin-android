package org.jellyfin.mobile.player.interaction

enum class PlaybackMode {
    VIDEO_AUDIO,
    AUDIO_ONLY,
    ;

    companion object {
        fun fromValue(value: String?): PlaybackMode = entries.firstOrNull { mode ->
            mode.name.equals(value, ignoreCase = true)
        } ?: VIDEO_AUDIO
    }
}
