/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestFloat {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { new Float((java.lang.Double)null); });
    assertThatNullPointerException().isThrownBy(() -> { new Float((java.lang.Float)null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(new Float(1.23d).toString()).isEqualTo("1.23");
  }
}
