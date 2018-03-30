/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;

import org.jetbrains.annotations.NotNull;

/**
 * Natural number (arbitrary size).
 */
class Natural extends Integer {

  public Natural(final long value) {
    super(value);
  }

  public Natural(@NotNull final BigInteger value) {
    super(value);
  }
}
