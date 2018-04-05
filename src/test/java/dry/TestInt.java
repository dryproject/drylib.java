/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Int.of(null); });
  }

  @Test
  void testMethod_size() {
    assertThat(Int.MAX.size()).isEqualTo(8);
  }

  @Test
  void testMethod_toString() {
    assertThat(Int.of(-1).toString()).isEqualTo("-1");
    assertThat(Int.of(0).toString()).isEqualTo("0");
  }
}
