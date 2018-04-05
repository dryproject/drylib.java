/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestFloat32 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Float32.of((java.lang.Double)null); });
    assertThatNullPointerException().isThrownBy(() -> { Float32.of((java.lang.Float)null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Float32.MIN).isEqualByComparingTo(Float32.MIN);
    assertThat(Float32.MAX).isEqualByComparingTo(Float32.MAX);
    assertThat(Float32.MIN).isLessThan(Float32.MAX);
    assertThat(Float32.MAX).isGreaterThan(Float32.MIN);
  }

  @Test
  void testMethod_size() {
    assertThat(Float32.MAX.size()).isEqualTo(4);
  }

  @Test
  void testMethod_toString() {
    assertThat(Float32.of(1.23).toString()).isEqualTo("1.23");
  }
}
