/* This is free and unencumbered software released into the public domain. */

import dry.*;
import dry.Float;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestFloat {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Float.of((java.lang.Double)null); });
    assertThatNullPointerException().isThrownBy(() -> { Float.of((java.lang.Float)null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Float.MIN).isEqualByComparingTo(Float.MIN);
    assertThat(Float.MAX).isEqualByComparingTo(Float.MAX);
    assertThat(Float.MIN).isLessThan(Float.MAX);
    assertThat(Float.MAX).isGreaterThan(Float.MIN);
  }

  @Test
  void testMethod_size() {
    assertThat(Float.MAX.size()).isEqualTo(8);
  }

  @Test
  void testMethod_toString() {
    assertThat(Float.of(1.23d).toString()).isEqualTo("1.23");
  }
}
