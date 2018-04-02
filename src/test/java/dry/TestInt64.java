/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt64 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Int64.valueOf(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Int64.valueOf(-1).toString()).isEqualTo("-1");
    assertThat(Int64.valueOf(0).toString()).isEqualTo("0");
  }
}
