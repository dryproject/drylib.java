/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt8 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Int8.valueOf(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Int8.valueOf(-1).toString()).isEqualTo("-1");
    assertThat(Int8.valueOf(0).toString()).isEqualTo("0");
  }
}
