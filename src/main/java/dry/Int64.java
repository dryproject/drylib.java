/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (64-bit).
 *
 * @see <a href="https://drylib.org/base/int64">[1]</a>
 */
public final strictfp class Int64 extends Integer.Fixnum implements Int {
  @NotNull
  public static Int64 of(final long value) {
    return new Int64(value);
  }

  @NotNull
  public static Int64 of(@NotNull final BigInteger value) {
    return new Int64(value);
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 8; // bytes

  public static final long MIN_VALUE = java.lang.Long.MIN_VALUE;

  public static final long MAX_VALUE = java.lang.Long.MAX_VALUE;

  public static final Int64 MIN = new Int64(MIN_VALUE);

  public static final Int64 MAX = new Int64(MAX_VALUE);

  protected Int64(final long value) {
    super(value);
  }

  protected Int64(@NotNull final BigInteger value) {
    super(value, MIN.value, MAX.value);
  }

  @Override
  public int size() {
    return SIZE;
  }
}
