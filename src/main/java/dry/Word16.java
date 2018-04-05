/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Machine word (16-bit).
 */
public final class Word16 extends AbstractWord implements Word {
  @NotNull
  public static Word16 of(final long value) {
    return new Word16(value);
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 2; // bytes

  public static final long MIN_VALUE = 0L;

  public static final long MAX_VALUE = 0xFFFFL;

  public static final Word16 MIN = new Word16(MIN_VALUE);

  public static final Word16 MAX = new Word16(MAX_VALUE);

  public static final Word16 ZERO = MIN;

  protected Word16(final long value) {
    super(value);
  }

  @Override @NotNull
  public String toString() {
    return java.lang.String.format("0x%04x", this.value);
  }
}
