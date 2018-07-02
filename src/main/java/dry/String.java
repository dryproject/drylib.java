/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * A string.
 *
 * @see <a href="https://drylib.org/base/string">[1]</a>
 */
public interface String extends Datum {
  /**
   * Checks if this string is empty.
   *
   * @return <tt>true</tt> if this is an empty string, <tt>false</tt> otherwise
   */
  public boolean isEmpty();

  /**
   * Checks if this string is blank.
   *
   * @return <tt>true</tt> if this is a blank string, <tt>false</tt> otherwise
   */
  public boolean isBlank();
}
