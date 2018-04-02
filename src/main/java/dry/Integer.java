/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Integer number (arbitrary size).
 */
public strictfp class Integer extends AbstractNumber implements Rational {
  @NotNull
  public static Integer valueOf(final long value) {
    return new Integer(BigInteger.valueOf(value));
  }

  @NotNull
  public static Integer valueOf(@NotNull final BigInteger value) {
    return new Integer(value);
  }

  private static final long serialVersionUID = 1L;

  public static final Integer ZERO = Natural.ZERO;

  public static final Integer ONE = Natural.ONE;

  public static final Integer TWO = Natural.TWO;

  public static final Integer TEN = Natural.TEN;

  public final BigInteger value;

  protected Integer(final long value,
                    final long min_value) {
    if (value < min_value) throw new ArithmeticException();
    this.value = BigInteger.valueOf(value);
  }

  protected Integer(final long value,
                    final long min_value,
                    final long max_value) {
    if (value < min_value) throw new ArithmeticException();
    if (value > max_value) throw new ArithmeticException();
    this.value = BigInteger.valueOf(value);
  }

  protected Integer(@NotNull final BigInteger value,
                    @Nullable final BigInteger min_value,
                    @Nullable final BigInteger max_value) {
    if (value == null) throw new NullPointerException();
    if (min_value != null && value.compareTo(min_value) < 0) throw new ArithmeticException();
    if (max_value != null && value.compareTo(max_value) > 0) throw new ArithmeticException();
    this.value = value;
  }

  protected Integer(final long value) {
    this.value = BigInteger.valueOf(value);
  }

  protected Integer(@NotNull final BigInteger value) {
    this.value = Objects.requireNonNull(value);
  }

  @NotNull
  public BigInteger getValue() {
    return this.value;
  }

  @Override @NotNull
  public Integer getNumerator() {
    return this;
  }

  @Override @NotNull
  public Integer getDenominator() {
    return Integer.ONE;
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
    return this.value.hashCode();
  }

  @Override
  public boolean equals(@Nullable final Object object) {
    if (this == object) return true;
    if (object == null) return false;
    if (!(object instanceof Integer)) return false;
    final Integer that = (Integer)object;
    return Objects.equals(this.value, that.value);
  }

  @Override @NotNull
  public String toString() {
    return this.value.toString();
  }
}
