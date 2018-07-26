/* This is free and unencumbered software released into the public domain. */

import dry.text.ASCII;

import static org.assertj.core.api.Assertions.*;

import dry.*;
import dry.String;

import org.junit.jupiter.api.*;

class TestASCII {

  @Test
  void testConstructWithNull() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.String.of((byte[])null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.String.of((char[])null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.String.of((Char)null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.String.of((String)null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.String.of((java.lang.Character)null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.String.of((java.lang.String)null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.String.of((java.lang.CharSequence)null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.String.of((java.nio.CharBuffer)null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.String.of((java.nio.ByteBuffer)null); });
  }

  @Test
  void testConstructFromByteLiteral() {
    assertThat(ASCII.String.of((byte)0x61)).isNotNull();
  }

  @Test
  void testConstructFromByteArrayLiteral() {
    assertThat(ASCII.String.of(new byte[] { 0x61, 0x62, 0x63 })).isNotNull();
  }

  @Test
  void testConstructFromCharLiteral() {
    assertThat(ASCII.String.of('a')).isNotNull();
  }

  @Test
  void testConstructFromCharArrayLiteral() {
    assertThat(ASCII.String.of(new char[] { 'a', 'b', 'c' })).isNotNull();
  }

  @Test
  void testConstructFromChar() {
    assertThat(ASCII.String.of(Char.of('a'))).isNotNull();
  }

  @Test
  void testConstructFromString() {
    // TODO
  }

  @Test
  void testConstructFromJavaCharacter() {
    // TODO
  }

  @Test
  void testConstructFromJavaString() {
    assertThatCode(() -> { ASCII.String.of(""); }).doesNotThrowAnyException();
    assertThatCode(() -> { ASCII.String.of("Hello, world!"); }).doesNotThrowAnyException();
  }

  @Test
  void testConstructFromJavaCharSequence() {
    // TODO
  }

  @Test
  void testConstructFromJavaCharBuffer() {
    // TODO
  }

  @Test
  void testConstructFromJavaByteBuffer() {
    // TODO
  }

  @Test
  void testMethod_isBlank() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.isBlank((String)null); });
    // TODO
  }

  @Test
  void testMethod_compare() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.compare((String)null, (String)null); });
    // TODO
  }

  @Test
  void testMethod_concat() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.concat((String)null, (String)null); });
    // TODO
  }

  @Test
  void testMethod_contains() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.contains((String)null, (Char)null); });
    // TODO
  }

  @Test
  void testMethod_isEmpty() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.isEmpty((String)null); });
    assertThat(ASCII.String.of("").isEmpty()).isTrue();
    assertThat(ASCII.String.of("Hello").isEmpty()).isFalse();
  }

  @Test
  void testMethod_endsWith() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.endsWith((String)null, (String)null); });
    // TODO
  }

  @Test
  void testMethod_equals() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.equals((String)null, (String)null); });
    // TODO
  }

  @Test
  void testMethod_length() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.length((String)null); });
    // TODO
  }

  @Test
  void testMethod_nth() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.nth((String)null, (Nat)null); });
    // TODO
  }

  @Test
  void testMethod_reverse() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.reverse((String)null); });
    // TODO
  }

  @Test
  void testMethod_size() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.size((String)null); });
    // TODO
  }

  @Test
  void testMethod_startsWith() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.startsWith((String)null, (String)null); });
    // TODO
  }

  @Test
  void testMethod_trim() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.trim((String)null); });
    // TODO
  }

  @Test
  void testMethod_trimLeft() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.trimLeft((String)null); });
    // TODO
  }

  @Test
  void testMethod_trimRight() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.trimRight((String)null); });
    // TODO
  }

  @Test
  void testMethod_isValid() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.isValid((String)null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.isValid((ASCII.String)null); });
    assertThat(ASCII.isValid(ASCII.String.of(""))).isTrue();
  }
}
