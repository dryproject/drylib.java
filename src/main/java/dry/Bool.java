/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Boolean (true or false).
 *
 * @see <a href="https://drylib.org/core/bool">[1]</a>
 */
public class Bool extends java.lang.Object implements Scalar<Bool>, Comparable<Bool> {
  @NotNull
  public static Bool of(final boolean value) {
    return value ? TRUE : FALSE;
  }

  @NotNull
  public static Bool of(@NotNull final java.lang.Boolean value) {
    return of(Objects.requireNonNull(value).booleanValue());
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 1; // bytes

  public static final Bool FALSE = new Bool(false);

  public static final Bool TRUE = new Bool(true);

  public final boolean value;

  protected Bool(final boolean value) {
    this.value = value;
  }

  public int size() {
    return SIZE;
  }

  public boolean getValue() {
    return this.value;
  }

  @Override
  public boolean isZero() {
    return this.value == false;
  }

  public boolean is(final boolean value) {
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
    if (!(object instanceof Bool)) return false;
    final Bool that = (Bool)object;
    return this.value == that.value;
  }

  @Override
  public int compareTo(@NotNull final Bool that) {
    return java.lang.Boolean.compare(this.value, Objects.requireNonNull(that).value);
  }

  @Override @NotNull
  public String toString() {
    return java.lang.Boolean.toString(this.value);
  }
}
