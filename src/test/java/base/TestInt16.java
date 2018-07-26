/* This is free and unencumbered software released into the public domain. */

import dry.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt16 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Int16.of(null); });
  }

  @Test
  void testMethod_size() {
    assertThat(Int16.MAX.size()).isEqualTo(2);
  }

  @Test
  void testMethod_toString() {
    assertThat(Int16.of(-1).toString()).isEqualTo("-1");
    assertThat(Int16.of(0).toString()).isEqualTo("0");
  }
}
