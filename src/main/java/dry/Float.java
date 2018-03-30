/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Floating-point number (native size).
 */
class Float extends Number {
  private static final long serialVersionUID = 1L;

  public static final double MIN_VALUE = Float64.MIN_VALUE;

  public static final double MAX_VALUE = Float64.MAX_VALUE;

  public static final Float MIN = Float64.MIN;

  public static final Float MAX = Float64.MAX;

  public final double value;

  public Float(final double value) {
    this.value = value;
  }

  public double getValue() {
    return this.value;
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
}
