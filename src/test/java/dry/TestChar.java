/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestChar {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Char.of(null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Char.of('a')).isEqualByComparingTo(Char.of('a'));
    assertThat(Char.of('a')).isLessThan(Char.of('b'));
    assertThat(Char.of('b')).isGreaterThan(Char.of('a'));
  }

  @Test
  void testMethod_toString() {
    assertThat(Char.of(0x41).toString()).isEqualTo("A");
    assertThat(Char.of(0x20000).toString()).isEqualTo("\uD840\uDC00");
  }
}
