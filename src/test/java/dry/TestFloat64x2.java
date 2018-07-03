/* This is free and unencumbered software released into the public domain. */

package dry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestFloat64x2 {

  @Test
  void testMethod_toString() {
    assertThat(Float64x2.of(1d, 2d).toString()).isEqualTo("[1.0, 2.0]");
  }
}
