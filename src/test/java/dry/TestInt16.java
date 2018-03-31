/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInt16 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { new Int16(null); });
  }
}
