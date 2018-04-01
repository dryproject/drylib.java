/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (8-bit).
 */
public final strictfp class Int8 extends Int {
  private static final long serialVersionUID = 1L;

  public static final int SIZE = 1; // bytes

  public static final long MIN_VALUE = java.lang.Byte.MIN_VALUE;

  public static final long MAX_VALUE = java.lang.Byte.MAX_VALUE;

  public static final Int8 MIN = new Int8(MIN_VALUE);

  public static final Int8 MAX = new Int8(MAX_VALUE);

  public Int8(final long value) {
    super(value, MIN_VALUE, MAX_VALUE);
  }

  public Int8(@NotNull final BigInteger value) {
    super(value, MIN.value, MAX.value);
  }
}
