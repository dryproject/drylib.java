/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

/**
 * Floating-point number (32-bit single-precision)
 *
 * @see <a href="https://drylib.org/core/float32">[1]</a>
 */
public final strictfp class Float32 extends AbstractFloat implements Float {
  @NotNull
  public static Float32 of(final double value) {
    return new Float32(value);
  }

  @NotNull
  public static Float32 of(final float value) {
    return new Float32((double)value);
  }

  @NotNull
  public static Float32 of(@NotNull final java.lang.Double value) {
    return new Float32(Objects.requireNonNull(value).doubleValue());
  }

  @NotNull
  public static Float32 of(@NotNull final java.lang.Float value) {
    return new Float32(Objects.requireNonNull(value).doubleValue());
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 4; // bytes

  public static final double MIN_VALUE = java.lang.Float.MIN_VALUE;

  public static final double MAX_VALUE = java.lang.Float.MAX_VALUE;

  public static final Float32 MIN = new Float32(MIN_VALUE);

  public static final Float32 MAX = new Float32(MAX_VALUE);

  protected Float32(final double value) {
    super(value, MIN_VALUE, MAX_VALUE);
  }

  @Override
  public int size() {
    return SIZE;
  }
}
