/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Iterator;

import org.jetbrains.annotations.NotNull;

/**
 * Matrix.
 *
 * @see <a href="https://drylib.org/base/matrix">[1]</a>
 */
public interface Matrix<E> extends Tensor<E> {
  @Override @NotNull
  default public Natural rank() {
    return Natural.TWO;
  }

  @Override @NotNull
  default public Natural[] shape() {
    return new Natural[] {Natural.ZERO, Natural.ZERO};
  }

  @NotNull
  default public E get(@NotNull final Natural a,
                       @NotNull final Natural b) {
    assert false : "not implemented";
    return null;
  }
}
