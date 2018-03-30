/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;

/**
 * Complex number (arbitrary size).
 */
final class Complex extends Number {
  public final Real real;
  public final Real imaginary;

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
}
