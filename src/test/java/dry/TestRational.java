/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestRational {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Rational.of(null, null); });
    assertThatNullPointerException().isThrownBy(() -> { Rational.of(Integer.ONE, null); });
    assertThatNullPointerException().isThrownBy(() -> { Rational.of(null, Integer.ONE); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Rational.of(1, 2).toString()).isEqualTo("1/2");
  }
}
