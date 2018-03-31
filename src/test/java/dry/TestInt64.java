/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt64 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { new Int64(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(new Int64(-1).toString()).isEqualTo("-1");
    assertThat(new Int64(0).toString()).isEqualTo("0");
  }
}
