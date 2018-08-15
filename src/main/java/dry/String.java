/* This is free and unencumbered software released into the public domain. */

package dry;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.jetbrains.annotations.NotNull;

/**
 * A string.
 *
 * @see <a href="https://drylib.org/base/string">[1]</a>
 */
public interface String extends Datum, Comparable<String>, Cloneable, Readable {
  public @NotNull String clone();

  @Override
  public int read(@NotNull CharBuffer buffer);

  public @NotNull Charset charset();

  /**
   * Checks if this string is empty.
   *
   * @return <tt>true</tt> if this is an empty string, <tt>false</tt> otherwise
   */
  public boolean isEmpty();

  /**
   * Checks if this string is blank.
   *
   * @return <tt>true</tt> if this is a blank string, <tt>false</tt> otherwise
   */
  public boolean isBlank();

  public boolean is(@NotNull java.lang.String string);

  public @NotNull Nat size();

  public @NotNull byte[] toByteArray();

  default public @NotNull ByteBuffer toByteBuffer() {
    return ByteBuffer.wrap(this.toByteArray());
  }
}
