/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * A quantity.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Quantity">[1]</a>
 */
public interface Quantity extends Datum {

  /**
   * The unit of measurement.
   *
   * @return the unit
   */
  public @NotNull Unit getUnit();

  /**
   * The numerical value of this quantity.
   *
   * @return the numerical value
   */
  public @NotNull Number getValue();
}
