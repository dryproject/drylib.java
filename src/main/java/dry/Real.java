/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

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

  @Override @NotNull
  public String toString() {
    return this.value.toString();
  }
}
