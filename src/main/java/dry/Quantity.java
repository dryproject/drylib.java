/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * A quantity.
 *
 * @see <a href="https://drylib.org/base/quantity">[1]</a>
 */
public interface Quantity<Q extends Quantity<Q>> extends Datum {

  /**
   * The numerical value of this quantity.
   *
   * @return the numerical value
   */
  public @NotNull Number getValue();

  /**
   * The unit of measurement.
   *
   * @return the unit
   */
  public @NotNull Unit<Q> getUnit();
}
