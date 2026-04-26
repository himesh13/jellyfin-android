package org.jellyfin.mobile.torrent

import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.jellyfin.mobile.app.AppPreferences
import timber.log.Timber

class TorrentProviderRepository(
    private val appPreferences: AppPreferences,
) {
    fun getConfiguredProviders(): List<TorrentProviderConfig> {
        return runCatching {
            Json.decodeFromString<List<TorrentProviderConfig>>(appPreferences.torrentProviderConfig)
        }.onFailure { error ->
            Timber.w(error, "Failed to parse torrent provider config")
        }.getOrDefault(emptyList())
    }

    fun setConfiguredProviders(configs: List<TorrentProviderConfig>) {
        appPreferences.torrentProviderConfig = Json.encodeToString(configs)
    }
}
