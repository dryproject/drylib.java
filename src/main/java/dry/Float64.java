/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

/**
 * Floating-point number (64-bit double-precision).
 */
public final strictfp class Float64 extends Float {
  @NotNull
  public static Float64 valueOf(final double value) {
    return new Float64(value);
  }

  @NotNull
  public static Float64 valueOf(final float value) {
    return new Float64((double)value);
  }

  @NotNull
  public static Float64 valueOf(@NotNull final java.lang.Double value) {
    return new Float64(Objects.requireNonNull(value).doubleValue());
  }

  @NotNull
  public static Float64 valueOf(@NotNull final java.lang.Float value) {
    return new Float64(Objects.requireNonNull(value).doubleValue());
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 8; // bytes

  public static final double MIN_VALUE = java.lang.Double.MIN_VALUE;

  public static final double MAX_VALUE = java.lang.Double.MAX_VALUE;

  public static final Float64 MIN = new Float64(MIN_VALUE);

  public static final Float64 MAX = new Float64(MAX_VALUE);

  protected Float64(final double value) {
    super(value);
  }
}
