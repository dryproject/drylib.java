/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (16-bit).
 */
public final strictfp class Int16 extends Int {
  @NotNull
  public static Int16 valueOf(final long value) {
    return new Int16(value);
  }

  @NotNull
  public static Int16 valueOf(@NotNull final BigInteger value) {
    return new Int16(value);
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 2; // bytes

  public static final long MIN_VALUE = java.lang.Short.MIN_VALUE;

  public static final long MAX_VALUE = java.lang.Short.MAX_VALUE;

  public static final Int16 MIN = new Int16(MIN_VALUE);

  public static final Int16 MAX = new Int16(MAX_VALUE);

  protected Int16(final long value) {
    super(value, MIN_VALUE, MAX_VALUE);
  }

  protected Int16(@NotNull final BigInteger value) {
    super(value, MIN.value, MAX.value);
  }
}
