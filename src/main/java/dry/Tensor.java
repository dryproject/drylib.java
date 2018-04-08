/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * A tensor.
 *
 * @see <a href="https://drylib.org/core/tensor">[1]</a>
 */
public interface Tensor<E> extends Datum {
  /**
   * Returns the tensor rank.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Tensor_(intrinsic_definition)#Tensor_rank">[1]</a>
   * @see <a href="http://mathworld.wolfram.com/TensorRank.html">[2]</a>
   *
   * @return a nonnegative number
   */
  @NotNull
  public Natural getRank();

  /**
   * Returns the tensor shape.
   *
   * @return an array of nonnegative numbers
   */
  @NotNull
  public Natural[] getShape();

  /**
   * Checks if this is a zero tensor.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Zero_element#Zero_tensor">[1]</a>
   * @see <a href="http://mathworld.wolfram.com/ZeroTensor.html">[2]</a>
   *
   * @return <tt>true</tt> if this is a zero tensor, <tt>false</tt> otherwise
   */
  public boolean isZero();
}
