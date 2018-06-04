/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Machine word (64-bit).
 *
 * @see <a href="https://drylib.org/base/word64">[1]</a>
 */
public final class Word64 extends AbstractWord implements Word {
  @NotNull
  public static Word64 of(final long value) {
    return new Word64(value);
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 8; // bytes

  public static final long MIN_VALUE = 0L;

  public static final long MAX_VALUE = -1L;

  public static final Word64 MIN = new Word64(MIN_VALUE);

  public static final Word64 MAX = new Word64(MAX_VALUE);

  public static final Word64 ZERO = MIN;

  protected Word64(final long value) {
    super(value);
  }

  @Override @NotNull
  public String toString() {
    return java.lang.String.format("0x%016x", this.value);
  }
}
