package org.jellyfin.mobile.torrent

import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.jellyfin.mobile.app.AppPreferences

class TorrentProviderRepository(
    private val appPreferences: AppPreferences,
) {
    fun getConfiguredProviders(): List<TorrentProviderConfig> {
        return runCatching {
            Json.decodeFromString<List<TorrentProviderConfig>>(appPreferences.torrentProviderConfig)
        }.getOrDefault(emptyList())
    }

    fun setConfiguredProviders(configs: List<TorrentProviderConfig>) {
        appPreferences.torrentProviderConfig = Json.encodeToString(configs)
    }
}
