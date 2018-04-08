/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Base class for inexact numbers.
 *
 * @see <a href="https://drylib.org/java">[1]</a>
 */
public abstract strictfp class InexactNumber extends AbstractNumber {
  private static final long serialVersionUID = 1L;

  @Override
  public boolean isExact() {
    return false;
  }
}
