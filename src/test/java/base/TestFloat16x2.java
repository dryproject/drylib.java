/* This is free and unencumbered software released into the public domain. */

import dry.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestFloat16x2 {

  @Test
  void testMethod_toString() {
    assertThat(Float16x2.of(1f, 2f).toString()).isEqualTo("[1.0, 2.0]");
  }
}
