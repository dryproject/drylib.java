/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Boolean (true or false).
 */
class Bool extends java.lang.Object {
  public final boolean value;

  public Bool(final boolean value) {
    this.value = value;
  }

  public Bool(@NotNull final java.lang.Boolean value) {
    if (value == null) throw new NullPointerException();
    this.value = value.booleanValue();
  }

  public boolean getValue() {
    return this.value;
  }
}
