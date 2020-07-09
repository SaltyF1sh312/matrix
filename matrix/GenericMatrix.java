package matrix;

public abstract class GenericMatrix<E extends Number> {
	/**
	 * The matrix of the <code>GenericMatrix</code>
	 */
	private E[][] matrix;
	/**
	 * The number of rows of the <code>GenericMatrix</code>
	 */
	private int row;
	/**
	 * The number of columns of the <code>GenericMatrix</code>
	 */
	private int column;
	
	/**
	 * Construct a new <code>GenericMatrix</code> object with default properties
	 */
	public GenericMatrix() {
		
	}
	/**
	 * Construct a new <code>GenericMatrix</code> object with the input matrix
	 * @param matrix
	 */
	public GenericMatrix(E[][] matrix) {
		this.matrix = matrix;
		this.row = matrix.length;
		this.column = matrix[0].length;
	}
	/**
	 * Get the matrix of the current <code>GenericMatrix</code>
	 * @return the matrix
	 */
	public E[][] getMatrix() {
		return matrix;
	}
	/**
	 * Get the row of the current <code>GenericMatrix</code>
	 * @return the row of the generic matrix
	 */
	public int getRow() {
		return row;
	}
	/**
	 * Get the column of the current <code>GenericMatrix</code>
	 * @return the column of the generic matrix
	 */
	public int getColumn() {
		return column;
	}
	/**
	 * Set the value of current matrix to the passed matrix
	 * @param matrix
	 */
	public void setMatrix(E[][] matrix) {
		this.matrix = matrix;
	}
	/**
	 * Set the value of current row to the passed row
	 * @param row the row of matrix
	 */
	public void setRow(int row) {
		this.row = row;
	}
	/**
	 * Set the value of current column to the passed column
	 * @param column the column of matrix
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	/**
	 * Get the value of matrix[row][column]
	 * @param row the row index of the matrix
	 * @param column the column index of the matrix
	 * @return the value of matrix[row][column]
	 */
	public E getValue(int row, int column) {
		return matrix[row][column];
	}
	/**
	 * Set current value to the passed value in the matrix[row][column]
	 * @param row the row index of the matrix
	 * @param column the column index of the matrix
	 * @param value the value of matrix[row][column]
	 */
	public void setValue(int row, int column, E value) {
		this.matrix[row][column] = value;
	}
	/**
	 * Abstract method for adding two elements of the matrices
	 * @param o1
	 * @param o2
	 * @return o1 + o2
	 */
	public abstract E add(E o1, E o2);
	/**
	 * Abstract method for subtracting o2 from o1
	 * @param o1
	 * @param o2
	 * @return o1 - o2
	 */
	public abstract E subtract(E o1, E o2);
	/**
	 * Abstract method for multiplying two elements of the matrices
	 * @param o1
	 * @param o2
	 * @return o1 * o2
	 */
	public abstract E multiply(E o1, E o2);
	/**
	 * Abstract method for dividing o1 by o2
	 * @param o1
	 * @param o2
	 * @return o1 / o2
	 */
	public abstract E divide(E o1, E o2);
	/**
	 * Abstract method for defying zero for the matrix element
	 * @return 0
	 */
	public abstract E zero();
	/**
	 * Abstract method for getting absolute Value of the matrix element
	 * @param o
	 * @return absolute Value for o
	 */
	public abstract E abs(E o);
	/**
	 * Abstract method for Calculating -1 to the passed integer power
	 * @param power
	 * @return a <code>Complex</code> which is (-1)^power
	 */
	public abstract E powOfMinusOne(int power);
	/**
	 * Abstract method for comparing two matrix elements
	 * @param o1
	 * @param o2
	 * @return -1 if o1 is smaller than o2, 1 if o1 is greater than o2, 0 otherwise
	 */
	public abstract int compare(E o1, E o2);
	/**
	 * Abstract method for Constructing a new <code>GenericMatrix</code> object with the input row&column
	 * whose elements are all zero
	 * @param row the number of rows of the matrix 
	 * @param column the number of columns of the matrix
	 * @return a new <code>GenericMatrix</code> whose elements are all zero
	 */
	public abstract GenericMatrix<E> zeros(int row, int column);
	/**
	 * Abstract method for Constructing a new identity <code>GenericMatrix</code> object with the input row
	 * @param row the number of rows(also columns) of the matrix
	 * @return a new identity <code>GenericMatrix</code>
	 */
	public abstract GenericMatrix<E> eye(int row);
	/**
	 * Abstract method for Constructing a new <code>GenericMatrix</code> object copied from this
	 * @return a new <code>GenericMatrix</code> copied from this
	 */
	public abstract GenericMatrix<E> getCopy();
	/**
	 * Add values in row1 and row2 of the current <code>GenericMatrix</code>
	 * @param row1 the summand row index
	 * @param row2 the addend row index
	 * @param times
	 * @return the <code>GenericMatrix</code>
	 */
	public GenericMatrix<E> addRow(int row1, int row2, E times) {
		for (int i = 0; i < getColumn(); i++) {
			setValue(row1, i, add(getValue(row1, i), multiply(times, getValue(row2, i))));
		}
		return this;
	}
	/**
	 * Subtract values in row2 of the current <code>GenericMatrix</code> from values in row1
	 * @param row1 the subtractor row index
	 * @param row2 the Subtrahend row index
	 * @param times
	 * @return the <code>GenericMatrix</code>
	 */
	public GenericMatrix<E> subtractRow(int row1, int row2, E times) {
		for (int i = 0; i < getColumn(); i++) {
			setValue(row1, i, subtract(getValue(row1, i), multiply(times, getValue(row2, i))));
		}
		return this;
	}
	/**
	 * Multiply values in row of the current <code>GenericMatrix</code> by multiplicand
	 * @param row the row index
	 * @param multiplicand
	 * @return the <code>GenericMatrix</code>
	 */
	public GenericMatrix<E> multiplyRow(int row, E multiplicand) {
		for (int i = 0; i < getColumn(); i++) {
			setValue(row, i, multiply(getValue(row, i), multiplicand));
		}
		return this;
	}
	/**
	 * Divide values in row of the current <code>GenericMatrix</code> by dividend
	 * @param row the row index
	 * @param dividend
	 * @return the <code>GenericMatrix</code>
	 */
	public GenericMatrix<E> divideRow(int row, E dividend) {
		for (int i = 0; i < getColumn(); i++) {
			setValue(row, i, divide(getValue(row, i), dividend));
		}
		return this;
	}
	/**
	 * Commute two rows
	 * @param row1
	 * @param row2
	 * @return the <code>GenericMatrix</code> after commutation
	 */
	public GenericMatrix<E> commuteRow(int row1, int row2) {
		if (row1 == row2)
			return this;
		
		for (int i = 0; i < getColumn(); i++) {
			E temp = getValue(row1, i);
			setValue(row1, i, getValue(row2, i));
			setValue(row2, i, temp);
		}
		return this;
	}
	/**
	 * Add another <code>GenericMatrix</code> to the current <code>GenericMatrix</code>
	 * @param anotherMatrix
	 * @return a new <code>GenericMatrix</code> which has been added
	 */
	public GenericMatrix<E> add(GenericMatrix<E> anotherMatrix) {
		// Check bounds of the two matrices
		if (row != anotherMatrix.getRow() || column != anotherMatrix.getColumn())
			throw new RuntimeException("The matrices do not have the same size.");
		
		GenericMatrix<E> result = zeros(row, column);  // Create result matrix
				
		// Perform addition
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				result.setValue(i, j, add(getValue(i, j), anotherMatrix.getValue(i, j)));
		
		return result;
	}
	/**
	 * Add another <code>GenericMatrix</code> to the current <code>GenericMatrix</code>
	 * @param anotherMatrix
	 * @return this which has been added
	 */
	public GenericMatrix<E> addEquals(GenericMatrix<E> anotherMatrix) {
		// Check bounds of the two matrices
		if (row != anotherMatrix.getRow() || column != anotherMatrix.getColumn())
			throw new RuntimeException("The matrices do not have the same size.");
		
		// Perform addition
		for (int i = 0; i < row; i++)
			for (int j = 0; j < anotherMatrix.getColumn(); j++)
				setValue(i, j, add(getValue(i, j), anotherMatrix.getValue(i, j)));
		
		return this;
	}
	/**
	 * Subtract another <code>GenericMatrix</code> from the current <code>GenericMatrix</code>
	 * @param anotherMatrix
	 * @return a new <code>GenericMatrix</code> which has been subtracted from
	 */
	public GenericMatrix<E> subtract(GenericMatrix<E> anotherMatrix) {
		// Check bounds of the two matrices
		if (row != anotherMatrix.getRow() || column != anotherMatrix.getColumn())
			throw new RuntimeException("The matrices do not have the same size.");
		
		GenericMatrix<E> result = zeros(row, column);  // Create result matrix
				
		// Perform addition
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				result.setValue(i, j, subtract(getValue(i, j), anotherMatrix.getValue(i, j)));
		
		return result;
	}
	/**
	 * Subtract another <code>GenericMatrix</code> from the current <code>GenericMatrix</code>
	 * @param anotherMatrix
	 * @return this which has been subtracted from
	 */
	public GenericMatrix<E> subtractEquals(GenericMatrix<E> anotherMatrix) {
		// Check bounds of the two matrices
		if (row != anotherMatrix.getRow() || column != anotherMatrix.getColumn())
			throw new RuntimeException("The matrices do not have the same size.");
				
		// Perform addition
		for (int i = 0; i < column; i++)
			for (int j = 0; j < anotherMatrix.getColumn(); j++)
				setValue(i, j, subtract(getValue(i, j), anotherMatrix.getValue(i, j)));
				
		return this;
	}
	/**
	 * Multiply another <code>GenericMatrix</code> to the current <code>GenericMatrix</code>
	 * @param anotherMatrix
	 * @return a new <code>GenericMatrix</code> which has been multiplied
	 */
	public GenericMatrix<E> multiply(GenericMatrix<E> anotherMatrix) {
		// Check bounds of the two matrices
		if (getColumn() != anotherMatrix.getRow())
			throw new RuntimeException("The matrices do not have compatible size.");
		
		GenericMatrix<E> result = zeros(row, anotherMatrix.getColumn()); // Create result matrix
		
		// Perform scalar product
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < anotherMatrix.getColumn(); j++) {
				for (int k = 0; k < column; k++) {
					result.setValue(i, j, add(result.getValue(i, j), multiply(
							getValue(i, k), anotherMatrix.getValue(k, j))));
				}
			}
		}
		
		return result;
	}
	/**
	 * Multiply another <code>GenericMatrix</code> to the current <code>GenericMatrix</code>
	 * @param anotherMatrix
	 * @return this which has been multiplied
	 */
	public GenericMatrix<E> multiplyEquals(GenericMatrix<E> anotherMatrix) {
		// Check bounds of the two matrices
		if (column != anotherMatrix.getRow())
			throw new RuntimeException("The matrices do not have compatible size.");
		
		// Perform scalar product
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < anotherMatrix.getColumn(); j++) {
				setValue(i, j, zero());
					
				for (int k = 0; k <column; k++) {
					setValue(i, j, add(getValue(i, j), multiply(getValue(i, k), anotherMatrix.getValue(k, j))));
				}
			}
		}
		
		return this;
	}
	/**
	 * Get the complement minor of the current <code>GenericMatrix</code>
	 * @param row the row index
	 * @param column the column index
	 * @return the complement minor of the matrix
	 */
	public GenericMatrix<E> getComplementMinor(int row, int column) {
		GenericMatrix<E> complementMinor = zeros(this.row - 1, this.column - 1);
		for (int i = 0; i < complementMinor.getRow(); i++) {
			for (int j = 0; j < complementMinor.getColumn(); j++) {
				if (i < row && j < column) // Numbers at the top left-hand corner
					complementMinor.setValue(i, j, getValue(i, j));
				else if (i < row && j >= column) // Numbers at the top right-hand corner
					complementMinor.setValue(i, j, getValue(i, j + 1));
				else if (i >= row && j < column) // Numbers at the bottom left-hand corner
					complementMinor.setValue(i, j, getValue(i + 1, j));
				else if (i >= row && j >= column) // Numbers at the bottom right-hand corner
					complementMinor.setValue(i, j, getValue(i + 1, j + 1));
			}
		}
		
		return complementMinor;
	}
	/**
	 * Get the adjoint matrix of the current <code>GenericMatrix</code>
	 * @return the adjoint matrix of the current generic matrix
	 */
	public GenericMatrix<E> getAdjointMatrix() {
		GenericMatrix<E> adjointMatrix = zeros(row, column);
		
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				adjointMatrix.setValue(j, i, getComplementMinor(i, j).getDeterminant());
		
		return adjointMatrix;
	}
	/**
	 * Get the determinant of the current <code>GenericMatrix</code> by tail recursion
	 * @return the determinant of the current <code>GenericMatrix</code>
	 */
	public E getDeterminant() {
		E result = zero();
		
		if (row > 2)
			for (int i = 0; i < column; i++)
				result = add(result, multiply(multiply(
						getValue(0, i), getComplementMinor(0, i).getDeterminant()), powOfMinusOne(i)));
		else if (row == 2)
			result = subtract(multiply(getValue(0, 0),getValue(1, 1)), 
					multiply(getValue(0, 1), getValue(1, 0)));
		else
			result = getValue(0, 0);
		
		return result;
	}
	/**
	 * Transpose the current <code>GenericMatrix</code>
	 * @return the transposition of the matrix
	 */
	public GenericMatrix<E> transpose() {
		GenericMatrix<E> transpose = zeros(column, row);
		
		for (int i = 0; i < transpose.getRow(); i++) {
			for (int j = 0; j <= i; j++) {
				if (i != j) {
					transpose.setValue(i, j, getValue(j, i));
					transpose.setValue(j, i, getValue(i, j));
				}
				else
					transpose.setValue(i, j, getValue(i, j));
			}
		}
		
		return transpose;
	}
	/**
	 * Get the upper triangular matrix of the current <code>GenericMatrix</code>
	 * @return the upper triangular matrix of the current generic matrix
	 * @warn if the <code>GenericMatrix</code> is specified by integer, it may lose precision!
	 */
	public GenericMatrix<E> getUpperTriangularMatrix() {
		// Copy this to temporary to keep this from modifying
		GenericMatrix<E> upperTriangularMatrix = getCopy();
		
		for (int i = 0; i < row; i++) {
			E max = getValue(i, i);
			int currentRow = i; // The row where max is
			for (int k = 1; k < row - i; k++) {
				// If absolute value of an element in the same column is greater than what in current row,
				if (compare(abs(upperTriangularMatrix.getValue(k, i)),abs(max)) > 0) {
					max = getValue(k, i); // Update max
					currentRow = k; // Update current row
				}
			}
			upperTriangularMatrix.commuteRow(i, currentRow); // Commute the two rows
			for (int j = 0; j <= i; j++) {
				if (j < i) { // Turn elements that are not on the diagonal to zero
					upperTriangularMatrix.subtractRow(i, j, upperTriangularMatrix.getValue(i, j));
				}
				else { // Turn elements on the diagonal to one
					if (compare(upperTriangularMatrix.getValue(i, i), zero()) != 0)
						upperTriangularMatrix.divideRow(i, upperTriangularMatrix.getValue(i, i));
					else
						return upperTriangularMatrix;
				}
			}
		}
		
		return upperTriangularMatrix;
	}
	/**
	 * Get the rank of the current <code>GenericMatrix</code>
	 * @return the rank of the current generic matrix
	 */
	public int getRank() {
		// Copy this to temporary to keep this from modifying
		GenericMatrix<E> upperTriangularMatrix = getUpperTriangularMatrix();
		
		for (int i = 0; i < row; i++) // Find the first row whose element on the diagonal is zero
			if (compare(upperTriangularMatrix.getValue(i, i), zero()) == 0)
				return i;
		
		return Math.min(row, column);
	}
	/**
	 * Check if the rank of the current <code>GenericMatrix</code> is full
	 * @return true if the rank of the current generic matrix is full, false otherwise
	 */
	public boolean isFullRank() {
		return Math.min(row, column) == getRank();
	}
	/**
	 * Get the inversion of the current <code>GenericMatrix</code>
	 * @return the inversion of the current generic matrix
	 * @warn if the <code>GenericMatrix</code> is specified by integer, it may lose precision!
	 */
	public GenericMatrix<E> inverse() {
		// Check bounds of the two matrices
		if (row != column)
			throw new RuntimeException("The matrices do not have compatible size.");
		// Check if rank of matrix is full
		if (!isFullRank())
			throw new RuntimeException("The matrix is not an non-singular matrix.");
		
		GenericMatrix<E> temp = getCopy();
		GenericMatrix<E> inversion = eye(row); // Create identity matrix
		
		//The initial matrix -> upper triangular matrix
		for (int i = 0; i < row; i++) {
			E max = temp.getValue(i, i);
			int currentRow = i; // The row where max is
			for (int k = 1; k < row - i; k++) {
				// If element in the same column is greater than what in current row && the element is positive,
				// commute the two rows
				if (compare(abs(temp.getValue(k, i)),abs(max)) > 0) {
					max = temp.getValue(k, i); // Update max
					currentRow = k; // Update current row
				}
			}
			temp.commuteRow(i, currentRow); 
			for (int j = 0; j <= i; j++) {
				if (j < i) {
					inversion.subtractRow(i, j, temp.getValue(i, j));
					temp.subtractRow(i, j, temp.getValue(i, j));
				}
				else {
					inversion.divideRow(i, temp.getValue(i, i));
					temp.divideRow(i, temp.getValue(i, i));
				}
			}
		}
		// upper triangular matrix -> identity matrix
		for (int i = row - 2; i >= 0; i--) {
			for (int j = column - 1; j > i; j--) {
				inversion.subtractRow(i, j, temp.getValue(i, j));
				temp.subtractRow(i, j, temp.getValue(i, j));
			}
		}
						
		return inversion;
	}
	/**
	 * Print the matrices, the operator, and their operation result
	 * @param anotherMatrix
	 * @param result
	 * @param op their operation result
	 */
	public void printResult(GenericMatrix<E> anotherMatrix, GenericMatrix<E> result, char op) { 
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++)
				System.out.print(getValue(i, j) + "\t");
		
		if (i == row / 2)
			System.out.print(op + "\t");
		else
			System.out.print("\t");
		
		for (int j = 0; j < anotherMatrix.getRow(); j++)
			System.out.print(anotherMatrix.getValue(i, j) + "\t");
		
		if (i == row / 2)
			System.out.print("=\t");
		else
			System.out.print("\t");
		
		for (int j = 0; j < result.getRow(); j++)
			System.out.print(result.getValue(i, j) + "\t");
		
		System.out.println();
		}
	}
	
	@Override
	public String toString() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(getValue(i, j) + "\t");
			}
			System.out.println();
		}
		return "";
	}

}
