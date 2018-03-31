/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Machine word (8-bit).
 */
public final class Word8 extends Word {
  private static final long serialVersionUID = 1L;

  public static final long MIN_VALUE = 0L;

  public static final long MAX_VALUE = 0xFFL;

  public static final Word8 MIN = new Word8(MIN_VALUE);

  public static final Word8 MAX = new Word8(MAX_VALUE);

  public Word8(final long value) {
    super(value);
  }
}
