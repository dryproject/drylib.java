/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Floating-point number (native size).
 */
public strictfp class Float extends InexactNumber implements Real {
  @NotNull
  public static Float valueOf(final double value) {
    return Float64.valueOf(value);
  }

  @NotNull
  public static Float valueOf(final float value) {
    return Float64.valueOf(value);
  }

  @NotNull
  public static Float valueOf(@NotNull final java.lang.Double value) {
    return Float64.valueOf(value);
  }

  @NotNull
  public static Float valueOf(@NotNull final java.lang.Float value) {
    return Float64.valueOf(value);
  }

  public static final int SIZE = Float64.SIZE;

  public static final double MIN_VALUE = Float64.MIN_VALUE;

  public static final double MAX_VALUE = Float64.MAX_VALUE;

  public static final Float MIN = Float64.MIN;

  public static final Float MAX = Float64.MAX;

  private static final long serialVersionUID = 1L;

  public final double value;

  protected Float(final double value) {
    this.value = value;
  }

  protected Float(final double value,
                  final double min_value,
                  final double max_value) {
    if (value < min_value) throw new ArithmeticException();
    if (value > max_value) throw new ArithmeticException();
    this.value = value;
  }

  public double getValue() {
    return this.value;
  }

  @Override @NotNull
  public Real getReal() {
    return this;
  }

  @Override @NotNull
  public Real getImaginary() {
    return Integer.ZERO;
  }

  @Override
  public int signum() {
    if (this.value < 0) return -1;
    if (this.value > 0) return +1;
    return 0;
  }

  @Override
  public long longValue() {
    return (long)this.value;
  }

  @Override
  public int intValue() {
    return (int)this.value;
  }

  @Override
  public short shortValue() {
    return (short)this.value;
  }

  @Override
  public byte byteValue() {
    return (byte)this.value;
  }

  @Override
  public double doubleValue() {
    return this.value;
  }

  @Override
  public float floatValue() {
    return (float)this.value;
  }

  @Override
  public int hashCode() {
    return java.lang.Double.hashCode(this.value);
  }

  @Override
  public boolean equals(@Nullable final Object object) {
    if (this == object) return true;
    if (object == null) return false;
    if (!(object instanceof Float)) return false;
    final Float that = (Float)object;
    return java.lang.Double.compare(this.value, that.value) == 0;
  }

  @Override @NotNull
  public String toString() {
    return java.lang.Double.toString(this.value);
  }
}
