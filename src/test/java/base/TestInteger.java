/* This is free and unencumbered software released into the public domain. */

import dry.*;
import dry.Integer;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestInteger {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Integer.of(null); });
  }

  @Test
  void testInterface_Comparable() {
    assertThat(Integer.ZERO).isEqualByComparingTo(Integer.ZERO);
    assertThat(Integer.ONE).isEqualByComparingTo(Integer.ONE);
    assertThat(Integer.ZERO).isLessThan(Integer.ONE);
    assertThat(Integer.ONE).isGreaterThan(Integer.ZERO);
  }

  @Test
  void testMethod_toString() {
    assertThat(Integer.of(-1).toString()).isEqualTo("-1");
    assertThat(Integer.of(0).toString()).isEqualTo("0");
  }
}
