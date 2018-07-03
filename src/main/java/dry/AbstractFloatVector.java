/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

/**
 * Base class for floating-point vectors.
 *
 * @see <a href="https://drylib.org/java">[1]</a>
 */
abstract strictfp class AbstractFloatVector<E> implements Vector<E> {
  private static final long serialVersionUID = 1L;
}
