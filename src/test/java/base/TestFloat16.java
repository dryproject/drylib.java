/* This is free and unencumbered software released into the public domain. */

import dry.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestFloat16 {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Float16.of((java.lang.Double)null); });
    assertThatNullPointerException().isThrownBy(() -> { Float16.of((java.lang.Float)null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Float16.MIN).isEqualByComparingTo(Float16.MIN);
    assertThat(Float16.MAX).isEqualByComparingTo(Float16.MAX);
    assertThat(Float16.MIN).isLessThan(Float16.MAX);
    assertThat(Float16.MAX).isGreaterThan(Float16.MIN);
  }

  @Test
  void testMethod_size() {
    assertThat(Float16.MAX.size()).isEqualTo(2);
  }

  @Test
  void testMethod_toString() {
    assertThat(Float16.of(1.23).toString()).isEqualTo("1.23");
  }
}
