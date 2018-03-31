/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt128 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { new Int128(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(new Int128(-1).toString()).isEqualTo("-1");
    assertThat(new Int128(0).toString()).isEqualTo("0");
  }
}
