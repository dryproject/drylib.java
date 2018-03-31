/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Machine word (64-bit).
 */
public final class Word64 extends Word {
  private static final long serialVersionUID = 1L;

  public static final long MIN_VALUE = 0L;

  public static final long MAX_VALUE = -1L;

  public static final Word64 MIN = new Word64(MIN_VALUE);

  public static final Word64 MAX = new Word64(MAX_VALUE);

  public Word64(final long value) {
    super(value);
  }
}
