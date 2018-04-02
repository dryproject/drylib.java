/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt128 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Int128.valueOf(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Int128.valueOf(-1).toString()).isEqualTo("-1");
    assertThat(Int128.valueOf(0).toString()).isEqualTo("0");
  }
}
