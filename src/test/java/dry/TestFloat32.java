/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestFloat32 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Float32.valueOf((java.lang.Double)null); });
    assertThatNullPointerException().isThrownBy(() -> { Float32.valueOf((java.lang.Float)null); });
  }

  @Test
  void testMethod_size() {
    assertThat(Float32.MAX.size()).isEqualTo(4);
  }

  @Test
  void testMethod_toString() {
    assertThat(Float32.valueOf(1.23).toString()).isEqualTo("1.23");
  }
}
