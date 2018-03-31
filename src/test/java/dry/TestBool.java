/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestBool {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { new Bool(null); });
  }

  @Test
  void testGetValue() {
    assertThat(Bool.TRUE.getValue()).isEqualTo(true);
    assertThat(Bool.FALSE.getValue()).isEqualTo(false);
  }
}
