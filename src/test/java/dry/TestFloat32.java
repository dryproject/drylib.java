/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestFloat32 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { new Float32((java.lang.Double)null); });
    assertThatNullPointerException().isThrownBy(() -> { new Float32((java.lang.Float)null); });
  }
}
