/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Matrix.
 */
public interface Matrix<E> extends Tensor<E> {
  @Override
  default public Natural getRank() {
    return Natural.TWO;
  }
}
