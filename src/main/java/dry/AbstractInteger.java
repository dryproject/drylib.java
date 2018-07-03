/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Base class for integers.
 *
 * @see <a href="https://drylib.org/java">[1]</a>
 */
abstract strictfp class AbstractInteger extends ExactNumber implements Integer {
  private static final long serialVersionUID = 1L;

  @Override @NotNull
  public Integer numerator() {
    return this;
  }

  @Override @NotNull
  public Integer denominator() {
    return Integer.ONE;
  }

  @Override @NotNull
  public Real real() {
    return this;
  }

  @Override @NotNull
  public Real imaginary() {
    return Integer.ZERO;
  }

  @Override
  public int signum() {
    return this.value().signum();
  }
}
