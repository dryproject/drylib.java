/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Integer number (arbitrary size).
 */
public strictfp class Integer extends Number {
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
