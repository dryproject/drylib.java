/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Base class for numbers.
 */
public abstract strictfp class AbstractNumber extends java.lang.Number implements Number, java.io.Serializable {
  private static final long serialVersionUID = 1L;

  protected int signum() {
    return java.lang.Double.compare(this.doubleValue(), 0);
  }

  @Override
  public boolean isInexact() {
    return !this.isExact();
  }

  @Override
  public long longValue() {
    assert false : "not implemented";
    return 0;
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
    assert false : "not implemented";
    return 0;
  }

  @Override
  public float floatValue() {
    return (float)this.doubleValue();
  }
}
