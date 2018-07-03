/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

/**
 * 64-bit vector with two ``float32`` lanes.
 *
 * @see <a href="https://drylib.org/base/simd/float32x2">[1]</a>
 */
public final strictfp class Float32x2 extends AbstractFloatVector<Float32> implements Vector<Float32> {
  private static final long serialVersionUID = 1L;

  public static final int SIZE = Float32.SIZE * 2;
  public static final Float32x2 ZERO = Float32x2.of(0f);

  @NotNull
  public static Float32x2 of(final float r) {
    return new Float32x2(new float[]{ r, r });
  }

  @NotNull
  public static Float32x2 of(final float _0, final float _1) {
    return new Float32x2(new float[]{ _0, _1 });
  }

  public final float data[];

  protected Float32x2(final float data[]) {
    this.data = data;
  }

  @Override @NotNull
  public java.lang.String toString() {
    return java.lang.String.format("[%.1f, %.1f]", this.data[0], this.data[1]);
  }

  @Override
  public boolean isZero() {
    return this.data[0] == 0f && this.data[1] == 0f;
  }

  @Override @NotNull
  public Float32 get(@NotNull final Natural index) {
    return Float32.of(this.data[Objects.requireNonNull(index).intValue()]);
  }
}
