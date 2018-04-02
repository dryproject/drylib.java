/* This is free and unencumbered software released into the public domain. */

package dry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Machine word (native size).
 */
public abstract class AbstractWord extends ExactNumber implements Word {
  private static final long serialVersionUID = 1L;

  public final long value;

  protected AbstractWord(final long value) {
    this.value = value;
  }

  @Override
  public long getValue() {
    return this.value;
  }

  @Override
  public long longValue() {
    return this.value;
  }

  @Override
  public double doubleValue() {
    return (double)this.value;
  }

  @Override
  public int hashCode() {
    return java.lang.Long.hashCode(this.value);
  }

  @Override
  public boolean equals(@Nullable final Object object) {
    if (this == object) return true;
    if (object == null) return false;
    if (!(object instanceof AbstractWord)) return false;
    final AbstractWord that = (AbstractWord)object;
    return this.value == that.value;
  }
}
