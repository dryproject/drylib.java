/* This is free and unencumbered software released into the public domain. */

package dry.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Optional;

import dry.Char;
import dry.Nat;

import org.jetbrains.annotations.NotNull;

/**
 * ASCII text processing.
 *
 * @see <a href="https://drylib.org/text/ascii/">[1]</a>
 */
public final class ASCII {
  private ASCII() {}

  public static final Charset CHARSET = StandardCharsets.US_ASCII;
  public static final Char MIN_CHAR = Char.of(0);    // ASCII NUL
  public static final Char MAX_CHAR = Char.of(0x7F); // ASCII 127

  /**
   * ASCII validation exception.
   */
  public static class ValidationException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;
  }

  /**
   * Implements <tt>dry:text/ascii/string</tt>.
   *
   * @see <a href="https://drylib.org/text/ascii/string">[1]</a>
   */
  public interface String extends dry.String {
    static final long serialVersionUID = 1L;

    /**
     * The canonical empty ASCII string.
     */
    public static final String EMPTY = new EmptyString();

    /**
     * Constructs a new ASCII string from the given byte.
     *
     * @param input the single byte to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII byte
     */
    public static @NotNull String of(final byte input) {
      if (input < MIN_CHAR.value) throw new ValidationException();
      if (input > MAX_CHAR.value) throw new ValidationException();
      return new ByteArrayString(new byte[]{ input });
    }

    /**
     * Constructs a new ASCII string from the given byte array.
     *
     * @param input the byte array to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII byte sequence
     */
    public static @NotNull String of(final @NotNull byte[] input) {
      Objects.requireNonNull(input);
      if (input.length == 0) return EMPTY;
      for (final byte b : input) {
        if (b < MIN_CHAR.value) throw new ValidationException();
        if (b > MAX_CHAR.value) throw new ValidationException();
      }
      return new ByteArrayString(input);
    }

    /**
     * Constructs a new ASCII string from the given Java character.
     *
     * @param input the character to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII character
     */
    public static @NotNull String of(final char input) {
      if (input < MIN_CHAR.value) throw new ValidationException();
      if (input > MAX_CHAR.value) throw new ValidationException();
      final ByteBuffer buffer = CHARSET.encode(CharBuffer.wrap(new char[]{ input }));
      return buffer.hasArray() ? new ByteArrayString(buffer.array()) : new ByteBufferString(buffer);
    }

    /**
     * Constructs a new ASCII string from the given Java character array.
     *
     * @param input the character array to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII character sequence
     */
    public static @NotNull String of(final @NotNull char[] input) {
      Objects.requireNonNull(input);
      if (input.length == 0) return EMPTY;
      for (final char c : input) {
        if (c < MIN_CHAR.value) throw new ValidationException();
        if (c > MAX_CHAR.value) throw new ValidationException();
      }
      final ByteBuffer buffer = CHARSET.encode(CharBuffer.wrap(input));
      return buffer.hasArray() ? new ByteArrayString(buffer.array()) : new ByteBufferString(buffer);
    }

    /**
     * Constructs a new ASCII string from the given character.
     *
     * @param input the character to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII character
     */
    public static @NotNull String of(final @NotNull Char input) {
      final int codePoint = Objects.requireNonNull(input).value;
      if (codePoint > MAX_CHAR.value) throw new ValidationException();
      return new ByteArrayString(new byte[]{ (byte)codePoint });
    }

    /**
     * Constructs a new ASCII string from the given string.
     *
     * @param input the string to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII character sequence
     */
    public static @NotNull String of(final @NotNull dry.String input) {
      Objects.requireNonNull(input);
      if (input.isEmpty()) return EMPTY;
      if (!ASCII.isValid(input)) throw new ValidationException();
      return new ByteArrayString(input.toByteArray());
    }

    /**
     * Constructs a new ASCII string from the given Java character.
     *
     * @param input the character to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII character
     */
    public static @NotNull String of(final @NotNull java.lang.Character input) {
      return of(Objects.requireNonNull(input).charValue());
    }

    /**
     * Constructs a new ASCII string from the given Java string.
     *
     * @param input the string to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII character sequence
     */
    public static @NotNull String of(final @NotNull java.lang.String input) {
      Objects.requireNonNull(input);
      if (input.isEmpty()) return EMPTY;
      input.chars().forEach(c -> {
        if (c < MIN_CHAR.value) throw new ValidationException();
        if (c > MAX_CHAR.value) throw new ValidationException();
      });
      final ByteBuffer buffer = CHARSET.encode(input);
      return buffer.hasArray() ? new ByteArrayString(buffer.array()) : new ByteBufferString(buffer);
    }

    /**
     * Constructs a new ASCII string from the given Java character sequence.
     *
     * @param input the character sequence to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII character sequence
     */
    public static @NotNull String of(final @NotNull java.lang.CharSequence input) {
      Objects.requireNonNull(input);
      if (input.length() == 0) return EMPTY;
      input.chars().forEach(c -> {
        if (c < MIN_CHAR.value) throw new ValidationException();
        if (c > MAX_CHAR.value) throw new ValidationException();
      });
      final ByteBuffer buffer = CHARSET.encode(java.nio.CharBuffer.wrap(input));
      return buffer.hasArray() ? new ByteArrayString(buffer.array()) : new ByteBufferString(buffer);
    }

    /**
     * Constructs a new ASCII string from the given character buffer.
     *
     * @param input the character buffer to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII character sequence
     */
    public static @NotNull String of(final @NotNull java.nio.CharBuffer input) {
      Objects.requireNonNull(input);
      if (!input.hasRemaining()) return EMPTY;
      try {
        for (int i = input.position(); i < input.limit(); i++) {
          final char c = input.get(i);
          if (c < MIN_CHAR.value) throw new ValidationException();
          if (c > MAX_CHAR.value) throw new ValidationException();
        }
      }
      catch (final IndexOutOfBoundsException error) {
        assert false : "unreachable";
      }
      final ByteBuffer buffer = CHARSET.encode(input.slice());
      return buffer.hasArray() ? new ByteArrayString(buffer.array()) : new ByteBufferString(buffer);
    }

    /**
     * Constructs a new ASCII string from the given byte buffer.
     *
     * @param input the byte buffer to validate
     * @return a validated ASCII string
     * @throws ValidationException if <tt>input</tt> is not a valid ASCII byte sequence
     */
    public static @NotNull String of(final @NotNull java.nio.ByteBuffer input) {
      Objects.requireNonNull(input);
      if (!input.hasRemaining()) return EMPTY;
      try {
        for (int i = input.position(); i < input.limit(); i++) {
          final byte b = input.get(i);
          if (b < MIN_CHAR.value) throw new ValidationException();
          if (b > MAX_CHAR.value) throw new ValidationException();
        }
      }
      catch (final IndexOutOfBoundsException error) {
        assert false : "unreachable";
      }
      return new ByteBufferString(input.slice());
    }

    /**
     * Creates and returns a copy of this string.
     *
     * This method performs a shallow copy of this string, meaning that the
     * returned new string is backed by the same underlying array or buffer
     * as this string.
     *
     * @return a clone of this instance
     */
    @Override
    public @NotNull String clone();

  } // interface String

  static class EmptyString extends AbstractEmptyString implements String {
    private static final long serialVersionUID = 1L;

    protected EmptyString() {
      super();
    }

    @Override
    public @NotNull String clone() {
      return (String)super.clone();
    }

    @Override
    public @NotNull Charset charset() {
      return CHARSET;
    }

    @Override
    public boolean is(final @NotNull java.lang.String string) {
      return string.isEmpty();
    }
  }

  static class ByteArrayString extends AbstractByteArrayString implements String {
    private static final long serialVersionUID = 1L;

    protected ByteArrayString(final @NotNull byte[] array) {
      super(Objects.requireNonNull(array));
    }

    protected ByteArrayString(final @NotNull ByteBuffer buffer) {
      super(Objects.requireNonNull(buffer));
    }

    @Override
    public @NotNull String clone() {
      return (String)super.clone();
    }

    @Override
    public @NotNull Charset charset() {
      return CHARSET;
    }

    @Override
    public boolean is(final @NotNull java.lang.String string) {
      return false; // TODO
    }
  }

  static class ByteBufferString extends AbstractByteBufferString implements String {
    private static final long serialVersionUID = 1L;

    protected ByteBufferString(final @NotNull ByteBuffer buffer) {
      super(Objects.requireNonNull(buffer));
    }

    @Override
    public @NotNull String clone() {
      return (String)super.clone();
    }

    @Override
    public @NotNull Charset charset() {
      return CHARSET;
    }

    @Override
    public boolean is(final @NotNull java.lang.String string) {
      return false; // TODO
    }
  }

  /**
   * Implements <tt>dry:text/ascii/blank?</tt>.
   *
   * @param string the input string
   * @return <tt>true</tt> if <tt>string</tt> is blank, <tt>false</tt> otherwise
   * @see <a href="https://drylib.org/text/ascii/blank%3F">[1]</a>
   */
  public static boolean
  isBlank(final @NotNull dry.String string) {
    Objects.requireNonNull(string);
    return false; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/compare</tt>.
   *
   * @param string1 the first string
   * @param string2 the second string
   * @return <tt>-1</tt>, <tt>0</tt>, or <tt>1</tt>
   * @see <a href="https://drylib.org/text/ascii/compare">[1]</a>
   */
  public static int
  compare(final @NotNull dry.String string1,
          final @NotNull dry.String string2) {
    Objects.requireNonNull(string1);
    Objects.requireNonNull(string2);
    return -1; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/concat</tt>.
   *
   * @param string1 the first string
   * @param string2 the second string
   * @return a new string concatenating <tt>string1</tt> and <tt>string2</tt>
   * @see <a href="https://drylib.org/text/ascii/concat">[1]</a>
   */
  public static @NotNull dry.String
  concat(final @NotNull dry.String string1,
         final @NotNull dry.String string2) {
    Objects.requireNonNull(string1);
    Objects.requireNonNull(string2);
    return string1; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/contains?</tt>.
   *
   * @param string the input string
   * @param character the character to search for
   * @return <tt>true</tt> if <tt>string</tt> contains <tt>character</tt>, <tt>false</tt> otherwise
   * @see <a href="https://drylib.org/text/ascii/contains%3F">[1]</a>
   */
  public static boolean
  contains(final @NotNull dry.String string,
           final @NotNull Char character) {
    Objects.requireNonNull(string);
    Objects.requireNonNull(character);
    if (character.value() > MAX_CHAR.value) return false;
    return false; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/empty?</tt>.
   *
   * @param string the input string
   * @return <tt>true</tt> if <tt>string</tt> is empty, <tt>false</tt> otherwise
   * @see <a href="https://drylib.org/text/ascii/empty%3F">[1]</a>
   */
  public static boolean
  isEmpty(final @NotNull dry.String string) {
    return Objects.requireNonNull(string).isEmpty();
  }

  /**
   * Implements <tt>dry:text/ascii/ends-with?</tt>.
   *
   * @param string the input string
   * @param suffix the suffix to search for
   * @return <tt>true</tt> if <tt>string</tt> ends with <tt>suffix</tt>, <tt>false</tt> otherwise
   * @see <a href="https://drylib.org/text/ascii/ends-with%3F">[1]</a>
   */
  public static boolean
  endsWith(final @NotNull dry.String string,
           final @NotNull dry.String suffix) {
    Objects.requireNonNull(string);
    Objects.requireNonNull(suffix);
    if (suffix.size().intValue() > string.size().intValue()) return false;
    return false; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/equals?</tt>.
   *
   * @param string1 the first string
   * @param string2 the second string
   * @return <tt>true</tt> if <tt>string1</tt> and <tt>string2</tt>
   *         represent the same character sequence, <tt>false</tt> otherwise
   * @see <a href="https://drylib.org/text/ascii/equals%3F">[1]</a>
   */
  public static boolean
  equals(final @NotNull dry.String string1,
         final @NotNull dry.String string2) {
    Objects.requireNonNull(string1);
    Objects.requireNonNull(string2);
    return string1 == string2; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/length</tt>.
   *
   * @param string the input string
   * @return a nonnegative integer
   * @see <a href="https://drylib.org/text/ascii/length">[1]</a>
   */
  public static @NotNull Nat
  length(final @NotNull dry.String string) {
    return Objects.requireNonNull(string).size();
  }

  /**
   * Implements <tt>dry:text/ascii/nth</tt>.
   *
   * @param string the input string
   * @param index the index of the character to return
   * @return the character at the given nonnegative <tt>index</tt> of
   *         <tt>string</tt>, or nothing if the index is invalid
   * @see <a href="https://drylib.org/text/ascii/nth">[1]</a>
   */
  public static @NotNull Optional<Char>
  nth(final @NotNull dry.String string,
      final @NotNull Nat index) {
    Objects.requireNonNull(string);
    Objects.requireNonNull(index);
    if (index.intValue() > string.size().intValue()) return Optional.empty();
    return Optional.empty(); // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/reverse</tt>.
   *
   * @param string the input string
   * @return
   * @see <a href="https://drylib.org/text/ascii/reverse">[1]</a>
   */
  public static @NotNull dry.String
  reverse(final @NotNull dry.String string) {
    Objects.requireNonNull(string);
    return string; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/size</tt>.
   *
   * @param string the input string
   * @return a nonnegative integer
   * @see <a href="https://drylib.org/text/ascii/size">[1]</a>
   */
  public static @NotNull Nat
  size(final @NotNull dry.String string) {
    return Objects.requireNonNull(string).size();
  }

  /**
   * Implements <tt>dry:text/ascii/starts-with?</tt>.
   *
   * @param string the input string
   * @param prefix the prefix to search for
   * @return <tt>true</tt> if <tt>string</tt> starts with <tt>suffix</tt>, <tt>false</tt> otherwise
   * @see <a href="https://drylib.org/text/ascii/starts-with%3F">[1]</a>
   */
  public static boolean
  startsWith(final @NotNull dry.String string,
             final @NotNull dry.String prefix) {
    Objects.requireNonNull(string);
    Objects.requireNonNull(prefix);
    if (prefix.size().intValue() > string.size().intValue()) return false;
    return false; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/trim</tt>.
   *
   * @param string the input string
   * @return
   * @see <a href="https://drylib.org/text/ascii/trim">[1]</a>
   */
  public static @NotNull dry.String
  trim(final @NotNull dry.String string) {
    Objects.requireNonNull(string);
    return string; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/trim-left</tt>.
   *
   * @param string the input string
   * @return
   * @see <a href="https://drylib.org/text/ascii/trim-left">[1]</a>
   */
  public static @NotNull dry.String
  trimLeft(final @NotNull dry.String string) {
    Objects.requireNonNull(string);
    return string; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/trim-right</tt>.
   *
   * @param string the input string
   * @return
   * @see <a href="https://drylib.org/text/ascii/trim-right">[1]</a>
   */
  public static @NotNull dry.String
  trimRight(final @NotNull dry.String string) {
    Objects.requireNonNull(string);
    return string; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/valid?</tt>.
   *
   * @param character the input character
   * @return <tt>true</tt> if <tt>character</tt> is a valid ASCII character,
   *         <tt>false</tt> otherwise
   * @see <a href="https://drylib.org/text/ascii/valid%3F">[1]</a>
   */
  public static boolean
  isValid(final char character) {
    return character <= MAX_CHAR.value;
  }

  /**
   * Implements <tt>dry:text/ascii/valid?</tt>.
   *
   * @param character the input character
   * @return <tt>true</tt> if <tt>character</tt> is a valid ASCII character,
   *         <tt>false</tt> otherwise
   * @see <a href="https://drylib.org/text/ascii/valid%3F">[1]</a>
   */
  public static boolean
  isValid(final @NotNull Char character) {
    Objects.requireNonNull(character);
    return character.value <= MAX_CHAR.value;
  }

  /**
   * Implements <tt>dry:text/ascii/valid?</tt>.
   *
   * @param string the input string
   * @return <tt>true</tt> because <tt>string</tt> is known to be a valid
   *         ASCII character sequence
   * @see <a href="https://drylib.org/text/ascii/valid%3F">[1]</a>
   */
  public static boolean
  isValid(final @NotNull String string) {
    Objects.requireNonNull(string);
    return true; // pre-validated on construction
  }

  /**
   * Implements <tt>dry:text/ascii/valid?</tt>.
   *
   * @param string the input string
   * @return <tt>true</tt> if <tt>string</tt> is a valid ASCII character
   *         sequence, <tt>false</tt> otherwise
   * @see <a href="https://drylib.org/text/ascii/valid%3F">[1]</a>
   */
  public static boolean
  isValid(final @NotNull dry.String string) {
    Objects.requireNonNull(string);
    return true; // TODO: validate input
  }
}
