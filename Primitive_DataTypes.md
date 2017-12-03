## Primitive Data types in Java
There are mainly two types of programming languages are present.
1. **Dynamically Typed:** These languages where each variable & expression type is no need to known at compile time. 
This means these languages can receive different data types over the time.<br />
```Example: Ruby, Python```
2. **Statically Typed"** These are where each variable is declared to be certain data type before compilation of a class.<br />
```Example: Java, C, C++``` <br />
So Java is Statically typed language, that means every variable & expression should declared to be certain data type we before we use in a class.
Java has two catagories of data types
- **Primitive Data types** (ex: Integer, character...etc)
- **Referenced or Object Data types** (ex: Strings, Arrays, Class Objects, User defined types) <br />
let us know about Primitive Data types now.
Primitive data are only single values; they have no special capabilities. There are 8 primitive data types in Java.<br />

| Type        | Size          | Default |
| ------------- |:-------------:| -----:|
| byte      | 8 bits   |   0 |
| short | 16 bits | 0 | 
| int | 32 bits   |   0 |
| long | 64 bits   |  0l |
| float  | 32 bit | 0.0f | 
| double | 64 bit | 0.0d | 
| char | 16 bits   | \u0000 |
| boolean    | 1 bit | false | 

### Binary representation in a memory
1. **Positve Numbers Representation**
        For an Example ```int a = 9;``` in memory value of 'a' that is 9 stored in binary format, assume a address is @1000 in memory and size of ```int``` is 4 Bytes in java.<br />
 ```00000000.00000000.00000000.00001001```
 
2. **Negative Numbers Representation**
       All negative numbers are 2's compliment of +ve numbers. For an Example ```int a = -9;``` assume a address is @2000 in memory and size of ```int``` is 4 Bytes in java.
 ```
 Step1: Convert positive number into binary i.e, 
 a = 9:  00000000.00000000.00000000.00001001
 Step2: Apply 2's compliment, Flip all binary digits i.e,
         11111111.11111111.11111111.11110110
 Step3: Add 1 to the result i.e,
         11111111.11111111.11111111.11110110
                                           1
          ...................................
  a = -9 11111111.11111111.11111111.11110111
  
  ```
 ### Type Casting in Java
 Please remember this order we will be using this order in below examples. byte is the smallest data type and double is the biggest data type in terms of memory size. <br />
  ***byte < short < int < long < float < double.*** 
  
There are two type of casting are present. 
1. **Auto Widening :** When you are converting data from small sized data type to big sized data type, i.e when you are converting data from left-placed data type to right-placed data type in the above order, auto widening will be used. For example, when you are converting byte to short or short to int, auto widening will be used.
```java
package com.java.deeplearning;
/@ author 
  Krishnakanth Yachareni
class AutoWidening {
	public static void main(String[] args) {
	  byte a = 10;
		short b = a; // byte is auto widened to short
		int c = b; // short is auto widened to int
		long d = c; // int is auto widened to long
		float e = d; // long is auto widened to float
		double f = e; // float is auto widened to double
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
	}
}
```
output
```
10
10
10
10
10.0
10.0

```
2. **Explicit Narrowing :** When you are converting data from big sized data type to small sized data type, i.e when you are converting data from right-placed data type to left-placed data type in the above order, explicit narrowing will be used and it will leads to *data loss* For example, when you are converting double to float or float to int, explicit narrowing will be used.
```java
package com.java.deeplearning;
/*@author
Krishnakanth Yachareni */
class ExplicitNarrowing {
	public static void main(String[] args) {
	       //int is explicitly narrowed to short
	        double a = 1150.25;
	        float b = (float) a; //double is explicitly narrowed to float
	        long c = (long) b; //float is explicitly narrowed to long
	        int d = (int) c; //long is explicitly narrowed to int
	        short e = (short) d; //int is explicitly narrowed to short
	        byte f = (byte) e;  //short is explicitly narrowed to byte
	        System.out.println(a);
	        System.out.println(b);
	        System.out.println(c);
	        System.out.println(d);
	        System.out.println(e);
	        System.out.println(f);
	}
}
```
Output
```
1150.25
1150.25
1150
1150
1150
126
```
Let us discuss each and every data type in brief.
### 1. byte 
The byte data type is an 8-bit signed two’s complement integer.The byte data type is useful for saving memory in large arrays.
- Size: 8-bit
- Range: -128 to 127
1. ***Example***     
```java
package com.java.deeplearning;

/* @author
Krishnakanth Yacahreni */
public class ByteExample {
	public static void main(String[] args) {

		byte i = 12;
		// byte is 8 bit value
		System.out.println(i); // 12

		byte j = 128; // compiler error
		byte k = -129;// compiler error
		// It overflows here because byte range is -128 to 127.

		byte l = 127;
		l++;
		System.out.println(l); // -128
		// Looping back within the range 127 to -128

		byte m = -128;
		m--;
		System.out.println(m); // 127
		// Looping back within the range -128 to 127
	}

}
```
2. Example
```java
package com.java.deeplearning;
/* @author
Krishnakanth Yacahreni */
public class ByteExample {
	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		byte c = a + b; //Compiler error Line1
		System.out.println(c);
		
		final byte d = 10;
		final byte e = 20;
		byte f = d + e; //3  Line2
		System.out.println(c);
		
		byte f = 10;
		byte g = 20;
		f+=g;
		g++ // Line2
		System.out.println(f); // 30
		System.out.println(g); // 21

	}

}
```
```byte f = d + e; // d and e are declared final ```
Here, since d and e are declared ```final``` so the value of expression on the ```RHS``` is known at compile time, which is fixed at (10 + 20 = 30) and cannot vary. So, you don't need to typecast it explicitly.

