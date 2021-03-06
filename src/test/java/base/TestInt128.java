/* This is free and unencumbered software released into the public domain. */

import dry.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt128 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Int128.of(null); });
  }

  @Test
  void testMethod_size() {
    assertThat(Int128.MAX.size()).isEqualTo(16);
  }

  @Test
  void testMethod_toString() {
    assertThat(Int128.of(-1).toString()).isEqualTo("-1");
    assertThat(Int128.of(0).toString()).isEqualTo("0");
  }
}
