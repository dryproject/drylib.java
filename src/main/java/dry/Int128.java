/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (128-bit).
 */
final class Int128 extends Int {

  public Int128(final long value) {
    super(value);
  }

  public Int128(@NotNull final BigInteger value) {
    super(value);
  }
}
