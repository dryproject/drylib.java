/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt32 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { new Int32(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(new Int32(-1).toString()).isEqualTo("-1");
    assertThat(new Int32(0).toString()).isEqualTo("0");
  }
}
