/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestSymbol {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Symbol.of((Char)null); });
    assertThatNullPointerException().isThrownBy(() -> { Symbol.of((java.lang.Character)null); });
    assertThatNullPointerException().isThrownBy(() -> { Symbol.of((java.lang.String)null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Symbol.of('a')).isEqualByComparingTo(Symbol.of('a'));
    assertThat(Symbol.of('a')).isLessThan(Symbol.of('b'));
    assertThat(Symbol.of('b')).isGreaterThan(Symbol.of('a'));
  }

  @Test
  void testMethod_toString() {
    assertThat(Symbol.of('A').toString()).isEqualTo("A");
    assertThat(Symbol.of(Char.valueOf(0x41)).toString()).isEqualTo("A");
    assertThat(Symbol.of(Char.valueOf(0x20000)).toString()).isEqualTo("\uD840\uDC00");
  }
}
