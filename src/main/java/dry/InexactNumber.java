/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * @private
 */
public abstract strictfp class InexactNumber extends AbstractNumber {
  private static final long serialVersionUID = 1L;

  @Override
  public boolean isExact() {
    return false;
  }
}
