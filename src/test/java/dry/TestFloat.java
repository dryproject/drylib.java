/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestFloat {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Float.valueOf((java.lang.Double)null); });
    assertThatNullPointerException().isThrownBy(() -> { Float.valueOf((java.lang.Float)null); });
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
    assertThat(Float.valueOf(1.23d).toString()).isEqualTo("1.23");
  }
}
