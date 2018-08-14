/* This is free and unencumbered software released into the public domain. */

package dry.text;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

import dry.Nat;
import dry.String;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Base class for string implementations.
 *
 * This class is an implementation detail and not part of the public API.
 *
 * @see <a href="https://drylib.org/java">[1]</a>
 */
abstract class AbstractString implements dry.String {
  private static final long serialVersionUID = 1L;

  protected AbstractString() {}

  protected abstract @NotNull byte[] array();

  protected int arrayOffset() {
    return 0;
  }

  protected int arrayLimit() {
    return this.array().length;
  }

  protected int arraySize() {
    return this.arrayLimit() - this.arrayOffset();
  }

  protected @NotNull ByteBuffer buffer() {
    return ByteBuffer.wrap(this.array(), this.arrayOffset(), this.arrayLimit());
  }

  protected int bufferSize() {
    return this.arrayLimit() - this.arrayOffset();
  }

  @Override
  public @NotNull byte[] toByteArray() {
    return Arrays.copyOfRange(this.array(), this.arrayOffset(), this.arrayLimit());
  }

  @Override
  public @NotNull ByteBuffer toByteBuffer() {
    return this.buffer().asReadOnlyBuffer();
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.array()); // FIXME
  }

  public boolean equals(@Nullable final AbstractEmptyString that) {
    return this == that; // overridden in subclasses
  }

  public boolean equals(@Nullable final AbstractByteArrayString that) {
    return this == that; // overridden in subclasses
  }

  public boolean equals(@Nullable final AbstractByteBufferString that) {
    return this == that; // overridden in subclasses
  }

  public boolean equals(@Nullable final String that) {
    if (this == that) return true;
    if (that == null) return false;
    return Arrays.equals(this.toByteArray(), that.toByteArray()); // TODO: optimize this
  }

  @Override
  public boolean equals(@Nullable final Object object) {
    if (this == object) return true;
    if (object == null) return false;
    if (object instanceof AbstractEmptyString) {
      return this.equals((AbstractEmptyString)object);
    }
    if (object instanceof AbstractByteArrayString) {
      return this.equals((AbstractByteArrayString)object);
    }
    if (object instanceof AbstractByteBufferString) {
      return this.equals((AbstractByteBufferString)object);
    }
    if (object instanceof String) {
      return this.equals((String)object);
    }
    return false;
  }

  public int compareTo(@NotNull final AbstractEmptyString that) {
    Objects.requireNonNull(that);
    return -1; // overridden in subclasses
  }

  public int compareTo(@NotNull final AbstractByteArrayString that) {
    Objects.requireNonNull(that);
    return -1; // overridden in subclasses
  }

  public int compareTo(@NotNull final AbstractByteBufferString that) {
    Objects.requireNonNull(that);
    return -1; // overridden in subclasses
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
    return Arrays.compare(this.toByteArray(), that.toByteArray()); // TODO: optimize this
  }
}
