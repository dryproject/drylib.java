/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (arbitrary size).
 */
class Integer extends Number {
  public final BigInteger value;

  public Integer(final long value) {
    this.value = BigInteger.valueOf(value);
  }

  public Integer(@NotNull final BigInteger value) {
    if (value == null) throw new NullPointerException();
    this.value = value;
  }

  @NotNull
  public BigInteger getValue() {
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
}
