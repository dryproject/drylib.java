/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (64-bit).
 */
final class Int64 extends Int {
  private static final long serialVersionUID = 1L;

  public static final long MIN_VALUE = Long.MIN_VALUE;

  public static final long MAX_VALUE = Long.MAX_VALUE;

  public static final Int64 MIN = new Int64(MIN_VALUE);

  public static final Int64 MAX = new Int64(MAX_VALUE);

  public Int64(final long value) {
    super(value, MIN_VALUE, MAX_VALUE);
  }

  public Int64(@NotNull final BigInteger value) {
    super(value, MIN.value, MAX.value);
  }
}
