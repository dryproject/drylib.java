/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

/**
 * 32-bit vector with two ``float16`` lanes.
 *
 * @see <a href="https://drylib.org/base/simd/float16x2">[1]</a>
 */
public final strictfp class Float16x2 extends AbstractFloatVector<Float16> implements Vector<Float16> {
  private static final long serialVersionUID = 1L;

  public static final int SIZE = Float16.SIZE * 2;
  public static final Float16x2 ZERO = Float16x2.of(0f);

  @NotNull
  public static Float16x2 of(final float r) {
    return new Float16x2(new float[]{ r, r });
  }

  @NotNull
  public static Float16x2 of(final float _0, final float _1) {
    return new Float16x2(new float[]{ _0, _1 });
  }

  public final float data[];

  protected Float16x2(final float data[]) {
    this.data = data;
  }

  @Override
  public boolean isZero() {
    return this.data[0] == 0f && this.data[1] == 0f;
  }

  @Override @NotNull
  public Float16 get(@NotNull final Natural index) {
    return Float16.of(this.data[Objects.requireNonNull(index).intValue()]);
  }
}
