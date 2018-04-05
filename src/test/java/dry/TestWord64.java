/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestWord64 {

  @Test
  void testConstructWithNull() {
    //assertThatNullPointerException().isThrownBy(() -> { Word64.of(null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Word64.MIN).isEqualByComparingTo(Word64.MIN);
    assertThat(Word64.MAX).isEqualByComparingTo(Word64.MAX);
    //assertThat(Word64.MIN).isLessThan(Word64.MAX); // FIXME
    //assertThat(Word64.MAX).isGreaterThan(Word64.MIN); // FIXME
  }

  @Test
  void testMethod_toString() {
    assertThat(Word64.MIN.toString()).isEqualTo("0x0000000000000000");
    assertThat(Word64.MAX.toString()).isEqualTo("0xffffffffffffffff");
  }
}
