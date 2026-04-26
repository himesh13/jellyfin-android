package org.jellyfin.mobile.torrent

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import org.jellyfin.mobile.app.AppPreferences
import timber.log.Timber

class TorrentProviderRepository(
    private val appPreferences: AppPreferences,
) {
    fun getConfiguredProviders(): List<TorrentProviderConfig> {
        return runCatching {
            Json.decodeFromString(
                ListSerializer(TorrentProviderConfig.serializer()),
                appPreferences.torrentProviderConfig,
            )
        }.onFailure { error ->
            Timber.w(error, "Failed to parse torrent provider config")
        }.getOrDefault(emptyList())
    }

    fun setConfiguredProviders(configs: List<TorrentProviderConfig>) {
        appPreferences.torrentProviderConfig = Json.encodeToString(
            ListSerializer(TorrentProviderConfig.serializer()),
            configs,
        )
    }
}
