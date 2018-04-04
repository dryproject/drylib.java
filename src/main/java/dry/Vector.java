/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Iterator;

import org.jetbrains.annotations.NotNull;

/**
 * Vector.
 */
public interface Vector<E> extends Tensor<E>, Iterable<E> {
  @Override @NotNull
  default public Natural getRank() {
    return Natural.ONE;
  }

  @Override @NotNull
  default public Natural[] getShape() {
    return new Natural[] {Natural.ZERO};
  }

  @Override @NotNull
  default public Iterator<E> iterator() {
    assert false : "not implemented";
    return null;
  }

  @NotNull
  default public E get(@NotNull final Natural a) {
    assert false : "not implemented";
    return null;
  }
}
