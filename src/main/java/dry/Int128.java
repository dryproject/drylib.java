/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (128-bit).
 */
public final strictfp class Int128 extends Integer.Bignum implements Int {
  @NotNull
  public static Int128 of(final long value) {
    return new Int128(value);
  }

  @NotNull
  public static Int128 of(@NotNull final BigInteger value) {
    return new Int128(value);
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 16; // bytes

  public static final BigInteger MIN_VALUE = BigInteger.valueOf(java.lang.Long.MIN_VALUE); // FIXME

  public static final BigInteger MAX_VALUE = BigInteger.valueOf(java.lang.Long.MAX_VALUE); // FIXME

  public static final Int128 MIN = new Int128(java.lang.Long.MIN_VALUE);

  public static final Int128 MAX = new Int128(java.lang.Long.MAX_VALUE);

  protected Int128(final long value) {
    super(BigInteger.valueOf(value), MIN_VALUE, MAX_VALUE);
  }

  protected Int128(@NotNull final BigInteger value) {
    super(value, MIN.value, MAX.value);
  }

  @Override
  public int size() {
    return SIZE;
  }
}
