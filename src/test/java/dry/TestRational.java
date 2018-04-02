/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestRational {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Rational.valueOf(null, null); });
    assertThatNullPointerException().isThrownBy(() -> { Rational.valueOf(Integer.ONE, null); });
    assertThatNullPointerException().isThrownBy(() -> { Rational.valueOf(null, Integer.ONE); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Rational.valueOf(1, 2).toString()).isEqualTo("1/2");
  }
}
