/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Complex number (arbitrary size).
 */
public final strictfp class Complex extends Number {
  private static final long serialVersionUID = 1L;

  public final Real real;
  public final Real imaginary;

  public Complex(final long real,
                 final long imaginary) {
    this.real = new Real(real);
    this.imaginary = new Real(imaginary);
  }

  public Complex(final double real,
                 final double imaginary) {
    this.real = new Real(real);
    this.imaginary = new Real(imaginary);
  }

  public Complex(@NotNull final Real real,
                 @NotNull final Real imaginary) {
    if (real == null) throw new NullPointerException();
    if (imaginary == null) throw new NullPointerException();
    this.real = real;
    this.imaginary = imaginary;
  }

  @NotNull
  public Real getReal() {
    return this.real;
  }

  @NotNull
  public Real getImaginary() {
    return this.imaginary;
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
