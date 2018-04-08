/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Natural number (arbitrary size).
 *
 * @see <a href="https://drylib.org/core/natural">[1]</a>
 */
public strictfp class Natural extends Integer.Bignum implements Integer {
  @NotNull
  public static Natural of(final long value) {
    return new Natural(value);
  }

  @NotNull
  public static Natural of(@NotNull final BigInteger value) {
    return new Natural(value);
  }

  private static final long serialVersionUID = 1L;

  public static final long MIN_VALUE = 0L;

  public static final Natural MIN = new Natural(MIN_VALUE);

  public static final Natural ZERO = MIN;

  public static final Natural ONE = new Natural(1L);

  public static final Natural TWO = new Natural(2L);

  public static final Natural TEN = new Natural(10L);

  protected Natural(final long value) {
    super(value, MIN_VALUE);
  }

  protected Natural(@NotNull final BigInteger value) {
    super(value, MIN.value, null);
  }
}
