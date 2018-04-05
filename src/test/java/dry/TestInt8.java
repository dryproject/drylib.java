/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt8 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Int8.of(null); });
  }

  @Test
  void testMethod_size() {
    assertThat(Int8.MAX.size()).isEqualTo(1);
  }

  @Test
  void testMethod_toString() {
    assertThat(Int8.of(-1).toString()).isEqualTo("-1");
    assertThat(Int8.of(0).toString()).isEqualTo("0");
  }
}
