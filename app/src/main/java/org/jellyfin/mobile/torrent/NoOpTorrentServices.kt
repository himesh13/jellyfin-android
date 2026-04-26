package org.jellyfin.mobile.torrent

import org.jellyfin.mobile.BuildConfig

class NoOpTorrentEngine : TorrentEngine {
    override suspend fun startStreaming(request: TorrentPlaybackRequest): Result<TorrentStreamSession> {
        val reason = if (BuildConfig.ENABLE_TORRENT_STREAMING) {
            "No torrent engine configured"
        } else {
            "Torrent streaming disabled"
        }
        return Result.failure(UnsupportedOperationException(reason))
    }

    override suspend fun stopStreaming() = Unit

    override suspend fun cleanupStaleCache() = Unit
}

class NoOpTorrentSearchService : TorrentSearchService {
    override suspend fun aggregate(query: String): List<TorrentCandidate> = emptyList()
}
