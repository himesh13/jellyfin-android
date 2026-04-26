package org.jellyfin.mobile.torrent

import kotlinx.serialization.Serializable

@Serializable
data class TorrentProviderConfig(
    val id: String,
    val baseUrl: String,
    val enabled: Boolean = true,
    val timeoutMs: Long = 8_000L,
)

@Serializable
data class TorrentCandidate(
    val title: String,
    val magnetUri: String? = null,
    val torrentUrl: String? = null,
    val sizeBytes: Long? = null,
    val seeders: Int? = null,
    val qualityLabel: String? = null,
    val source: String,
)

@Serializable
data class TorrentPlaybackRequest(
    val title: String,
    val magnetUri: String? = null,
    val torrentUrl: String? = null,
    val trackers: List<String> = emptyList(),
)

data class TorrentStreamSession(
    val localStreamUrl: String,
    val cachePath: String? = null,
)
