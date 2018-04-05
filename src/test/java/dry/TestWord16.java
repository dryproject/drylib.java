/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestWord16 {

  @Test
  void testConstructWithNull() {
    //assertThatNullPointerException().isThrownBy(() -> { Word16.of(null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Word16.MIN).isEqualByComparingTo(Word16.MIN);
    assertThat(Word16.MAX).isEqualByComparingTo(Word16.MAX);
    assertThat(Word16.MIN).isLessThan(Word16.MAX);
    assertThat(Word16.MAX).isGreaterThan(Word16.MIN);
  }

  @Test
  void testMethod_toString() {
    assertThat(Word16.MIN.toString()).isEqualTo("0x0000");
    assertThat(Word16.MAX.toString()).isEqualTo("0xffff");
  }
}
