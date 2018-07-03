/* This is free and unencumbered software released into the public domain. */

package dry.meta;

import dry.Quantity;

import org.jetbrains.annotations.NotNull;

/**
 * Something quantifiable.
 *
 * @see <a href="https://drylib.org/meta/quantifiable">[1]</a>
 */
public interface Quantifiable<Q extends Quantity<Q>> {

  public @NotNull Q quantity();
}
