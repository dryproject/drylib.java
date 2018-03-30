/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Machine word (native size).
 */
class Word extends Number {
  private static final long serialVersionUID = 1L;

  public final long value;

  public Word(final long value) {
    this.value = value;
  }

  public long getValue() {
    return this.value;
  }

  @Override
  public long longValue() {
    return this.value;
  }

  @Override
  public double doubleValue() {
    return (double)this.value;
  }
}
