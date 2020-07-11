package matrix;

import java.math.BigInteger;

public class TestMatrix {
	final static Rational MINUS_NINE = new Rational(new BigInteger("-9"), BigInteger.ONE);
	final static Rational MINUS_TWO= new Rational(new BigInteger("-2"), BigInteger.ONE);
	final static Rational MINUS_ONE = new Rational(new BigInteger("-1"), BigInteger.ONE);
	final static Rational ONE = new Rational(BigInteger.ONE, BigInteger.ONE);
	final static Rational TWO = new Rational(new BigInteger("2"), BigInteger.ONE);
	final static Rational THREE = new Rational(new BigInteger("3"), BigInteger.ONE);
	final static Rational FOUR = new Rational(new BigInteger("4"), BigInteger.ONE);
	final static Rational FIVE = new Rational(new BigInteger("5"), BigInteger.ONE);
	final static Rational SEVEN = new Rational(new BigInteger("7"), BigInteger.ONE);
	final static Rational EIGHT = new Rational(new BigInteger("8"), BigInteger.ONE);
	
	static Integer[][] matrix1 = new Integer[][] {{4, 1, 2, 3}, {3, 4, 1, 2}, {2, 3, 4, 1}, {1, 2, 3, 4}};
	static Integer[][] matrix2 = new Integer[][] {{1, -1, 5, -1}, {1, 1, -2, 3}, {3, -1, 8, 1}, 
		{1, 3, -9, 7}};
	static Double[][] matrix3 = new Double[][] {{4.0, 1.0, 2.0, 3.0}, {3.0, 4.0, 1.0, 2.0}, 
		{2.0, 3.0, 4.0, 1.0}, {1.0, 2.0, 3.0, 4.0}};
	static Double[][] matrix4 = new Double[][] {{1.0, -1.0, 5.0, -1.0}, {1.0, 1.0, -2.0, 3.0}, 
			{3.0, -1.0, 8.0, 1.0}, {1.0, 3.0, -9.0, 7.0}};
	static Rational[][] matrix5 = new Rational[][] {{FOUR, ONE, TWO, THREE}, {THREE, FOUR, ONE, TWO}, 
		{TWO, THREE, FOUR, ONE}, {ONE, TWO, THREE, FOUR}};
	static Rational[][] matrix6 = new Rational[][] {{ONE, MINUS_ONE, FIVE, MINUS_ONE}, 
		{ONE, ONE, MINUS_TWO, THREE}, {THREE, MINUS_ONE, EIGHT, ONE}, {ONE, THREE, MINUS_NINE, SEVEN}};
	
	static GenericMatrix<Integer> integerMatrix1 = new IntegerMatrix(matrix1);
	static GenericMatrix<Integer> integerMatrix2 = new IntegerMatrix(matrix2);
	static GenericMatrix<Double> doubleMatrix1 = new DoubleMatrix(matrix3);
	static GenericMatrix<Double> doubleMatrix2 = new DoubleMatrix(matrix4);
	static GenericMatrix<Rational> rationalMatrix1 = new RationalMatrix(matrix5);
	static GenericMatrix<Rational> rationalMatrix2 = new RationalMatrix(matrix6);

	public static void main(String[] args) {
		testMultiply();
		testDeterminant();
		testGetRank();
		testInverse();

	}
	
	public static void testMultiply() {
		System.out.println("matrix1 * matrix2 is: ");
		integerMatrix1.printResult(integerMatrix2, integerMatrix1.multiply(integerMatrix2), '*');
		System.out.println("matrix3 * matrix4 is: ");
		doubleMatrix1.printResult(doubleMatrix2, doubleMatrix1.multiply(doubleMatrix2), '*');
		System.out.println("matrix5 * matrix6 is: ");
		rationalMatrix1.printResult(rationalMatrix2, rationalMatrix1.multiply(rationalMatrix2), '*');
	}
	
	public static void testDeterminant() {
		System.out.println("The determinant of the integer matrix is " + integerMatrix1.getDeterminant());
		System.out.println("The determinant of the double matrix is " + doubleMatrix1.getDeterminant());
		System.out.println("The determinant of the rational matrix is " + rationalMatrix1.getDeterminant());
	}
	
	public static void testGetRank() {
		System.out.println("Rank of the integer matrix is " + integerMatrix1.getRank());
		System.out.println("Rank of the double matrix is " + doubleMatrix1.getRank());
		System.out.println("Rank of the rational matrix is " + rationalMatrix1.getRank());
	}
	
	public static void testInverse() {
		System.out.println("Inversion of the integer matrix is:");
		System.out.println(integerMatrix1.inverse());
		System.out.println("Inversion of the double matrix is:");
		System.out.println(doubleMatrix1.inverse());
		System.out.println("Inversion of the rational matrix is:");
		System.out.println(rationalMatrix1.inverse());
	}

}
