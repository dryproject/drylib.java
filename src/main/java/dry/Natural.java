/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Natural number (arbitrary size).
 */
class Natural extends Integer {
  private static final long serialVersionUID = 1L;

  public static final long MIN_VALUE = 0L;

  public static final Natural MIN = new Natural(MIN_VALUE);

  public static final Natural ZERO = MIN;

  public Natural(final long value) {
    super(value);
  }

  public Natural(@NotNull final BigInteger value) {
    super(value);
  }
}
