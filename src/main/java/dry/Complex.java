/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Complex number (arbitrary size).
 */
public strictfp interface Complex extends Number {
  @NotNull
  public static Complex valueOf(final long real,
                                final long imaginary) {
    return new RealComplex(Real.valueOf(real), Real.valueOf(imaginary));
  }

  @NotNull
  public static Complex valueOf(final double real,
                                final double imaginary) {
    return new RealComplex(Real.valueOf(real), Real.valueOf(imaginary));
  }

  @NotNull
  public static Complex valueOf(@NotNull final Real real,
                                @NotNull final Real imaginary) {
    return new RealComplex(real, imaginary);
  }

  @NotNull
  public Real getReal();

  @NotNull
  public Real getImaginary();

  final strictfp class RealComplex extends ExactNumber implements Complex {
    private static final long serialVersionUID = 1L;

    public final Real real;
    public final Real imaginary;

    protected RealComplex(@NotNull final Real real,
                          @NotNull final Real imaginary) {
      this.real = Objects.requireNonNull(real);
      this.imaginary = Objects.requireNonNull(imaginary);
    }

    @Override @NotNull
    public Real getReal() {
      return this.real;
    }

    @Override @NotNull
    public Real getImaginary() {
      return this.imaginary;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.real, this.imaginary);
    }

    @Override
    public boolean equals(@Nullable final Object object) {
      if (this == object) return true;
      if (object == null) return false;
      if (!(object instanceof RealComplex)) return false;
      final RealComplex that = (RealComplex)object;
      return Objects.equals(this.real, that.real) &&
        Objects.equals(this.imaginary, that.imaginary);
    }

    @Override @NotNull
    public String toString() {
      final StringBuilder buffer = new StringBuilder();

      buffer.append(this.real.toString());
      if (this.imaginary.signum() >= 0) {
        buffer.append('+');
      }
      buffer.append(this.imaginary.toString());
      buffer.append('i');

      return buffer.toString();
    }
  }
}
