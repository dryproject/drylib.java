/* This is free and unencumbered software released into the public domain. */

import dry.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.BigInteger;

class TestReal {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Real.of((BigDecimal)null); });
    assertThatNullPointerException().isThrownBy(() -> { Real.of((BigInteger)null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Real.of(0).toString()).isEqualTo("0");
    assertThat(Real.of(42).toString()).isEqualTo("42");
    assertThat(Real.of(1.23).toString()).isEqualTo("1.23");
  }
}
