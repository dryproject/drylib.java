/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestChar {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Char.valueOf(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Char.valueOf(0x41).toString()).isEqualTo("A");
    assertThat(Char.valueOf(0x20000).toString()).isEqualTo("\uD840\uDC00");
  }
}
