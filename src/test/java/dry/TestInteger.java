/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInteger {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { new Integer(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(new Integer(-1).toString()).isEqualTo("-1");
    assertThat(new Integer(0).toString()).isEqualTo("0");
  }
}
