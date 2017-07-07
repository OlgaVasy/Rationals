package com.cooksys.ftd.assignments.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SimplifiedRational implements IRational {
	
	public int a;
	public int b;
    /**
     * Determines the greatest common denominator for the given values
     *
     * @param a the first value to consider
     * @param b the second value to consider
     * @return the greatest common denominator, or shared factor, of `a` and `b`
     * @throws IllegalArgumentException if a <= 0 or b < 0
     */
    public static int gcd(int a, int b) throws IllegalArgumentException {
        
    	if (a<=0 || b<0)
    		throw new IllegalArgumentException("a<=0 or b<0");
    	
    	return gcd(b,a%b);
    }

    /**
     * Simplifies the numerator and denominator of a rational value.
     * <p>
     * For example:
     * `simplify(10, 100) = [1, 10]`
     * or:
     * `simplify(0, 10) = [0, 1]`
     *
     * @param numerator   the numerator of the rational value to simplify
     * @param denominator the denominator of the rational value to simplify
     * @return a two element array representation of the simplified numerator and denominator
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
       
    	if (denominator==0)
    		throw new IllegalArgumentException("denominator is 0");
    	
    	int[]array = new int[2];
    	
    	array[0] = numerator/gcd(numerator,denominator);
    	array[1]=denominator/gcd(numerator,denominator);    
    	
    	return array;    	
    	
    }

    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * Simplification of numerator/denominator pair should occur in this method.
     * If the numerator is zero, no further simplification can be performed
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
        
    	if (denominator==0)
    		throw new IllegalArgumentException("The denominator is 0");
    	
    	int[]array = new int[2];
    	array = simplify(numerator,denominator);
    	
    	this.a=array[0];
    	this.b=array[1];
    	
    	//Rational r = new Rational(array[0],array[1]);	
    	
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
        
    	return this.a;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
        
    	return this.b;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator   the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value (specifically, a SimplifiedRational value)
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
    	
    	if (getNumerator()>0 && getDenominator()>0)
    		return getNumerator()+"/"+ getDenominator();
    	else if (getNumerator()<0 && getDenominator()<0)
    		return Math.abs(getNumerator())+"/"+ Math.abs(getDenominator());
    	else return "-" + Math.abs(getNumerator())+"/"+ Math.abs(getDenominator());
       
    }
}