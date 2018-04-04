/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Vector.
 */
public interface Vector<E> extends Tensor<E> {
  @Override
  default public Natural getRank() {
    return Natural.ONE;
  }
}
