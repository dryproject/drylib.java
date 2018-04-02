/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (32-bit).
 */
public final strictfp class Int32 extends Integer.Fixnum implements Int {
  @NotNull
  public static Int32 valueOf(final long value) {
    return new Int32(value);
  }

  @NotNull
  public static Int32 valueOf(@NotNull final BigInteger value) {
    return new Int32(value);
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 4; // bytes

  public static final long MIN_VALUE = java.lang.Integer.MIN_VALUE;

  public static final long MAX_VALUE = java.lang.Integer.MAX_VALUE;

  public static final Int32 MIN = new Int32(MIN_VALUE);

  public static final Int32 MAX = new Int32(MAX_VALUE);

  protected Int32(final long value) {
    super(value, MIN_VALUE, MAX_VALUE);
  }

  protected Int32(@NotNull final BigInteger value) {
    super(value, MIN.value, MAX.value);
  }
}
