/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Character (Unicode code point).
 *
 * @see <a href="https://drylib.org/base/char">[1]</a>
 */
public class Char extends java.lang.Object implements Scalar<Char>, Comparable<Char> {
  @NotNull
  public static Char of(final int value) {
    return new Char(value);
  }

  @NotNull
  public static Char of(final char value) {
    return new Char(value);
  }

  @NotNull
  public static Char of(@NotNull final java.lang.Character value) {
    return new Char(value);
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 4; // bytes

  public static final int MIN_VALUE = java.lang.Character.MIN_CODE_POINT;

  public static final int MAX_VALUE = java.lang.Character.MAX_CODE_POINT;

  public static final Char MIN = new Char(MIN_VALUE);

  public static final Char MAX = new Char(MAX_VALUE);

  public final int value;

  protected Char(final int value) {
    if (value < MIN_VALUE) throw new ArithmeticException();
    if (value > MAX_VALUE) throw new ArithmeticException();
    this.value = value;
  }

  protected Char(final char value) {
    this.value = value;
  }

  protected Char(@NotNull final java.lang.Character value) {
    this.value = Objects.requireNonNull(value).charValue();
  }

  public int size() {
    return SIZE;
  }

  public int getValue() {
    return this.value;
  }

  @Override
  public boolean isZero() {
    return this.value == 0L;
  }

  public boolean is(final char value) {
    return this.value == (int)value;
  }

  public boolean is(final int value) {
    return this.value == value;
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

  @Override
  public int compareTo(@NotNull final Char that) {
    return java.lang.Character.compare((char)this.value, (char)Objects.requireNonNull(that).value); // FIXME: non-BMP chars
  }

  @Override @NotNull
  public String toString() {
    return (this.value <= java.lang.Character.MAX_VALUE) ?
      java.lang.Character.toString((char)this.value) :
      String.valueOf(java.lang.Character.toChars(this.value));
  }
}
