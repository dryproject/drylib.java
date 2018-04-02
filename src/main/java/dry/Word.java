/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Machine word (native size).
 */
public interface Word extends Number {
  @NotNull
  public static Word valueOf(final long value) {
    return Word64.valueOf(value);
  }

  public static final int SIZE = Word64.SIZE;

  public static final long MIN_VALUE = Word64.MIN_VALUE;

  public static final long MAX_VALUE = Word64.MAX_VALUE;

  public static final Word MIN = Word64.MIN;

  public static final Word MAX = Word64.MAX;

  public long getValue();
}
