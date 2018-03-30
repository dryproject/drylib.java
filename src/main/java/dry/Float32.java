/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Floating-point number (32-bit single-precision)
 */
final class Float32 extends Float {
  private static final long serialVersionUID = 1L;

  public static final double MIN_VALUE = Float.MIN_VALUE;

  public static final double MAX_VALUE = Float.MAX_VALUE;

  public static final Float32 MIN = new Float32(MIN_VALUE);

  public static final Float32 MAX = new Float32(MAX_VALUE);

  public Float32(final float value) {
    super((double)value);
  }

  public Float32(final double value) {
    super(value);
  }
}
