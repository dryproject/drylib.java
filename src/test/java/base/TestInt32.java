/* This is free and unencumbered software released into the public domain. */

import dry.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt32 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Int32.of(null); });
  }

  @Test
  void testMethod_size() {
    assertThat(Int32.MAX.size()).isEqualTo(4);
  }

  @Test
  void testMethod_toString() {
    assertThat(Int32.of(-1).toString()).isEqualTo("-1");
    assertThat(Int32.of(0).toString()).isEqualTo("0");
  }
}
