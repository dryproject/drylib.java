/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

/**
 * Floating-point number (native size).
 *
 * @see <a href="https://drylib.org/base/float">[1]</a>
 */
public strictfp interface Float extends Real, Comparable<Float> {
  @NotNull
  public static Float of(final double value) {
    return Float64.of(value);
  }

  @NotNull
  public static Float of(final float value) {
    return Float64.of(value);
  }

  @NotNull
  public static Float of(@NotNull final java.lang.Double value) {
    return Float64.of(value);
  }

  @NotNull
  public static Float of(@NotNull final java.lang.Float value) {
    return Float64.of(value);
  }

  public static final int SIZE = Float64.SIZE;

  public static final double MIN_VALUE = Float64.MIN_VALUE;

  public static final double MAX_VALUE = Float64.MAX_VALUE;

  public static final Float MIN = Float64.MIN;

  public static final Float MAX = Float64.MAX;

  public int size();

  public double value();

  public boolean isNaN();

  public boolean isFinite();

  public boolean isInfinite();

  public boolean is(double value);

  public boolean is(float value);
}
