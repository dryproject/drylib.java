/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (native size).
 */
class Int extends Integer {
  private static final long serialVersionUID = 1L;

  public Int(final long value) {
    super(value);
  }

  public Int(@NotNull final BigInteger value) {
    super(value);
  }
}
