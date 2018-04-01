/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Rational number (arbitrary size).
 */
public final strictfp class Rational extends Number {
  private static final long serialVersionUID = 1L;

  public final Integer numerator;
  public final Integer denominator;

  public Rational(final long numerator,
                  final long denominator) {
    this.numerator = new Integer(numerator);
    this.denominator = new Integer(denominator);
  }

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

  @Override @NotNull
  public String toString() {
    return java.lang.String.format("%s/%s", this.numerator, this.denominator);
  }
}
