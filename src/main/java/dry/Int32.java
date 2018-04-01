/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (32-bit).
 */
public final strictfp class Int32 extends Int {
  private static final long serialVersionUID = 1L;

  public static final int SIZE = 4; // bytes

  public static final long MIN_VALUE = java.lang.Integer.MIN_VALUE;

  public static final long MAX_VALUE = java.lang.Integer.MAX_VALUE;

  public static final Int32 MIN = new Int32(MIN_VALUE);

  public static final Int32 MAX = new Int32(MAX_VALUE);

  public Int32(final long value) {
    super(value, MIN_VALUE, MAX_VALUE);
  }

  public Int32(@NotNull final BigInteger value) {
    super(value, MIN.value, MAX.value);
  }
}
