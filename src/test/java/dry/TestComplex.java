/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestComplex {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Complex.of(null, null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Complex.of(1.0, 3.0).toString()).isEqualTo("1.0+3.0i");
    assertThat(Complex.of(1.0, -3.0).toString()).isEqualTo("1.0-3.0i");
    assertThat(Complex.of(-1.0, 0.0).toString()).isEqualTo("-1.0+0.0i");
  }
}
