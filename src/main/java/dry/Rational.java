/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Rational number (arbitrary size).
 *
 * @see <a href="https://drylib.org/base/rational">[1]</a>
 */
public strictfp interface Rational extends Real {
  @NotNull
  public static Rational of(final long numerator,
                            final long denominator) {
    return new BigRational(Integer.of(numerator), Integer.of(denominator));
  }

  @NotNull
  public static Rational of(@NotNull final Integer numerator,
                            @NotNull final Integer denominator) {
    return new BigRational(numerator, denominator);
  }

  public static final Rational ZERO = new BigRational(Integer.ZERO, Integer.ONE);

  @NotNull
  public Integer numerator();

  @NotNull
  public Integer denominator();

  public boolean is(long value);

  final strictfp class BigRational extends ExactNumber implements Rational {
    private static final long serialVersionUID = 1L;

    public final Integer numerator;
    public final Integer denominator;

    protected BigRational(@NotNull final Integer numerator,
                          @NotNull final Integer denominator) {
      this.numerator = Objects.requireNonNull(numerator);
      this.denominator = Objects.requireNonNull(denominator);
    }

    @Override @NotNull
    public Integer numerator() {
      return this.numerator;
    }

    @Override @NotNull
    public Integer denominator() {
      return this.denominator;
    }

    @Override
    public boolean isZero() {
      return this == Rational.ZERO || this.is(0L);
    }

    @Override
    public boolean is(final long value) {
      return this.denominator.is(1) && this.numerator.is(value);
    }

    @Override @NotNull
    public Real real() {
      return this;
    }

    @Override @NotNull
    public Real imaginary() {
      return Integer.ZERO;
    }

    @Override
    public int signum() {
      return this.numerator.value().signum();
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.numerator, this.denominator);
    }

    @Override
    public boolean equals(@Nullable final Object object) {
      if (this == object) return true;
      if (object == null) return false;
      if (!(object instanceof BigRational)) return false;
      final BigRational that = (BigRational)object;
      return Objects.equals(this.numerator, that.numerator) &&
        Objects.equals(this.denominator, that.denominator);
    }

    @Override @NotNull
    public java.lang.String toString() {
      return java.lang.String.format("%s/%s", this.numerator, this.denominator);
    }
  }
}
