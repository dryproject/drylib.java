/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (16-bit).
 */
public final strictfp class Int16 extends Int {
  private static final long serialVersionUID = 1L;

  public static final long MIN_VALUE = Short.MIN_VALUE;

  public static final long MAX_VALUE = Short.MAX_VALUE;

  public static final Int16 MIN = new Int16(MIN_VALUE);

  public static final Int16 MAX = new Int16(MAX_VALUE);

  public Int16(final long value) {
    super(value, MIN_VALUE, MAX_VALUE);
  }

  public Int16(@NotNull final BigInteger value) {
    super(value, MIN.value, MAX.value);
  }
}
