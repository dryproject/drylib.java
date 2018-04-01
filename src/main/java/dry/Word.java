/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Machine word (native size).
 */
public class Word extends Number {
  private static final long serialVersionUID = 1L;

  public static final int SIZE = Word64.SIZE;

  public static final long MIN_VALUE = Word64.MIN_VALUE;

  public static final long MAX_VALUE = Word64.MAX_VALUE;

  public static final Word MIN = Word64.MIN;

  public static final Word MAX = Word64.MAX;

  public final long value;

  public Word(final long value) {
    this.value = value;
  }

  public long getValue() {
    return this.value;
  }

  @Override
  public long longValue() {
    return this.value;
  }

  @Override
  public double doubleValue() {
    return (double)this.value;
  }

  @Override @NotNull
  public String toString() {
    return java.lang.String.format("0x%016x", this.value);
  }
}
