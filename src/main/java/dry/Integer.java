/* This is free and unencumbered software released into the public domain. */

package dry;

import java.math.BigInteger;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Integer number (arbitrary size).
 */
public strictfp interface Integer extends Rational {
  @NotNull
  public static Integer valueOf(final long value) {
    return new Bignum(value);
  }

  @NotNull
  public static Integer valueOf(@NotNull final BigInteger value) {
    return new Bignum(value);
  }

  public static final Integer ZERO = Natural.ZERO;

  public static final Integer ONE = Natural.ONE;

  public static final Integer TWO = Natural.TWO;

  public static final Integer TEN = Natural.TEN;

  @NotNull
  public BigInteger getValue();

  strictfp class Bignum extends AbstractInteger implements Integer {
    private static final long serialVersionUID = 1L;

    public final BigInteger value;

    protected Bignum(final long value) {
      this.value = BigInteger.valueOf(value);
    }

    protected Bignum(final long value,
                     final long min_value) {
      if (value < min_value) throw new ArithmeticException();
      this.value = BigInteger.valueOf(value);
    }

    protected Bignum(final long value,
                     final long min_value,
                     final long max_value) {
      if (value < min_value) throw new ArithmeticException();
      if (value > max_value) throw new ArithmeticException();
      this.value = BigInteger.valueOf(value);
    }

    protected Bignum(@NotNull final BigInteger value) {
      this.value = Objects.requireNonNull(value);
    }

    protected Bignum(@NotNull final BigInteger value,
                     @Nullable final BigInteger min_value,
                     @Nullable final BigInteger max_value) {
      Objects.requireNonNull(value);
      if (min_value != null && value.compareTo(min_value) < 0) throw new ArithmeticException();
      if (max_value != null && value.compareTo(max_value) > 0) throw new ArithmeticException();
      this.value = value;
    }

    @Override @NotNull
    public BigInteger getValue() {
      return this.value;
    }

    @Override
    public int signum() {
      return this.value.signum();
    }

    @Override
    public long longValue() {
      return this.value.longValue();
    }

    @Override
    public int intValue() {
      return this.value.intValue();
    }

    @Override
    public short shortValue() {
      return this.value.shortValue();
    }

    @Override
    public byte byteValue() {
      return this.value.byteValue();
    }

    @Override
    public double doubleValue() {
      return this.value.doubleValue();
    }

    @Override
    public float floatValue() {
      return this.value.floatValue();
    }

    @Override
    public int hashCode() {
      return this.value.hashCode();
    }

    @Override
    public boolean equals(@Nullable final Object object) {
      if (this == object) return true;
      if (object == null) return false;
      if (!(object instanceof Bignum)) return false;
      final Bignum that = (Bignum)object;
      return Objects.equals(this.value, that.value);
    }

    @Override @NotNull
    public String toString() {
      return this.value.toString();
    }
  }

  strictfp abstract class Fixnum extends Bignum implements Integer {
    private static final long serialVersionUID = 1L;

    protected Fixnum(final long value) {
      super(value);
    }

    protected Fixnum(final long value,
                     final long min_value,
                     final long max_value) {
      super(value, min_value, max_value);
    }

    protected Fixnum(@NotNull final BigInteger value,
                     @Nullable final BigInteger min_value,
                     @Nullable final BigInteger max_value) {
      super(value, min_value, max_value);
    }

    // TODO: implement fixnums
  }
}
