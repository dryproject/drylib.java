/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Machine word (8-bit).
 *
 * @see <a href="https://drylib.org/base/word8">[1]</a>
 */
public final class Word8 extends AbstractWord implements Word {
  @NotNull
  public static Word8 of(final long value) {
    return new Word8(value);
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 1; // bytes

  public static final long MIN_VALUE = 0L;

  public static final long MAX_VALUE = 0xFFL;

  public static final Word8 MIN = new Word8(MIN_VALUE);

  public static final Word8 MAX = new Word8(MAX_VALUE);

  public static final Word8 ZERO = MIN;

  protected Word8(final long value) {
    super(value);
  }

  @Override @NotNull
  public java.lang.String toString() {
    return java.lang.String.format("0x%02x", this.value);
  }
}
