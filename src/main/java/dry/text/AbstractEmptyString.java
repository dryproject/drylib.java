/* This is free and unencumbered software released into the public domain. */

package dry.text;

import java.nio.ByteBuffer;
import java.util.Objects;

import dry.Nat;
import dry.String;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Base class for empty string implementations.
 *
 * This class is an implementation detail and not part of the public API.
 *
 * @see <a href="https://drylib.org/java">[1]</a>
 */
abstract class AbstractEmptyString extends AbstractString implements dry.String {
  private static final long serialVersionUID = 1L;

  public static final byte[] ARRAY = {};

  protected AbstractEmptyString() {}

  protected @NotNull byte[] array() {
    return ARRAY;
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public boolean isBlank() {
    return true;
  }

  @Override
  public @NotNull Nat size() {
    return Nat.of(0);
  }

  @Override
  public @NotNull byte[] toByteArray() {
    return ARRAY; // empty arrays are immutable
  }

  @Override
  public boolean equals(@Nullable final AbstractEmptyString that) {
    return that != null; // always equal
  }

  @Override
  public boolean equals(@Nullable final AbstractByteArrayString that) {
    return that != null && that.isEmpty();
  }

  @Override
  public boolean equals(@Nullable final AbstractByteBufferString that) {
    return that != null && that.isEmpty();
  }

  @Override
  public boolean equals(@Nullable final String that) {
    return that != null && that.isEmpty();
  }

  @Override
  public int compareTo(@NotNull final AbstractEmptyString that) {
    Objects.requireNonNull(that);
    return 0; // always equal
  }

  @Override
  public int compareTo(@NotNull final AbstractByteArrayString that) {
    Objects.requireNonNull(that);
    return that.isEmpty() ? 0 : -1; // always the smallest element
  }

  @Override
  public int compareTo(@NotNull final AbstractByteBufferString that) {
    Objects.requireNonNull(that);
    return that.isEmpty() ? 0 : -1; // always the smallest element
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
    return that.isEmpty() ? 0 : -1; // always the smallest element
  }
}
