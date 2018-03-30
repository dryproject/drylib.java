/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Integer number (16-bit).
 */
final class Int16 extends Int {

  public Int16(final long value) {
    super(value);
  }

  public Int16(@NotNull final BigInteger value) {
    super(value);
  }
}
