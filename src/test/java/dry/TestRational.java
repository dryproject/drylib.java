/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestRational {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { new Rational(null, null); });
    assertThatNullPointerException().isThrownBy(() -> { new Rational(new Integer(1), null); });
    assertThatNullPointerException().isThrownBy(() -> { new Rational(null, new Integer(1)); });
  }

  @Test
  void testMethod_toString() {
    assertThat(new Rational(1, 2).toString()).isEqualTo("1/2");
  }
}
