/* This is free and unencumbered software released into the public domain. */

package dry.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Optional;

import dry.Char;
import dry.Nat;

import org.jetbrains.annotations.NotNull;

/**
 * UTF-8 text processing.
 *
 * @see <a href="https://drylib.org/text/utf8/">[1]</a>
 */
public final class UTF8 {
  private UTF8() {}

  public static final Charset CHARSET = StandardCharsets.UTF_8;

  /**
   * Implements <tt>dry:text/utf8/string</tt>.
   *
   * @see <a href="https://drylib.org/text/utf8/string">[1]</a>
   */
  public interface String extends dry.String {}
}
