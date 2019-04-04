package okio

import okio.ByteString.Companion.encodeUtf8
import kotlin.test.Test
import kotlin.test.assertEquals

class BufferCommonTest {

  @Test fun copyToBuffer() {
    val source = Buffer()
    source.write("party".encodeUtf8())

    val target = Buffer()
    source.copyTo(target)
    assertEquals("party", target.readByteString().utf8())
    assertEquals("party", source.readByteString().utf8())
  }

  @Test fun copyToBufferWithOffset() {
    val source = Buffer()
    source.write("party".encodeUtf8())

    val target = Buffer()
    source.copyTo(target, 2)
    assertEquals("rty", target.readByteString().utf8())
    assertEquals("party", source.readByteString().utf8())
  }

  @Test fun copyToBufferWithByteCount() {
    val source = Buffer()
    source.write("party".encodeUtf8())

    val target = Buffer()
    source.copyTo(target, 0, 3)
    assertEquals("par", target.readByteString().utf8())
    assertEquals("party", source.readByteString().utf8())
  }

  @Test fun copyToBufferWithOffsetAndByteCount() {
    val source = Buffer()
    source.write("party".encodeUtf8())

    val target = Buffer()
    source.copyTo(target, 1, 3)
    assertEquals("art", target.readByteString().utf8())
    assertEquals("party", source.readByteString().utf8())
  }
}
