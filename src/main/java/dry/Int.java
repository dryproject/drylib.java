/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (native size).
 */
public strictfp class Int extends Integer {
  private static final long serialVersionUID = 1L;

  public static final long MIN_VALUE = Int64.MIN_VALUE;

  public static final long MAX_VALUE = Int64.MAX_VALUE;

  public static final Int MIN = Int64.MIN;

  public static final Int MAX = Int64.MAX;

  protected Int(final long value,
                final long min_value,
                final long max_value) {
    super(value, min_value, max_value);
  }

  protected Int(@NotNull final BigInteger value,
                @NotNull final BigInteger min_value,
                @NotNull final BigInteger max_value) {
    super(value, min_value, max_value);
  }

  public Int(final long value) {
    super(value);
  }

  public Int(@NotNull final BigInteger value) {
    super(value);
  }
}