```byte c = a + b; // a and b are not declared final ```
Whereas, in this case, value of a and b are not declared ```final```. So, the value of expression is not known at compile time, rather is evaluated at runtime. So, you need to do an explicit cast.

```f+=g;``` and ```g++``` implicitly cast the result back to the type of ```f and g```.
So if ```g``` is a ```byte```, then ```g++``` is also ```byte```; is not equivalent to ```g = g + 1```; - it's actually equivalent to ```g = (byte)(g + 1);```

**promotion** is when operands are of different types, automatic binary numeric promotion occurs with the smaller operand type being converted to the larger.Here are the Type Promotion Rules:
1. All ```byte``` and ```short``` values are promoted to ```int```.
2. If one operand is a ```long```, the whole expression is promoted to ```long```.
3. If one operand is a ```float```, the entire expression is promoted to ```float```.
4. If any of the operands is ```double```, the result is ```double```.

### 2. short
The short data type is a 16-bit signed two’s complement integer. Similar to byte, use a short to save memory in large arrays, in situations where the memory savings actually matters.
- Size: 16 bit
- Value: -32,768 to 32,767

Example
```
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni
 */
public class ShortExample {
	public static void main(String[] args) {
		short a = 10;
		short b = 20;
		short c = (short) (a + b); //Only for byte and short require explicit type casting is require for their types.
		System.out.println(c); // 30 
	}

}
```
### 3.int
It is a 32-bit signed two’s complement integer.
- Size: 32 bit
- Value: -231 to 231-1
**Note**: In Java SE 8 and later, we can use the int data type to represent an unsigned 32-bit integer, which has value in range [0, 232-1]. Use the Integer class to use int data type as an unsigned integer.

1. Example
```java
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni 
 */
public class IntegerExample {
	public static void main(String[] args) {
		int a = 31;  //Integer
		int b = 0x31; // Hexa decimal format
		int c = 031; // Octal Format
		int d = 0b1001; //Binary format
		int e = a + a; // for int type no casting is require
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}
}
```
Output

```
31
49
25
9
62
```
2. Example
```java
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni 
 */
public class IntegerExample {
	public static void main(String[] args) {
		int a = 31; //Primitive Type
		Integer b = new Integer(31); //Objective Type
		System.out.println(a == b); // true
		System.out.println(b.hashCode()); //31 (returns value not hash code)
		System.out.println(a.hashCode()); 
		/*Compiler error bcz hashcode is only 
		for primitive types */
	}
}

```
### 4. long
The long data type is a 64-bit two’s complement integer.
- Size: 64 bit
- Value: -263 to 263-1.
Note: In Java SE 8 and later, you can use the long data type to represent an unsigned 64-bit long, which has a minimum value of 0 and a maximum value of 264-1. The Long class also contains methods like compareUnsigned, divideUnsigned etc to support arithmetic operations for unsigned long.
```java
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni 
 */
public class LongExample {
	public static void main(String[] args) {
		long a=109876677777l;
 		long b=20666677766l;
 		long c=a+b; // above Integere no type casting is require
		System.out.println(c);
	}
}
```
#### NOTE
1. Big numbers are difficult to read. If we have a number like **245342395423452**, we find it difficult to read it quickly. Outside computers, big numbers are separated by spaces or commas. Since Java SE 1.7, it is possible to separate integers with an underscore.

