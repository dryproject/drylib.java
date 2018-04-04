/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Tensor.
 */
public interface Tensor<E> {
  /**
   * @see http://mathworld.wolfram.com/TensorRank.html
   */
  public Natural getRank();
}
