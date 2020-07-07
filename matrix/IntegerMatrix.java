package matrix;

import java.math.BigInteger;

public class IntegerMatrix extends GenericMatrix<Integer> {
	/**
	 * Construct a new <code>IntegerMatrix</code> object with default properties
	 */
	public IntegerMatrix() {
		
	}
	/**
	 * Construct a new <code>IntegerMatrix</code> object with the input matrix
	 * @param matrix
	 */
	public IntegerMatrix(Integer[][] matrix) {
		super(matrix);
	}
	/**
	 * Add two specified integers
	 */
	@Override
	public Integer add(Integer o1, Integer o2) {
		return o1 + o2;
	}
	/**
	 * Subtract o2 from o1
	 */
	@Override
	public Integer subtract(Integer o1, Integer o2) {
		return o1 - o2;
	}
	/**
	 * Multiply two specified integers
	 */
	@Override
	public Integer multiply(Integer o1, Integer o2) {
		return o1 * o2;
	}
	/**
	 * Divide o1 by o2
	 */
	@Override
	public Integer divide(Integer o1, Integer o2) {
		return o1 / o2;
	}
	/**
	 * Specify zero for an integer
	 */
	@Override
	public Integer zero() {
		return 0;
	}
	/**
	 * Get the absolute Value of a specified integer
	 */
	@Override
	public Integer abs(Integer o) {
		return (o.compareTo(0) > 0) ? o : multiply(o, -1);
	}
	/**
	 * Calculate the current specified matrix element to the passed integer power
	 * @param power
	 * @return a <code>Double</code> which is (-1)^power
	 */
	@Override
	public Integer powOfMinusOne(int power) {
		return power % 2 == 0 ? 1 : -1;
	}
	/**
	 * Compare two specified matrix elements
	 */
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
	/**
	 * Construct a new specified <code>IntegerMatrix</code> object with the input row&column
	 * whose elements are all zero
	 */
	@Override
	public IntegerMatrix zeros(int row, int column) {
		Integer[][] zeros = new Integer[row][column];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				zeros[i][j] = zero();
		
		return new IntegerMatrix(zeros);
	}
	/**
	 * Construct a new specified identity <code>IntegerMatrix</code> object with the input row
	 */
	@Override
	public IntegerMatrix eye(int row) {
		Integer[][] eye = new Integer[row][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				if (i == j) // Set elements on the diagonal to one
					eye[i][i] = 1;
				else // Set elements that are not on the diagonal to zero
					eye[i][j] = zero();
			}
		}
		
		return new IntegerMatrix(eye);
	}
	/**
	 * Get the rank of the current <code>IntegerMatrix</code>
	 */
	@Override
	public int getRank() {
		// Dividing an integer by another integer may lose precision
		Rational[][] temp = new Rational[getRow()][getColumn()];
		
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getColumn(); j++) {
				temp[i][j] = new Rational(new BigInteger(getValue(i, j) + ""), BigInteger.ONE);
			}
		}
		
		return new RationalMatrix(temp).getRank();
	}

	/**
	 * Construct a new <code>IntegerMatrix</code> object copied from this
	 */
	@Override
	public IntegerMatrix getCopy() {
		Integer[][] copy = new Integer[getRow()][getColumn()];
		for (int i = 0; i < getRow(); i++)
			for (int j = 0; j < getColumn(); j++)
				copy[i][j] = getValue(i, j);
		
		return new IntegerMatrix(copy);
	}

}
