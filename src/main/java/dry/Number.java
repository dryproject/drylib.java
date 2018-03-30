/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Base class for number types.
 */
abstract class Number extends java.lang.Number implements java.io.Serializable {
  private static final long serialVersionUID = 1L;

  @Override
  public long longValue() {
    return 0; // TODO
  }

  @Override
  public int intValue() {
    return (int)this.longValue();
  }

  @Override
  public short shortValue() {
    return (short)this.longValue();
  }

  @Override
  public byte byteValue() {
    return (byte)this.longValue();
  }

  @Override
  public double doubleValue() {
    return 0; // TODO
  }

  @Override
  public float floatValue() {
    return (float)this.doubleValue();
  }
}
