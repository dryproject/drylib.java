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

  public final static Charset CHARSET = StandardCharsets.US_ASCII;

  // TODO: MIN_CHAR
  // TODO: MAX_CHAR

  /**
   * Implements <tt>dry:text/ascii/string</tt>.
   *
   * @see <a href="https://drylib.org/text/ascii/string">[1]</a>
   */
  public interface String extends dry.String {
    public class ByteBufferString implements String {
      protected final ByteBuffer buffer;

      protected ByteBufferString(final @NotNull ByteBuffer buffer) {
        this.buffer = Objects.requireNonNull(buffer);
      }

      @Override
      public @NotNull ByteBuffer buffer() {
        return this.buffer;
      }

      @Override
      public @NotNull ByteBuffer toByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
      }
    }

    public static String of(final byte input) {
      // TODO: validate input
      return new ByteBufferString(ByteBuffer.wrap(new byte[]{ input }));
    }

    public static String of(final @NotNull byte[] input) {
      // TODO: validate input
      return new ByteBufferString(ByteBuffer.wrap(Objects.requireNonNull(input)));
    }

    public static String of(final char input) {
      // TODO: validate input
      return new ByteBufferString(CHARSET.encode(CharBuffer.wrap(new char[]{ input })));
    }

    public static String of(final @NotNull char[] input) {
      // TODO: validate input
      return new ByteBufferString(CHARSET.encode(CharBuffer.wrap(Objects.requireNonNull(input))));
    }

    public static String of(final @NotNull Char input) {
      final int codePoint = Objects.requireNonNull(input).value();
      if (codePoint > 0x7F) {
        // TODO: validate input
      }
      return new ByteBufferString(ByteBuffer.wrap(new byte[]{ (byte)codePoint }));
    }

    public static String of(final @NotNull dry.String input) {
      Objects.requireNonNull(input);
      // TODO: validate input
      return null; // TODO
    }

    public static String of(final @NotNull java.lang.Character input) {
      Objects.requireNonNull(input);
      // TODO: validate input
      return null; // TODO
    }

    public static String of(final @NotNull java.lang.String input) {
      return new ByteBufferString(CHARSET.encode(Objects.requireNonNull(input)));
    }

    public static String of(final @NotNull java.lang.CharSequence input) {
      Objects.requireNonNull(input);
      return null; // TODO
    }

    public static String of(final @NotNull java.nio.CharBuffer input) {
      return new ByteBufferString(CHARSET.encode(Objects.requireNonNull(input)));
    }

    public static String of(final @NotNull java.nio.ByteBuffer input) {
      return new ByteBufferString(Objects.requireNonNull(input));
    }
  }

  /**
   * Implements <tt>dry:text/ascii/blank?</tt>.
   *
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
   * @see <a href="https://drylib.org/text/ascii/contains%3F">[1]</a>
   */
  public static boolean
  contains(final @NotNull dry.String string,
           final @NotNull Char character) {
    Objects.requireNonNull(string);
    Objects.requireNonNull(character);
    if (character.value() > 0x7F) return false;
    return false; // TODO
  }

  /**
   * Implements <tt>dry:text/ascii/empty?</tt>.
   *
   * @see <a href="https://drylib.org/text/ascii/empty%3F">[1]</a>
   */
  public static boolean
  isEmpty(final @NotNull dry.String string) {
    return Objects.requireNonNull(string).isEmpty();
  }

  /**
   * Implements <tt>dry:text/ascii/ends-with?</tt>.
   *
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
   * @see <a href="https://drylib.org/text/ascii/length">[1]</a>
   */
  public static @NotNull Nat
  length(final @NotNull dry.String string) {
    return Objects.requireNonNull(string).size();
  }

  /**
   * Implements <tt>dry:text/ascii/nth</tt>.
   *
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
   * @see <a href="https://drylib.org/text/ascii/size">[1]</a>
   */
  public static @NotNull Nat
  size(final @NotNull dry.String string) {
    return Objects.requireNonNull(string).size();
  }

  /**
   * Implements <tt>dry:text/ascii/starts-with?</tt>.
   *
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
   * @see <a href="https://drylib.org/text/ascii/valid%3F">[1]</a>
   */
  public static boolean
  isValid(final @NotNull String string) {
    Objects.requireNonNull(string);
    return true;
  }
  public static boolean
  isValid(final @NotNull dry.String string) {
    Objects.requireNonNull(string);
    return false; // TODO
  }
}
