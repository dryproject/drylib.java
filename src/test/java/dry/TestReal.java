/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.math.BigInteger;

class TestReal {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { new Real((BigDecimal)null); });
    assertThatNullPointerException().isThrownBy(() -> { new Real((BigInteger)null); });
  }

  @Test
  void testMethod_toString() {
    assertThat(new Real(0).toString()).isEqualTo("0");
    assertThat(new Real(42).toString()).isEqualTo("42");
    assertThat(new Real(1.23).toString()).isEqualTo("1.23");
  }
}
