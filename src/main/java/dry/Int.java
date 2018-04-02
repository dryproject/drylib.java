/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (native size).
 */
public strictfp interface Int extends Integer {
  @NotNull
  public static Int valueOf(final long value) {
    return Int64.valueOf(value);
  }

  @NotNull
  public static Int valueOf(@NotNull final BigInteger value) {
    return Int64.valueOf(value);
  }

  public static final int SIZE = Int64.SIZE;

  public static final long MIN_VALUE = Int64.MIN_VALUE;

  public static final long MAX_VALUE = Int64.MAX_VALUE;

  public static final Int MIN = Int64.MIN;

  public static final Int MAX = Int64.MAX;
}
