package org.jellyfin.mobile.torrent

interface TorrentProvider {
    val id: String
    suspend fun search(query: String, config: TorrentProviderConfig): List<TorrentCandidate>
}

interface TorrentSearchService {
    suspend fun aggregate(query: String): List<TorrentCandidate>
}

interface TorrentEngine {
    suspend fun startStreaming(request: TorrentPlaybackRequest): Result<TorrentStreamSession>
    suspend fun stopStreaming()
    suspend fun cleanupStaleCache()
}
