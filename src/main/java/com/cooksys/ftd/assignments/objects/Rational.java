package com.cooksys.ftd.assignments.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Rational implements IRational {
	
	public int number1;
	public int number2;
	
    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * No simplification of the numerator/denominator pair should occur in this method.
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
    	
    	if (denominator==0)
    		throw new IllegalArgumentException("The denominator cannot be equal to 0");
    	
    	this.number1=numerator;
    	this.number2=denominator;  	    	
    	
        //throw new NotImplementedException();
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
    	
    	return this.number1;
    	
        //throw new NotImplementedException();
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
    	
    	return this.number2;
       // throw new NotImplementedException();
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
    	
    	if (denominator==0)
    		throw new IllegalArgumentException("The denominator cannot be equal to 0");
    	
    	
    	//numerator=number1;
    	//number2=denominator;
    	
    	return new Rational(numerator, denominator);
    	
       // throw new NotImplementedException();
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
    	
    	Rational r ;
    	if(obj instanceof Rational){
    		r =(Rational)obj;    	
    	if (r.getNumerator()==this.getNumerator() && r.getDenominator()==this.getDenominator())
    		return true;
    	
    	}
    	return false;
       // throw new NotImplementedException();
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
    	
        //throw new NotImplementedException();
    }
}
