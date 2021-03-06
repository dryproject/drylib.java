/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Real number (arbitrary size).
 *
 * @see <a href="https://drylib.org/base/real">[1]</a>
 */
public strictfp interface Real extends Complex {
  @NotNull
  public static Real of(final double value) {
    return new BigReal(BigDecimal.valueOf(value));
  }

  @NotNull
  public static Real of(final long value) {
    return new BigReal(BigDecimal.valueOf(value));
  }

  @NotNull
  public static Real of(@NotNull final BigDecimal value) {
    return new BigReal(value);
  }

  @NotNull
  public static Real of(@NotNull final BigInteger value) {
    return new BigReal(new BigDecimal(value));
  }

  public static final Real ZERO = new BigReal(BigDecimal.ZERO);

  public boolean is(long value);

  public int signum();

  final strictfp class BigReal extends ExactNumber implements Real {
    private static final long serialVersionUID = 1L;

    public final BigDecimal value;

    public BigReal(@NotNull final BigDecimal value) {
      this.value = Objects.requireNonNull(value);
    }

    @NotNull
    public BigDecimal value() {
      return this.value;
    }

    @Override
    public boolean isZero() {
      return this == Real.ZERO || this.value.equals(BigDecimal.ZERO);
    }

    @Override
    public boolean is(final long value) {
      try {
        return this.value.longValueExact() == value;
      }
      catch (final ArithmeticException error) {
        return false;
      }
    }

    @NotNull
    public Real real() {
      return this;
    }

    @NotNull
    public Real imaginary() {
      return Integer.ZERO;
    }

    @Override
    public int signum() {
      return this.value.signum();
    }

    @Override
    public long longValue() {
      return this.value.longValue();
    }

    @Override
    public int intValue() {
      return this.value.intValue();
    }

    @Override
    public short shortValue() {
      return this.value.shortValue();
    }

    @Override
    public byte byteValue() {
      return this.value.byteValue();
    }

    @Override
    public double doubleValue() {
      return this.value.doubleValue();
    }

    @Override
    public float floatValue() {
      return this.value.floatValue();
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(this.value);
    }

    @Override
    public boolean equals(@Nullable final Object object) {
      if (this == object) return true;
      if (object == null) return false;
      if (!(object instanceof Real)) return false;
      final BigReal that = (BigReal)object;
      return Objects.equals(this.value, that.value);
    }

    @Override @NotNull
    public java.lang.String toString() {
      return this.value.toString();
    }
  }
}
