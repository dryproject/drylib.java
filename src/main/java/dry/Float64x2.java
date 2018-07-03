/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

/**
 * 128-bit vector with two ``float64`` lanes.
 *
 * @see <a href="https://drylib.org/base/simd/float64x2">[1]</a>
 */
public final strictfp class Float64x2 extends AbstractFloatVector<Float64> implements Vector<Float64> {
  private static final long serialVersionUID = 1L;

  public static final int SIZE = Float64.SIZE * 2;
  public static final Float64x2 ZERO = Float64x2.of(0d);

  @NotNull
  public static Float64x2 of(final double r) {
    return new Float64x2(new double[]{ r, r });
  }

  @NotNull
  public static Float64x2 of(final double _0, final double _1) {
    return new Float64x2(new double[]{ _0, _1 });
  }

  public final double data[];

  protected Float64x2(final double data[]) {
    this.data = data;
  }

  @Override
  public boolean isZero() {
    return this.data[0] == 0f && this.data[1] == 0f;
  }

  @Override @NotNull
  public Float64 get(@NotNull final Natural index) {
    return Float64.of(this.data[Objects.requireNonNull(index).intValue()]);
  }
}
