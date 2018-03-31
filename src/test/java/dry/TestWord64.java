/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestWord64 {

  @Test
  void testConstructWithNull() {
    //assertThatNullPointerException().isThrownBy(() -> { new Word64(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Word64.MIN.toString()).isEqualTo("0x0000000000000000");
    assertThat(Word64.MAX.toString()).isEqualTo("0xffffffffffffffff");
  }
}
