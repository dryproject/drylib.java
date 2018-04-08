/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Machine word (native size).
 *
 * @see <a href="https://drylib.org/core/word">[1]</a>
 */
public interface Word extends Number, Comparable<Word> {
  @NotNull
  public static Word of(final long value) {
    return Word64.of(value);
  }

  public static final int SIZE = Word64.SIZE;

  public static final long MIN_VALUE = Word64.MIN_VALUE;

  public static final long MAX_VALUE = Word64.MAX_VALUE;

  public static final Word MIN = Word64.MIN;

  public static final Word MAX = Word64.MAX;

  public static final Word ZERO = Word64.ZERO;

  public long getValue();

  public boolean is(long value);
}
