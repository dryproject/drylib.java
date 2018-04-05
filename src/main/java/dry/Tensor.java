/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Tensor.
 */
public interface Tensor<E> {
  /**
   * Returns the tensor rank.
   *
   * @see https://en.wikipedia.org/wiki/Tensor_(intrinsic_definition)#Tensor_rank
   * @see http://mathworld.wolfram.com/TensorRank.html
   */
  @NotNull
  public Natural getRank();

  /**
   * Returns the tensor shape.
   */
  @NotNull
  public Natural[] getShape();

  /**
   * Checks if this is a zero tensor.
   *
   * https://en.wikipedia.org/wiki/Zero_element#Zero_tensor
   * @see http://mathworld.wolfram.com/ZeroTensor.html
   */
  public boolean isZero();
}
