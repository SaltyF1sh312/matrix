package matrix;

import java.math.*;

public class Rational extends Number implements Comparable<Rational> {
	/**
	 * The numerator of the <code>Rational</code>
	 */
	private BigInteger numerator = BigInteger.ZERO;
	/**
	 * The denominator of the <code>Rational</code>
	 */
	private BigInteger denominator = BigInteger.ONE;
	
	/**
	 * Construct a new <code>Rational</code> object with default properties
	 */
	public Rational() {
		this(BigInteger.ZERO, BigInteger.ONE);
	}
	/**
	 * Construct a new <code>Rational</code> object
	 * @param numerator
	 * @param denominator
	 */
	public Rational(BigInteger numerator, BigInteger denominator) {
		BigInteger gcd = gcd(numerator, denominator);
		this.numerator = (denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE 
				: new BigInteger(-1 + "")).multiply(numerator).divide(gcd);
		this.denominator = denominator.abs().divide(gcd);
	}
	/**
	 * Find GCD of two <code>Rational</code>
	 * @param numerator
	 * @param denominator
	 * @return the GCD of two rational numbers
	 */
	private static BigInteger gcd(BigInteger n, BigInteger d) {
		BigInteger n1 = n.abs();
		BigInteger n2 = d.abs();
		BigInteger remainder;
		
		while ((remainder = n1.remainder(n2)).compareTo(BigInteger.ZERO) > 0) {
			n1 = n2;
			n2 = remainder;
		}
		return n2;
	}
	/**
	 * Get the numerator of the current <code>Rational</code>
	 * @return the numerator of the rational number
	 */
	public BigInteger getNumerator() {
		return numerator;
	}
	/**
	 * Get the denominator of the current <code>Rational</code>
	 * @return the denominator of the rational number
	 */
	public BigInteger getDenominator() {
		return denominator;
	}
	/**
	 * Add another <code>Rational</code> to the current <code>Rational</code>
	 * @param anotherRational
	 * @return the resultant <code>Rational</code> (this + anotherRational)
	 */
	public Rational add(Rational anotherRational) {
		BigInteger n = numerator.multiply(anotherRational.getDenominator()).add(
				denominator.multiply(anotherRational.getNumerator()));
		BigInteger d = denominator.multiply(anotherRational.getDenominator());
		return new Rational(n, d);
	}
	/**
	 * Subtract another <code>Rational</code> from the current <code>Rational</code>
	 * @param anotherRational
	 * @return the resultant <code>Rational</code> (this - anotherRational)
	 */
	public Rational subtract(Rational anotherRational) {
		BigInteger n = numerator.multiply(anotherRational.getDenominator()).subtract(
				denominator.multiply(anotherRational.getNumerator()));
		BigInteger d = denominator.multiply(anotherRational.getDenominator());
		return new Rational(n, d);
	}
	/**
	 * Multiply the current <code>Rational</code> by another <code>Rational</code>
	 * @param anotherRational
	 * @return the resultant <code>Rational</code> (this * anotherRational)
	 */
	public Rational multiply(Rational anotherRational) {
		BigInteger n = numerator.multiply(anotherRational.getNumerator());
		BigInteger d = denominator.multiply(anotherRational.getDenominator());
		return new Rational(n, d);
	}
	/**
	 * Divide the current <code>Rational</code> by another <code>Rational</code>
	 * @param anotherRational
	 * @return the resultant <code>Rational</code> (this / anotherRational)
	 */
	public Rational divide(Rational anotherRational) {
		BigInteger n = numerator.multiply(anotherRational.getDenominator());
		BigInteger d = denominator.multiply(anotherRational.getNumerator());
		return new Rational(n, d);
	}
	
	/**
	 * the absolute value of current <code>Rational</code>
	 * @param q
	 * @return the absolute value of current rational number
	 */
	public static Rational abs(Rational q) {
		return q.compareTo(new Rational()) > 0 ? 
				q : q.multiply(new Rational(new BigInteger(-1 + ""), BigInteger.ONE));
	}
	/**
	 * Get the greater one between two <code>Rational</code>
	 * @param q1
	 * @param q2
	 * @return a greater rational number
	 */
	public static Rational max(Rational q1, Rational q2) {
		return (q1.compareTo(q2) > 0) ? q1 : q2;
	}
	/**
	 * Get the smaller one between two <code>Rational</code>
	 * @param q1
	 * @param q2
	 * @return a smaller rational number
	 */
	public static Rational min(Rational q1, Rational q2) {
		return (q1.compareTo(q2) < 0) ? q1 : q2;
	}
	/**
	 * Parse the <code>String</code> as a <code>Rational</code> of type x/y
	 * @param s the input rational number as string
	 * @return a <code>Rational</code> which is represented by the string
	 */
	public static Rational parseComplex(String s) {
		s = s.replaceAll(" ", "");
		Rational parsed = null;
		if(s.contains(String.valueOf("/")) && s.lastIndexOf('/') > 0)
		{
			String strNumerator = "";
			String strDenominator = "";
			strNumerator = s.substring(0,s.indexOf('/'));
			strDenominator = s.substring(s.indexOf('/') + 1, s.length());
			parsed = new Rational(new BigInteger(strNumerator), new BigInteger(strDenominator));
		}
		else // Pure numerator
			parsed = new Rational(new BigInteger(s), BigInteger.ONE);
		return parsed;
	}
	
	@Override
	public String toString() {
		if (denominator.compareTo(BigInteger.ONE) == 0) 
			return numerator + "";
		else
			return numerator + "/"+ denominator;
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;
		
		Rational other = (Rational) object;
		if (this.subtract(other).getNumerator() != BigInteger.ZERO)
			return false;
		return true;
	}
	
	@Override
	public int intValue() {
		return (int)doubleValue();
	}
	
	@Override
	public float floatValue() {
		return (float)doubleValue();
	}
	
	@Override
	public double doubleValue() {
		return numerator.divide(denominator).doubleValue();
	}
	
	@Override
	public long longValue() {
		return (long)doubleValue();
	}
	
	@Override
	public int compareTo(Rational o) {
		if (numerator.compareTo(o.getNumerator()) > 0)
			return 1;
		else if (numerator.compareTo(o.getNumerator()) < 0)
			return -1;
		else
			return 0;
	}

}
