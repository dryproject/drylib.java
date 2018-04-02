/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.BigInteger;

class TestReal {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { Real.valueOf((BigDecimal)null); });
    assertThatNullPointerException().isThrownBy(() -> { Real.valueOf((BigInteger)null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(Real.valueOf(0).toString()).isEqualTo("0");
    assertThat(Real.valueOf(42).toString()).isEqualTo("42");
    assertThat(Real.valueOf(1.23).toString()).isEqualTo("1.23");
  }
}
