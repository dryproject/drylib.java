/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (32-bit).
 */
final class Int32 extends Int {
  private static final long serialVersionUID = 1L;

  public Int32(final long value) {
    super(value);
  }

  public Int32(@NotNull final BigInteger value) {
    super(value);
  }
}
