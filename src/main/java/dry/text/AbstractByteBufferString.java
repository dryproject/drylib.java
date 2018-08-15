/* This is free and unencumbered software released into the public domain. */

package dry.text;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

import dry.Char;
import dry.Nat;
import dry.String;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Base class for byte-buffer string implementations.
 *
 * This class is an implementation detail and not part of the public API.
 *
 * @see <a href="https://drylib.org/java">[1]</a>
 */
abstract class AbstractByteBufferString extends AbstractString implements dry.String {
  private static final long serialVersionUID = 1L;

  protected final ByteBuffer buffer;

  protected AbstractByteBufferString(final @NotNull ByteBuffer buffer) {
    this.buffer = Objects.requireNonNull(buffer);
  }

  @Override
  protected @NotNull byte[] array() {
    assert !this.buffer.isReadOnly();
    assert this.buffer.hasArray();
    return this.buffer.array(); // throws UnsupportedOperationException if no backing array
  }

  @Override
  protected int arrayOffset() {
    assert !this.buffer.isReadOnly();
    assert this.buffer.hasArray();
    return this.buffer.arrayOffset(); // throws UnsupportedOperationException if no backing array
  }

  @Override
  protected int arrayLimit() {
    assert !this.buffer.isReadOnly();
    assert this.buffer.hasArray();
    return this.buffer.array().length; // throws UnsupportedOperationException if no backing array
  }

  @Override
  protected int arraySize() {
    assert this.buffer().remaining() == (super.arraySize());
    return this.buffer().remaining();
  }

  @Override
  protected @NotNull ByteBuffer buffer() {
    return this.buffer.rewind();
  }

  @Override
  protected int bufferSize() {
    return this.buffer().remaining();
  }

  @Override
  public boolean isEmpty() {
    return !this.buffer().hasRemaining();
  }

  @Override
  public boolean isBlank() {
    return this.isEmpty(); // TODO
  }

  @Override
  public @NotNull Nat size() {
    return Nat.of(this.bufferSize());
  }

  @Override
  public boolean equals(@Nullable final AbstractEmptyString that) {
    return that != null && this.isEmpty();
  }

  @Override
  public boolean equals(@Nullable final AbstractByteArrayString that) {
    return that != null &&
      this.bufferSize() == that.arraySize() &&
      Arrays.equals(
        this.array(), this.arrayOffset(), this.arrayLimit(),
        that.array(), that.arrayOffset(), that.arrayLimit());
  }

  @Override
  public boolean equals(@Nullable final AbstractByteBufferString that) {
    return that != null &&
      this.bufferSize() == that.bufferSize() &&
      this.buffer().compareTo(that.buffer()) == 0;
  }

  @Override
  public int compareTo(@NotNull final AbstractEmptyString that) {
    Objects.requireNonNull(that);
    return this.isEmpty() ? 0 : 1;
  }

  @Override
  public int compareTo(@NotNull final AbstractByteArrayString that) {
    Objects.requireNonNull(that);
    return Arrays.compare(
      this.array(), this.arrayOffset(), this.arrayLimit(),
      that.array(), that.arrayOffset(), that.arrayLimit());
  }

  @Override
  public int compareTo(@NotNull final AbstractByteBufferString that) {
    Objects.requireNonNull(that);
    return this.buffer().compareTo(that.buffer());
  }

  @Override
  public int compareTo(@NotNull final String that) {
    if (that instanceof AbstractEmptyString) {
      return this.compareTo((AbstractEmptyString)that);
    }
    if (that instanceof AbstractByteArrayString) {
      return this.compareTo((AbstractByteArrayString)that);
    }
    if (that instanceof AbstractByteBufferString) {
      return this.compareTo((AbstractByteBufferString)that);
    }
    Objects.requireNonNull(that);
    return this.buffer().compareTo(that.toByteBuffer().rewind());
  }

  class Iterator implements java.util.Iterator<Char> {
    int position = 0;

    @Override
    public boolean hasNext() {
      return this.position < AbstractByteBufferString.this.buffer.limit();
    }

    @Override
    public @NotNull Char next() {
      if (!this.hasNext()) throw new NoSuchElementException();
      return Char.of(AbstractByteBufferString.this.buffer.get(this.position++));
    }
  }

  @Override
  public @NotNull java.util.Iterator<Char> iterator() {
    return new Iterator();
  }
}
