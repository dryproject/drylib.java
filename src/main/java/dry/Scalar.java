/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Scalar.
 */
public interface Scalar<E> extends Tensor<E> {
  @Override @NotNull
  default public Natural getRank() {
    return Natural.ZERO;
  }
}
