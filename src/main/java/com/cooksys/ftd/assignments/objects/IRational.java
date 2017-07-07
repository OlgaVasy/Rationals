package com.cooksys.ftd.assignments.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

interface IRational {	
	
	
    /**
     * @return the numerator of this rational number
     */
    int getNumerator();    
   

    /**
     * @return the denominator of this rational number
     */
    int getDenominator();

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator   the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    IRational construct(int numerator, int denominator) throws IllegalArgumentException;    	
   

    /**
     * negation of rational values
     * <p>
     * definition:
     * `negate(n / d) = -n / d`
     *
     * @return the negation of this
     */
    default IRational negate() {       
        
        return construct((-1)*getNumerator(), getDenominator());       
    }

    /**
     * inversion of rational values
     * <p>
     * definition:
     * `invert(n / d) = d / n`
     *
     * @return the inversion of this
     * @throws IllegalStateException if the numerator of this rational value is 0
     */
    default IRational invert() throws IllegalStateException {       
    	
    	if (getNumerator()==0)
    		throw new IllegalStateException("The numerator cannot be equal to 0");
    	
    	return construct(getDenominator(),getNumerator());    	
    	
    }

    /**
     * addition of rational values
     * <p>
     * definition:
     * `(n1 / d1) + (n2 / d2) = ((n1 * d2) + (n2 * d1)) / (d1 * d2)`
     *
     * @param that the value to add to this
     * @return the sum of this and that
     * @throws IllegalArgumentException if that is null
     */
    default IRational add(IRational that) throws IllegalArgumentException {    	    	
    	
    	if (that==null)
        throw new IllegalArgumentException("The sum is null");
    	
    	int numerator1=this.getNumerator();
    	int numerator2=that.getNumerator();
    	int denominator1=this.getDenominator();
    	int denominator2=that.getDenominator();  
    	
    	int numeratorNew = (numerator1*denominator2)+(numerator2*denominator1);
    	int denominatorNew = denominator1 * denominator2;   	
    	
    	
    	return construct(numeratorNew, denominatorNew);    	
    
    }

    /**
     * subtraction of rational values
     * <p>
     * definition:
     * `(n1 / d1) - (n2 / d2) = ((n1 * d2) - (n2 * d1)) / (d1 * d2)`
     *
     * @param that the value to subtract from this
     * @return the difference between this and that
     * @throws IllegalArgumentException if that is null
     */
    default IRational sub(IRational that) throws IllegalArgumentException {
    	
    	if (that==null)
            throw new IllegalArgumentException("The sum is null");
    	
    	int numerator1=this.getNumerator();
    	int numerator2=that.getNumerator();
    	int denominator1=this.getDenominator();
    	int denominator2=that.getDenominator();  
    	
    	int numeratorNew = (numerator1*denominator2)-(numerator2*denominator1);
    	int denominatorNew = denominator1 * denominator2;
    	
    	return construct(numeratorNew, denominatorNew);    	
     
    }

    /**
     * multiplication of rational values
     * <p>
     * definition:
     * `(n1 / d1) * (n2 / d2) = (n1 * n2) / (d1 * d2)`
     *
     * @param that the value to multiply this by
     * @return the product of this and that
     * @throws IllegalArgumentException if that is null
     */
    default IRational mul(IRational that) throws IllegalArgumentException {
    	
    	if (that==null)
            throw new IllegalArgumentException("The sum is null");
    	
    	int numerator1=this.getNumerator();
    	int numerator2=that.getNumerator();
    	int denominator1=this.getDenominator();
    	int denominator2=that.getDenominator();  
    	
    	int numeratorNew = numerator1*numerator2;
    	int denominatorNew = denominator1 * denominator2;
    	
    	return construct(numeratorNew, denominatorNew);       
    }

    /**
     * division of rational values
     * <p>
     * definition:
     * `(n1 / d1) / (n2 / d2) = (n1 * d2) / (d1 * n2)`
     *
     * @param that the value to divide this by
     * @return the ratio of this to that
     * @throws IllegalArgumentException if that is null or if the numerator of that is 0
     */
    default IRational div(IRational that) throws IllegalArgumentException {
    	
    	if (that==null || that.getNumerator()==0)
            throw new IllegalArgumentException("The sum is null");
    	
    	int numerator1=this.getNumerator();
    	int numerator2=that.getNumerator();
    	int denominator1=this.getDenominator();
    	int denominator2=that.getDenominator();  
    	
    	int numeratorNew = numerator1*denominator2;
    	int denominatorNew = denominator1 * numerator2;
    	
    	return construct(numeratorNew, denominatorNew);
     
    }
}
