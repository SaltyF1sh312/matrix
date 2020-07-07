package matrix;

import java.math.BigInteger;

public class RationalMatrix extends GenericMatrix<Rational> {
	/**
	 * Construct a new <code>RationalMatrix</code> object with default properties
	 */
	public RationalMatrix() {
		
	}
	/**
	 * Construct a new <code>RationalMatrix</code> object with the input matrix
	 * @param matrix
	 */
	public RationalMatrix(Rational[][] matrix) {
		super(matrix);
	}
	/**
	 * Add two specified rational numbers
	 */
	@Override
	public Rational add(Rational q1, Rational q2) {
		return q1.add(q2);
	}
	/**
	 * Subtract q2 from q1
	 */
	@Override
	public Rational subtract(Rational q1, Rational q2) {
		return q1.subtract(q2);
	}
	/**
	 * Multiply two specified rational numbers
	 */
	@Override
	public Rational multiply(Rational q1, Rational q2) {
		return q1.multiply(q2);
	}
	/**
	 * Divide q1 by q2
	 */
	@Override
	public Rational divide(Rational q1, Rational q2) {
		return q1.divide(q2);
	}
	/**
	 * Specify zero for a rational number
	 */
	@Override
	public Rational zero() {
		return new Rational();
	}
	/**
	 * Get the absolute Value of a specified rational number
	 */
	@Override
	public Rational abs(Rational q) {
		return q.compareTo(zero()) > 0 ? q : multiply(q, new Rational(BigInteger.ONE, BigInteger.ONE));
	}
	/**
	 * Calculate the current specified matrix element to the passed integer power
	 * @param power
	 * @return a <code>Rational</code> which is (-1)^power
	 */
	@Override
	public Rational powOfMinusOne(int power) {
		return power % 2 == 0 ? new Rational(BigInteger.ONE, BigInteger.ONE) : 
			new Rational(new BigInteger(-1 + ""), BigInteger.ONE);
	}
	/**
	 * Compare two specified matrix elements
	 */
	@Override
	public int compare(Rational q1, Rational q2) {
		return q1.compareTo(q2);
	}
	/**
	 * Construct a new specified <code>RationalMatrix</code> object with the input row&column
	 * whose elements are all zero
	 */
	@Override
	public RationalMatrix zeros(int row, int column) {
		Rational[][] zeros = new Rational[row][column];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				zeros[i][j] = zero();
		
		return new RationalMatrix(zeros);
	}
	/**
	 * Construct a new specified identity <code>RationalMatrix</code> object with the input row
	 */
	@Override
	public RationalMatrix eye(int row) {
		Rational[][] eye = new Rational[row][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				if (i == j) // Set elements on the diagonal to one
					eye[i][i] = new Rational(BigInteger.ONE, BigInteger.ONE);
				else // Set elements that are not on the diagonal to zero
					eye[i][j] = zero();
			}
		}
		
		return new RationalMatrix(eye);
	}
	/**
	 * Construct a new <code>RationalMatrix</code> object copied from this
	 */
	@Override
	public RationalMatrix getCopy() {
		Rational[][] copy = new Rational[getRow()][getColumn()];
		for (int i = 0; i < getRow(); i++)
			for (int j = 0; j < getColumn(); j++)
				copy[i][j] = getValue(i, j);
		
		return new RationalMatrix(copy);
	}

}
