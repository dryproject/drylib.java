/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestFloat64 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Float64.of((java.lang.Double)null); });
    assertThatNullPointerException().isThrownBy(() -> { Float64.of((java.lang.Float)null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Float64.MIN).isEqualByComparingTo(Float64.MIN);
    assertThat(Float64.MAX).isEqualByComparingTo(Float64.MAX);
    assertThat(Float64.MIN).isLessThan(Float64.MAX);
    assertThat(Float64.MAX).isGreaterThan(Float64.MIN);
  }

  @Test
  void testMethod_size() {
    assertThat(Float64.MAX.size()).isEqualTo(8);
  }

  @Test
  void testMethod_toString() {
    assertThat(Float64.of(1.23d).toString()).isEqualTo("1.23");
  }
}
