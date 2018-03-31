/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestWord32 {

  @Test
  void testConstructWithNull() {
    //assertThatNullPointerException().isThrownBy(() -> { new Word32(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Word32.MIN.toString()).isEqualTo("0x00000000");
    assertThat(Word32.MAX.toString()).isEqualTo("0xffffffff");
  }
}
