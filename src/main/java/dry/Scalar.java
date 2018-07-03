/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Scalar.
 *
 * @see <a href="https://drylib.org/base/scalar">[1]</a>
 */
public interface Scalar<E> extends Tensor<E> {
  @Override @NotNull
  default public Natural rank() {
    return Natural.ZERO;
  }

  @Override @NotNull
  default public Natural[] shape() {
    return new Natural[] {};
  }
}
