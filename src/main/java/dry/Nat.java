/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * @see <a href="https://drylib.org/base/nat">[1]</a>
 */
public strictfp class Nat extends Natural {
  private static final long serialVersionUID = 1L;

  @NotNull
  public static Nat of(final long value) {
    return new Nat(value);
  }

  protected Nat(final long value) {
    super(value);
  }
}
