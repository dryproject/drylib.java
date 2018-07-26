/* This is free and unencumbered software released into the public domain. */

import dry.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestWord32 {

  @Test
  void testConstructWithNull() {
    //assertThatNullPointerException().isThrownBy(() -> { Word32.of(null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Word32.MIN).isEqualByComparingTo(Word32.MIN);
    assertThat(Word32.MAX).isEqualByComparingTo(Word32.MAX);
    assertThat(Word32.MIN).isLessThan(Word32.MAX);
    assertThat(Word32.MAX).isGreaterThan(Word32.MIN);
  }

  @Test
  void testMethod_toString() {
    assertThat(Word32.MIN.toString()).isEqualTo("0x00000000");
    assertThat(Word32.MAX.toString()).isEqualTo("0xffffffff");
  }
}
