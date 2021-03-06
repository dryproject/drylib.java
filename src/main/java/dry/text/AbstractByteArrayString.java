/* This is free and unencumbered software released into the public domain. */

package dry.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

import dry.Char;
import dry.Nat;
import dry.String;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Base class for byte-array string implementations.
 *
 * This class is an implementation detail and not part of the public API.
 *
 * @see <a href="https://drylib.org/java">[1]</a>
 */
abstract class AbstractByteArrayString extends AbstractString implements dry.String {
  private static final long serialVersionUID = 1L;

  protected final byte[] array;

  protected AbstractByteArrayString(final @NotNull byte[] array) {
    this.array = Objects.requireNonNull(array);
  }

  protected AbstractByteArrayString(final @NotNull ByteBuffer buffer) {
    Objects.requireNonNull(buffer);
    assert buffer.hasArray();
    assert buffer.array() != null;
    this.array = (buffer.arrayOffset() == 0) ?
      buffer.array() :
      Arrays.copyOfRange(buffer.array(), buffer.arrayOffset(), buffer.array().length);
  }

  @Override
  protected @NotNull byte[] array() {
    return this.array;
  }

  @Override
  protected int arraySize() {
    return this.array.length;
  }

  @Override
  public boolean isEmpty() {
    return this.arraySize() == 0;
  }

  @Override
  public boolean isBlank() {
    return this.isEmpty(); // TODO
  }

  @Override
  public @NotNull Nat size() {
    return Nat.of(this.arraySize());
  }

  @Override
  public boolean equals(@Nullable final AbstractEmptyString that) {
    return that != null && this.isEmpty();
  }

  @Override
  public boolean equals(@Nullable final AbstractByteArrayString that) {
    return that != null && Arrays.equals(this.array, that.array);
  }

  @Override
  public boolean equals(@Nullable final AbstractByteBufferString that) {
    return that != null &&
      this.arraySize() == that.bufferSize() &&
      Arrays.equals(
        this.array(), this.arrayOffset(), this.arrayLimit(),
        that.array(), that.arrayOffset(), that.arrayLimit());
  }

  @Override
  public int compareTo(@NotNull final AbstractEmptyString that) {
    Objects.requireNonNull(that);
    return this.isEmpty() ? 0 : 1;
  }

  @Override
  public int compareTo(@NotNull final AbstractByteArrayString that) {
    Objects.requireNonNull(that);
    return Arrays.compare(this.array, that.array);
  }

  @Override
  public int compareTo(@NotNull final AbstractByteBufferString that) {
    Objects.requireNonNull(that);
    return Arrays.compare(
      this.array(), this.arrayOffset(), this.arrayLimit(),
      that.array(), that.arrayOffset(), that.arrayLimit());
  }

  class Iterator implements java.util.Iterator<Char> {
    int position = AbstractByteArrayString.this.arrayOffset();

    @Override
    public boolean hasNext() {
      return this.position < AbstractByteArrayString.this.arrayLimit();
    }

    @Override
    public @NotNull Char next() {
      if (!this.hasNext()) throw new NoSuchElementException();
      return Char.of(AbstractByteArrayString.this.array[this.position++]);
    }
  }

  @Override
  public @NotNull java.util.Iterator<Char> iterator() {
    return new Iterator();
  }
}
