/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Floating-point number (32-bit single-precision)
 */
public final strictfp class Float32 extends Float {
  private static final long serialVersionUID = 1L;

  public static final double MIN_VALUE = java.lang.Float.MIN_VALUE;

  public static final double MAX_VALUE = java.lang.Float.MAX_VALUE;

  public static final Float32 MIN = new Float32(MIN_VALUE);

  public static final Float32 MAX = new Float32(MAX_VALUE);

  public Float32(final double value) {
    super(value, MIN_VALUE, MAX_VALUE);
  }

  public Float32(final float value) {
    super(value);
  }

  public Float32(@NotNull final java.lang.Double value) {
    super(value.doubleValue(), MIN_VALUE, MAX_VALUE); // // throws NullPointerException if needed
  }

  public Float32(@NotNull final java.lang.Float value) {
    super(value);
  }
}
