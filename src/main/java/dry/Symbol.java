/* This is free and unencumbered software released into the public domain. */

package dry;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Symbol.
 */
public interface Symbol extends Comparable<Symbol> {
  @NotNull
  public static Symbol of(final char character) {
    return new StringSymbol(java.lang.Character.toString(character));
  }

  @NotNull
  public static Symbol of(@NotNull final Char character) {
    return new StringSymbol(Objects.requireNonNull(character).toString());
  }

  @NotNull
  public static Symbol of(@NotNull final java.lang.Character character) {
    return new StringSymbol(Objects.requireNonNull(character).toString());
  }

  @NotNull
  public static Symbol of(@NotNull final java.lang.String string) {
    return new StringSymbol(string);
  }

  @Override @NotNull
  public java.lang.String toString();

  class StringSymbol extends java.lang.Object implements Symbol {
    private static final long serialVersionUID = 1L;

    public final java.lang.String string;

    protected StringSymbol(@NotNull final java.lang.String string) {
      this.string = Objects.requireNonNull(string);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(this.string);
    }

    @Override
    public boolean equals(@Nullable final Object object) {
      if (this == object) return true;
      if (object == null) return false;
      if (!(object instanceof Symbol)) return false;
      final Symbol that = (Symbol)object;
      return Objects.equals(this.string, that.toString());
    }

    @Override
    public int compareTo(@NotNull final Symbol that) {
      return this.string.compareTo(Objects.requireNonNull(that).toString());
    }

    @Override @NotNull
    public java.lang.String toString() {
      return this.string;
    }
  }
}
