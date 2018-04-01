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
public final strictfp class Real extends Number {
  private static final long serialVersionUID = 1L;

  public final BigDecimal value;

  public Real(final double value) {
    this.value = BigDecimal.valueOf(value);
  }

  public Real(final long value) {
    this.value = BigDecimal.valueOf(value);
  }

  public Real(@NotNull final BigDecimal value) {
    if (value == null) throw new NullPointerException();
    this.value = value;
  }

  public Real(@NotNull final BigInteger value) {
    this(new BigDecimal(value)); // throws NullPointerException if needed
  }

  @Override
  protected int signum() {
    return this.value.signum();
  }

  @NotNull
  public BigDecimal getValue() {
    return this.value;
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
    final Real that = (Real)object;
    return Objects.equals(this.value, that.value);
  }

  @Override @NotNull
  public String toString() {
    return this.value.toString();
  }
}
