/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Real number (arbitrary size).
 */
public strictfp interface Real extends Complex {
  @NotNull
  public static Real valueOf(final double value) {
    return new BigReal(BigDecimal.valueOf(value));
  }

  @NotNull
  public static Real valueOf(final long value) {
    return new BigReal(BigDecimal.valueOf(value));
  }

  @NotNull
  public static Real valueOf(@NotNull final BigDecimal value) {
    return new BigReal(value);
  }

  @NotNull
  public static Real valueOf(@NotNull final BigInteger value) {
    return new BigReal(new BigDecimal(value));
  }

  public boolean is(long value);

  public int signum();

  final strictfp class BigReal extends ExactNumber implements Real {
    private static final long serialVersionUID = 1L;

    public final BigDecimal value;

    public BigReal(@NotNull final BigDecimal value) {
      this.value = Objects.requireNonNull(value);
    }

    @NotNull
    public BigDecimal getValue() {
      return this.value;
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
    public Real getReal() {
      return this;
    }

    @NotNull
    public Real getImaginary() {
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
    public String toString() {
      return this.value.toString();
    }
  }
}
