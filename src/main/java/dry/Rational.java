/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Rational number (arbitrary size).
 */
final class Rational extends Number {
  public final Integer numerator;
  public final Integer denominator;

  public Rational(@NotNull final Integer numerator,
                  @NotNull final Integer denominator) {
    if (numerator == null) throw new NullPointerException();
    if (denominator == null) throw new NullPointerException();
    this.numerator = numerator;
    this.denominator = denominator;
  }

  @NotNull
  public Integer getNumerator() {
    return this.numerator;
  }

  @NotNull
  public Integer getDenominator() {
    return this.denominator;
  }
}
