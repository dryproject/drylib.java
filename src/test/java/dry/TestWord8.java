/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestWord8 {

  @Test
  void testConstructWithNull() {
    //assertThatNullPointerException().isThrownBy(() -> { Word8.of(null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Word8.MIN).isEqualByComparingTo(Word8.MIN);
    assertThat(Word8.MAX).isEqualByComparingTo(Word8.MAX);
    assertThat(Word8.MIN).isLessThan(Word8.MAX);
    assertThat(Word8.MAX).isGreaterThan(Word8.MIN);
  }

  @Test
  void testMethod_toString() {
    assertThat(Word8.MIN.toString()).isEqualTo("0x00");
    assertThat(Word8.MAX.toString()).isEqualTo("0xff");
  }
}
