/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Character (Unicode code point).
 */
class Char extends java.lang.Object {
  private static final long serialVersionUID = 1L;

  public static final int MIN_VALUE = Character.MIN_CODE_POINT;

  public static final int MAX_VALUE = Character.MAX_CODE_POINT;

  public static final Char MIN = new Char(MIN_VALUE);

  public static final Char MAX = new Char(MAX_VALUE);

  public final int value;

  public Char(final int value) {
    if (value < MIN_VALUE) throw new ArithmeticException();
    if (value > MAX_VALUE) throw new ArithmeticException();
    this.value = value;
  }

  public Char(final char value) {
    this.value = value;
  }

  public Char(@NotNull final java.lang.Character value) {
    if (value == null) throw new NullPointerException();
    this.value = value.charValue();
  }

  public int getValue() {
    return this.value;
  }
}
