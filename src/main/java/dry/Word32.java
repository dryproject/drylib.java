/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Machine word (32-bit).
 */
public final class Word32 extends Word {
  private static final long serialVersionUID = 1L;

  public static final long MIN_VALUE = 0L;

  public static final long MAX_VALUE = 0xFFFFFFFFL;

  public static final Word32 MIN = new Word32(MIN_VALUE);

  public static final Word32 MAX = new Word32(MAX_VALUE);

  public Word32(final long value) {
    super(value);
  }

  @Override @NotNull
  public String toString() {
    return java.lang.String.format("0x%08x", this.value);
  }
}
