/* This is free and unencumbered software released into the public domain. */

import dry.text.ASCII;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testConstructFromByteLiteral() {
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of((byte)-1); });
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of((byte)0x80); });
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of((byte)0xFF); });
    assertThatCode(() -> { ASCII.String.of((byte)0); }).doesNotThrowAnyException();
    assertThatCode(() -> { ASCII.String.of((byte)0x7F); }).doesNotThrowAnyException();
    assertThat(ASCII.String.of((byte)0x61)).isNotNull();
  }

  @Test
  void testConstructFromByteArrayLiteral() {
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of(new byte[] { (byte)0x80 }); });
    assertThat(ASCII.String.of(new byte[] {})).isNotNull();
    assertThat(ASCII.String.of(new byte[] { 0x61, 0x62, 0x63 })).isNotNull();
  }

  @Test
  void testConstructFromCharLiteral() {
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of((char)0x80); });
    assertThat(ASCII.String.of('a')).isNotNull();
  }

  @Test
  void testConstructFromCharArrayLiteral() {
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of(new char[] { (char)0x80 }); });
    assertThat(ASCII.String.of(new char[] {})).isNotNull();
    assertThat(ASCII.String.of(new char[] { 'a', 'b', 'c' })).isNotNull();
  }

  @Test
  void testConstructFromChar() {
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of(Char.of(0x80)); });
    assertThat(ASCII.String.of(Char.of('a'))).isNotNull();
  }

  @Test
  void testConstructFromString() {
    assertThat(ASCII.String.of(ASCII.String.of(""))).isNotNull();
    assertThat(ASCII.String.of(ASCII.String.of("Hello, world!"))).isNotNull();
  }

  @Test
  void testConstructFromJavaCharacter() {
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of(java.lang.Character.valueOf((char)0x80)); });
    assertThat(ASCII.String.of(java.lang.Character.valueOf('a'))).isNotNull();
  }

  @Test
  void testConstructFromJavaString() {
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of("\u0080"); });
    assertThat(ASCII.String.of("")).isNotNull();
    assertThat(ASCII.String.of("Hello, world!")).isNotNull();
  }

  @Test
  void testConstructFromJavaCharSequence() {
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of("\u0080".subSequence(0, 1)); });
    assertThat(ASCII.String.of("\u0000".subSequence(0, 1))).isNotNull();
    assertThat(ASCII.String.of("\u007F".subSequence(0, 1))).isNotNull();
    assertThat(ASCII.String.of("Hello, world!".subSequence(0, 13))).isNotNull();
  }

  @Test
  void testConstructFromJavaCharBuffer() {
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of(java.nio.CharBuffer.wrap(new char[] { 0x80 })); });
    assertThat(ASCII.String.of(java.nio.CharBuffer.wrap(new char[] {}))).isNotNull();
    assertThat(ASCII.String.of(java.nio.CharBuffer.wrap(new char[] { 'a' }))).isNotNull();
  }

  @Test
  void testConstructFromJavaByteBuffer() {
    assertThatIllegalArgumentException().isThrownBy(() -> { ASCII.String.of(java.nio.ByteBuffer.wrap(new byte[] { (byte)0x80 })); });
    assertThat(ASCII.String.of(java.nio.ByteBuffer.wrap(new byte[] {}))).isNotNull();
    assertThat(ASCII.String.of(java.nio.ByteBuffer.wrap(new byte[] { 0x61 }))).isNotNull();
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testIterability() {
    // See: https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html
    final ASCII.String string = ASCII.String.of("123456");

    final java.nio.CharBuffer buffer = java.nio.CharBuffer.allocate(6);
    for (final Char c : string) buffer.put((char)c.value()); // safe cast with ASCII charset
    assertThat(buffer.toString()).isEqualTo(string.toString());
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testCloneability() {
    // See: https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html#clone()
    final ASCII.String x = ASCII.String.of("foobar");
    assertThat(x).isInstanceOf(Cloneable.class);

    assertThat(x.clone()).isNotSameAs(x);
    assertThat(x.clone().getClass()).isSameAs(x.getClass());
    assertThat(x.clone()).isEqualTo(x);
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testReadability() {
    // See: https://docs.oracle.com/javase/10/docs/api/java/lang/Readable.html
    final ASCII.String x = ASCII.String.of("123456");
    assertThat(x).isInstanceOf(Readable.class);

    java.nio.CharBuffer cb = java.nio.CharBuffer.allocate(8);
    assertThat(x.read(cb)).isEqualTo(6);
    assertThat(x.read(cb)).isEqualTo(2);
    assertThat(x.read(cb)).isEqualTo(0);
    assertThat(cb.rewind().toString()).isEqualTo("12345612");
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testSerializability() {
    // See: https://docs.oracle.com/javase/10/docs/api/java/io/Serializable.html
    // See: https://stackoverflow.com/q/2904560
    final ASCII.String x = ASCII.String.of("123456");
    assertThat(x).isInstanceOf(java.io.Serializable.class);

    java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
    assertThatCode(() -> {
      java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
      oos.flush();
      oos.writeObject(x);
      oos.close();
    }).doesNotThrowAnyException();

    java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(baos.toByteArray());
    assertThatCode(() -> {
      java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bais);
      final ASCII.String y = (ASCII.String)ois.readObject();
      assertThat(y).isEqualTo(x);
    }).doesNotThrowAnyException();
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_isBlank() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.isBlank((String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_compare() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.compare((String)null, (String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_concat() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.concat((String)null, (String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_contains() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.contains((String)null, (Char)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_isEmpty() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.isEmpty((String)null); });
    assertThat(ASCII.String.of("").isEmpty()).isTrue();
    assertThat(ASCII.String.of("Hello").isEmpty()).isFalse();
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_endsWith() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.endsWith((String)null, (String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_equals() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.equals((String)null, (String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_length() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.length((String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_nth() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.nth((String)null, (Nat)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_reverse() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.reverse((String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_size() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.size((String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_startsWith() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.startsWith((String)null, (String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_trim() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.trim((String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_trimLeft() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.trimLeft((String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_trimRight() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.trimRight((String)null); });
    // TODO
  }

////////////////////////////////////////////////////////////////////////////////

  @Test
  void testMethod_isValid() {
    assertThatNullPointerException().isThrownBy(() -> { ASCII.isValid((Char)null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.isValid((String)null); });
    assertThatNullPointerException().isThrownBy(() -> { ASCII.isValid((ASCII.String)null); });
    assertThat(ASCII.isValid(ASCII.String.of(""))).isTrue();
    assertThat(ASCII.isValid('\0')).isTrue();
    assertThat(ASCII.isValid('a')).isTrue();
    assertThat(ASCII.isValid('\u007F')).isTrue();
    assertThat(ASCII.isValid('\u0080')).isFalse();
  }
}
