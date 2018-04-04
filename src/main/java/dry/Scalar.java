/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Scalar.
 */
public interface Scalar<E> extends Tensor<E> {
  @Override
  default public Natural getRank() {
    return Natural.ZERO;
  }
}
