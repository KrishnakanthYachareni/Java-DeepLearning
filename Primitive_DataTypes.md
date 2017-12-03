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
### 1. Byte 
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


	}

}
```
```byte f = d + e; // d and e are declared final ```
Here, since d and e are declared ```final``` so the value of expression on the ```RHS``` is known at compile time, which is fixed at (10 + 20 = 30) and cannot vary. So, you don't need to typecast it explicitly.

```byte c = a + b; // a and b are not declared final ```
Whereas, in this case, value of a and b are not declared ```final```. So, the value of expression is not known at compile time, rather is evaluated at runtime. So, you need to do an explicit cast.This is called as **Promotion**.

**promotion** is when operands are of different types, automatic binary numeric promotion occurs with the smaller operand type being converted to the larger.Here are the Type Promotion Rules:
1. All byte and ```short``` values are promoted to ```int```.
2. If one operand is a ```long```, the whole expression is promoted to ```long```.
3. If one operand is a ```float```, the entire expression is promoted to ```float```.
4. If any of the operands is ```double```, the result is ```double```.

### 2. Short

