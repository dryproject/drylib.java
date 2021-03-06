/* This is free and unencumbered software released into the public domain. */

import dry.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestBool {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Bool.of(null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Bool.FALSE).isEqualByComparingTo(Bool.FALSE);
    assertThat(Bool.TRUE).isEqualByComparingTo(Bool.TRUE);
    assertThat(Bool.FALSE).isLessThan(Bool.TRUE);
    assertThat(Bool.TRUE).isGreaterThan(Bool.FALSE);
  }

  @Test
  void testMethod_value() {
    assertThat(Bool.TRUE.value()).isEqualTo(true);
    assertThat(Bool.FALSE.value()).isEqualTo(false);
  }

  @Test
  void testMethod_toString() {
    assertThat(Bool.TRUE.toString()).isEqualTo("true");
    assertThat(Bool.FALSE.toString()).isEqualTo("false");
  }
}
