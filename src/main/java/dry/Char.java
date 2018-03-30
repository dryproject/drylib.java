/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Character (Unicode code point).
 */
class Char extends java.lang.Object {
  public final int value;

  public Char(final int value) {
    // TODO: input validation
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
