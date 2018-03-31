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
}
