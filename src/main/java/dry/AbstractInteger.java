/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Base class for integers.
 */
public abstract class AbstractInteger extends ExactNumber implements Integer {
  private static final long serialVersionUID = 1L;

  @Override @NotNull
  public Integer getNumerator() {
    return this;
  }

  @Override @NotNull
  public Integer getDenominator() {
    return Integer.ONE;
  }

  @Override @NotNull
  public Real getReal() {
    return this;
  }

  @Override @NotNull
  public Real getImaginary() {
    return Integer.ZERO;
  }

  @Override
  public int signum() {
    return this.getValue().signum();
  }
}
