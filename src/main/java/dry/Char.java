/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Character (Unicode code point).
 */
public class Char extends java.lang.Object {
  private static final long serialVersionUID = 1L;

  public static final int SIZE = 4; // bytes

  public static final int MIN_VALUE = java.lang.Character.MIN_CODE_POINT;

  public static final int MAX_VALUE = java.lang.Character.MAX_CODE_POINT;

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

  @Override
  public int hashCode() {
    return Objects.hashCode(this.value);
  }

  @Override
  public boolean equals(@Nullable final Object object) {
    if (this == object) return true;
    if (object == null) return false;
    if (!(object instanceof Char)) return false;
    final Char that = (Char)object;
    return this.value == that.value;
  }

  @Override @NotNull
  public String toString() {
    return (this.value <= java.lang.Character.MAX_VALUE) ?
      java.lang.Character.toString((char)this.value) :
      String.valueOf(java.lang.Character.toChars(this.value));
  }
}
