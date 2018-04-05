/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestNatural {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Natural.of(null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Natural.ZERO.toString()).isEqualTo("0");
    assertThat(Natural.ONE.toString()).isEqualTo("1");
    assertThat(Natural.TWO.toString()).isEqualTo("2");
    assertThat(Natural.TEN.toString()).isEqualTo("10");
  }
}
