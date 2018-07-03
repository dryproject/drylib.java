/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

/**
 * Floating-point number (16-bit half-precision).
 *
 * @see <a href="https://drylib.org/base/float16">[1]</a>
 */
public final strictfp class Float16 extends AbstractFloat implements Float {
  @NotNull
  public static Float16 of(final double value) {
    return new Float16(value);
  }

  @NotNull
  public static Float16 of(final float value) {
    return new Float16((double)value);
  }

  @NotNull
  public static Float16 of(@NotNull final java.lang.Double value) {
    return new Float16(Objects.requireNonNull(value).doubleValue());
  }

  @NotNull
  public static Float16 of(@NotNull final java.lang.Float value) {
    return new Float16(Objects.requireNonNull(value).doubleValue());
  }

  private static final long serialVersionUID = 1L;

  public static final int SIZE = 2; // bytes

  public static final double MIN_VALUE = java.lang.Float.MIN_VALUE; // FIXME

  public static final double MAX_VALUE = java.lang.Float.MAX_VALUE; // FIXME

  public static final Float16 MIN = new Float16(MIN_VALUE);

  public static final Float16 MAX = new Float16(MAX_VALUE);

  protected Float16(final double value) {
    super(value, MIN_VALUE, MAX_VALUE);
  }

  @Override
  public int size() {
    return SIZE;
  }
}
