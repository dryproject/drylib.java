/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Number.
 */
public strictfp interface Number extends Scalar<Number> {

  public boolean isExact();

  public boolean isInexact();

  @Override
  public boolean isZero();
}