The underscore cannot be used at the beginning or end of a number, adjacent to a decimal point in a floating point literal, and prior to an F or L suffix.
```java
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni 
 */
public class LongExample {
	public static void main(String[] args) {
		long a = 23482345629L;
        	long b = 23_482_345_629L; // More readble format
		System.out.println(a == b); //true
	}
}
```
2. Java ```byte```, ```short```, ```int``` and ```long``` types are used do represent fixed precision numbers. This means that they can represent a limited amount of integers. The largest integer number that a long type can represent is **9223372036854775807**. If we deal with even larger numbers, we have to use the ```java.math.BigInteger``` class. It is used to represent immutable arbitrary precision integers. Arbitrary precision integers are only limited by the amount of computer memory available.
```java
package com.java.deeplearning;
import java.math.BigInteger;
/* @author
 * Krishnakanth Yachareni 
 */
public class LongExample {
	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE); // Max value of Long

		BigInteger b = new BigInteger("92233720368547758071");
		BigInteger c = new BigInteger("52498235605326345645");

		BigInteger a = b.multiply(c); //operators cannot apply for math integres,double..etc.

		System.out.println(a);
	}
}
```
Output
```
9223372036854775807
4842107582663807707870321673775984450795
```
### 5. float
The float data type is a single-precision 32-bit IEEE 754 floating point. Use a float (instead of double) if you need to save memory in large arrays of floating point numbers.
- Size: 32 bits
- Value: 1.4e-45 to 3.4e38
- Suffix : F/f
```java
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni 
 */
public class FloatExample {
	public static void main(String[] args) {
		float a=231231.0031f;
 		float b= 53423423434.43231f;
		float c= a+a; 
		System.out.println(c); //5.3423653E10
	}
}
```
### 6. double
The double data type is a double-precision 64-bit IEEE 754 floating point. For decimal values, this data type is generally the default choice.Both float and double data types were designed especially for scientific calculations, where approximation errors are acceptable.
- Size: 64 bits
- Value: 4.9e-324 to 1.8e308
- Suffix : D/d
```java
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni 
 */
public class DoubleExample {
	public static void main(String[] args) {
		double a=231231.0031f;
 		double b= 53423423434.43231f; 
		double c= a+b; 
		System.out.println(c); //5.342365466543541E10
	}
}
```
#### NOTE
```java
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni 
 */
public class DoubleExample {
	public static void main(String[] args) {
		 double a = 0.1 + 0.1 + 0.1;
       		 double b = 0.3;
        
        	System.out.println(a);
        	System.out.println(b);
        	System.out.println(a == b);  //false
	}
} 

```
Output

```
0.30000000000000004
0.3
false
```
There is a small margin error. Therefore, the comparison operator returns a boolean false.When we work with money, currency, and generally in business applications, we need to work with precise numbers. The rounding errors of the basic floating point types are not acceptable.
2. When we work with money, currency, and generally in business applications, we need to work with precise numbers. The rounding errors of the basic floating point types are not acceptable.
```java
package com.java.deeplearning;
import java.math.BigDecimal;
/* @author
 * Krishnakanth Yachareni 
 */
public class DoubleExample {
	public static void main(String[] args) {
		System.out.println(Double.MAX_VALUE);

		BigDecimal b = new BigDecimal("1.7976931348623157E308");
		BigDecimal c = new BigDecimal("52498235605326345645");

		BigDecimal a = b.multiply(c);

		System.out.println(a);
	}
}
```
Output

```
1.7976931348623157E308
9.43757177400795581800992129033101265E+327
```
### 7. char
The char data type is a single 16-bit Unicode character. A char is a single character.
- Size: 16 bits
- Value: 0 to 65,535
1. Eample
```java
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni 
 */
public class CharExample {
	public static void main(String[] args) {
		char a = 'a';
		char b = (char)97;
		System.out.println(a); // a
		System.out.println(b); // a
		System.out.println((int) a); // ASCII value of a is 97
	}
}
```
2. Example
```java
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni 
 */
public class CharExample {
	public static void main(String[] args) {
		char x = 'a';
		char y = x + 5; //Compiler Error
		
		final char l = 'a';
		char m = l + 5;
		System.out.println(m); //f     Bcz a ASCII value is 97+5 = 102, so 102 is f
	}
}
```
In this case, the char values are promoted to int values.Here
```
char x = 'a';
char y = x + 5;
```
because ```x``` is not a constant expression, the compiler cannot determine if the value of ```x + 5``` which is an ```int``` will be able to fit in a ```char```.
In this
```
final char l = 'a';
char m = l + 5;
```
where ```l``` is a constant expression, the compiler can determine that the value of ```l```, which is ```97```, added to ```5```, which is ```102``` does fit in a ```char```. Because of this guarantee, Java can safely perform a narrowing conversion from ```int``` to ```char```.
###  8. boolean
boolean data type represents only one bit of information either true or false . Values of type boolean are not converted implicitly or explicitly (with casts) to any other type. But the programmer can easily write conversion code.The result of conditional operator is boolean values.
- Size: 1 bit
- Value: true or false
```java
package com.java.deeplearning;
/* @author
 * Krishnakanth Yachareni 
 */
public class BooleanExample {
	public static void main(String[] args) {
		boolean a = false;
		System.out.println(b); //false
	}
}
```
### References
1. [Oracle Document JavaSE](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
2. [Geeks for Geeks](http://www.geeksforgeeks.org/data-types-in-java/)

***Thank you all*** Happy Learning :blush:
