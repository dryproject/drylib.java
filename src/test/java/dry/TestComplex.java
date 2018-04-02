/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestComplex {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Complex.valueOf(null, null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Complex.valueOf(1.0, 3.0).toString()).isEqualTo("1.0+3.0i");
    assertThat(Complex.valueOf(1.0, -3.0).toString()).isEqualTo("1.0-3.0i");
    assertThat(Complex.valueOf(-1.0, 0.0).toString()).isEqualTo("-1.0+0.0i");
  }
}
