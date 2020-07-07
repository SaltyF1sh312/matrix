package matrix;

public class DoubleMatrix extends GenericMatrix<Double> {
	/**
	 * Construct a new <code>DoubleMatrix</code> object with default properties
	 */
	public DoubleMatrix() {
		
	}
	/**
	 * Construct a new <code>DoubleMatrix</code> object with the input matrix
	 * @param matrix
	 */
	public DoubleMatrix(Double[][] matrix) {
		super(matrix);
	}
	/**
	 * Add two specified doubles
	 */
	@Override
	public Double add(Double d1, Double d2) {
		return d1 + d2;
	}
	/**
	 * Subtract d2 from d1
	 */
	@Override
	public Double subtract(Double d1, Double d2) {
		return d1 - d2;
	}
	/**
	 * Multiply two specified doubles
	 */
	@Override
	public Double multiply(Double d1, Double d2) {
		return d1 * d2;
	}
	/**
	 *  Divide d1 by d2
	 */
	@Override
	public Double divide(Double d1, Double d2) {
		return d1 / d2;
	}
	/**
	 * Specify zero for a double
	 */
	@Override
	public Double zero() {
		return 0.0;
	}
	/**
	 * Get the absolute Value of a specified double
	 */
	@Override
	public Double abs(Double d) {
		return (d.compareTo(zero()) > 0) ? d : multiply(d, -1.0);
	}
	/**
	 * Calculate the current specified matrix element to the passed integer power
	 * @param power
	 * @return a <code>Double</code> which is (-1)^power
	 */
	@Override
	public Double powOfMinusOne(int power) {
		return Math.pow(-1.0, power);
	}
	/**
	 * Compare two specified matrix elements
	 */
	@Override
	public int compare(Double d1, Double d2) {
		return d1.compareTo(d2);
	}
	/**
	 * Construct a new specified <code>DoubleMatrix</code> object with the input row&column
	 * whose elements are all zero
	 */
	@Override
	public DoubleMatrix zeros(int row, int column) {
		Double[][] zeros = new Double[row][column];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				zeros[i][j] = zero();
		
		return new DoubleMatrix(zeros);
	}
	/**
	 * Construct a new specified identity <code>DoubleMatrix</code> object with the input row
	 */
	@Override
	public DoubleMatrix eye(int row) {
		Double[][] eye = new Double[row][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				if (i == j) // Set elements on the diagonal to one
					eye[i][i] = 1.0;
				else // Set elements that are not on the diagonal to zero
					eye[i][j] = zero();
			}
		}
		
		return new DoubleMatrix(eye);
	}
	/**
	 * Construct a new <code>DoubleMatrix</code> object copied from this
	 */
	@Override
	public DoubleMatrix getCopy() {
		Double[][] copy = new Double[getRow()][getColumn()];
		for (int i = 0; i < getRow(); i++)
			for (int j = 0; j < getColumn(); j++)
				copy[i][j] = getValue(i, j);
		
		return new DoubleMatrix(copy);
	}

}
