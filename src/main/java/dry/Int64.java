/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (64-bit).
 */
final class Int64 extends Int {
  private static final long serialVersionUID = 1L;

  public Int64(final long value) {
    super(value);
  }

  public Int64(@NotNull final BigInteger value) {
    super(value);
  }
}
