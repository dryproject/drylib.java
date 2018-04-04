/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Tensor.
 */
public interface Tensor<E> {
  /**
   * @see http://mathworld.wolfram.com/TensorRank.html
   */
  @NotNull
  public Natural getRank();
}
