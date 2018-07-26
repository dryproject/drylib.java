/* This is free and unencumbered software released into the public domain. */

import dry.*;
import dry.Float;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class TestScalar {

  @Test
  void testInterface_Tensor() {
    assertThat(Float.of(1.24).rank()).isEqualTo(Natural.ZERO);
  }
}
