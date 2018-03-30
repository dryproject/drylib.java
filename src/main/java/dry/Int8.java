/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (8-bit).
 */
final class Int8 extends Int {

  public Int8(final long value) {
    super(value);
  }

  public Int8(@NotNull final BigInteger value) {
    super(value);
  }
}
