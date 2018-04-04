/* This is free and unencumbered software released into the public domain. */

package dry;

public abstract strictfp class ExactNumber extends AbstractNumber {
  private static final long serialVersionUID = 1L;

  @Override
  public boolean isExact() {
    return true;
  }
}
