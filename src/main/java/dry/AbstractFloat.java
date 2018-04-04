/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Base class for floating-point numbers.
 */
public abstract strictfp class AbstractFloat extends InexactNumber implements Float {
  private static final long serialVersionUID = 1L;

  public final double value;

  protected AbstractFloat(final double value) {
    this.value = value;
  }

  protected AbstractFloat(final double value,
                          final double min_value,
                          final double max_value) {
    if (value < min_value) throw new ArithmeticException();
    if (value > max_value) throw new ArithmeticException();
    this.value = value;
  }

  @Override
  public double getValue() {
    return this.value;
  }

  @Override
  public boolean isZero() {
    return this.value == 0.0d;
  }

  @Override
  public boolean is(final double value) {
    return this.value == value;
  }

  @Override
  public boolean is(final float value) {
    return this.value == (double)value;
  }

  @Override
  public boolean is(final long value) {
    return this.value == (double)value;
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
    if (this.value < 0.0d) return -1;
    if (this.value > 0.0d) return +1;
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
    if (!(object instanceof AbstractFloat)) return false;
    final AbstractFloat that = (AbstractFloat)object;
    return java.lang.Double.compare(this.value, that.value) == 0;
  }

  @Override
  public int compareTo(@NotNull final Float that) {
    return java.lang.Double.compare(this.value, Objects.requireNonNull(that).getValue());
  }

  @Override @NotNull
  public String toString() {
    return java.lang.Double.toString(this.value);
  }
}
