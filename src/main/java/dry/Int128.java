/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (128-bit).
 */
public final strictfp class Int128 extends Int {
  private static final long serialVersionUID = 1L;

  public static final BigInteger MIN_VALUE = BigInteger.valueOf(Long.MIN_VALUE); // FIXME

  public static final BigInteger MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE); // FIXME

  public static final Int128 MIN = new Int128(Long.MIN_VALUE);

  public static final Int128 MAX = new Int128(Long.MAX_VALUE);

  public Int128(final long value) {
    super(BigInteger.valueOf(value), MIN_VALUE, MAX_VALUE);
  }

  public Int128(@NotNull final BigInteger value) {
    super(value, MIN.value, MAX.value);
  }
}
