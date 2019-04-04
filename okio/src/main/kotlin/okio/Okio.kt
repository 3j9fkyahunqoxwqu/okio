package okio

/**
 * Returns a new source that buffers reads from `source`. The returned source will perform bulk
 * reads into its in-memory buffer. Use this wherever you read a source to get an ergonomic and
 * efficient access to data.
 */
expect fun Source.buffer(): BufferedSource

/**
 * Returns a new sink that buffers writes to `sink`. The returned sink will batch writes to `sink`.
 * Use this wherever you write to a sink to get an ergonomic and efficient access to data.
 */
expect fun Sink.buffer(): BufferedSink

/** Returns a sink that writes nowhere. */
expect fun blackholeSink(): Sink
