/* This is free and unencumbered software released into the public domain. */

package dry;

/**
 * Floating-point number (64-bit double-precision).
 */
final class Float64 extends Float {
  private static final long serialVersionUID = 1L;

  public static final double MIN_VALUE = Double.MIN_VALUE;

  public static final double MAX_VALUE = Double.MAX_VALUE;

  public static final Float64 MIN = new Float64(MIN_VALUE);

  public static final Float64 MAX = new Float64(MAX_VALUE);

  public Float64(final double value) {
    super(value);
  }
}
