## What is Java ClassLoader?
Class Loaders in Java programming language provides a way to load Java classes into the memory. Which loads Java classes into memory when required. The Java class is loaded for the very first time when JVM calls ``` public static void main(String [] args)``` method present in Java class file to load at runtime. All the classes referenced by the main class are than loaded when needed.
ClassLoader"s are pre-built Java objects which exist as a part of the Java Runtime Environment (JRE). All the class loaders are sub-classes of the abstract parent class ClassLoader. 
```java
java.lang.ClassLoader
```

When we compile a Java Class, it transforms into bytecode that is store it as a **.class file** after that when we try to
use a Class, Java ClassLoader loads that class into memory.

Lets take a simple example. Everyone of us tried our best to run any program at some time and ultimately ended up in getting loads of run-time exceptions like ```ClassNotFoundException``` The main reason behind all those exceptions popping up was ClassLoader.

In Java, we have three default class loader to load class files from file system, network or any other source. Every class loader has a predefined location, from where they loads the class files.
Three class loaders are as follows:
1. **Bootstrap class loader:** Loads classes from ```JRE/lib/rt.jar```(runtime jar, contains all the classes from Core Java Libraries). It is parent of all class loaders in java.
2. **Extension class loader:** Loads classes from ```JRE/lib/ext ```or any directory denoted by java.ext.dirs
3. **System or Application class loader:** Loads classes from ```CLASSPATH``` environment variable, -classpath or -cp option, Class-Path attribute of Manifest inside JAR file.

## How does Java ClassLoader Work?

When JVM requests for a class, it invokes loadClass function of the ClassLoader by passing the fully classified name of the Class.
loadClass function calls for ```findLoadedClass()``` method to check that the class has been already loaded or not. It’s required to avoid loading the class multiple times.
If the Class is not already loaded then it will delegate the request to parent ClassLoader to load the class.
If the parent ClassLoader is not finding the Class then it will invoke ```findClass()``` method to look for the classes in the file system.First request for loading any application specific class comes to **Application class loader** which then delegated to **Extension class loader** and then finally to **Bootstrap class loader**. If **Bootstarp class loader** doesn't find the class in the ```JRE/lib/rt.jar``` then the request is again forwarded to **Extension class loader** which tries to locate the class file in ```JRE/lib/ext```. If it finds the class, it will load it otherwise request is forwarded to Application class loader which at last will load the class from CLASSPATH. This is the normal flow of class loading in Java. Two important point, we should keep in mind.
1. Child ClassLoader can see the class loaded by Parent ClassLoader but vice-versa is not true.
2. It is not possible that two different class loaders loads the same class. Genrally class loaded by Parent should not be loaded by Child ClassLoader again. But we could write our custom class loader to voilate this default behaviour but it is not recommended.

Now let's take an example program to practicale steps of java class loading, the below class will produce step by step class loading classes.
```java
/*@author 
Krishnakanth Yachareni */
package com.java.deeplearning;
public class ClassLoaderEx {
	public static void main(String[] args) {
		System.out.println("ClassLoaders are loading class......!");
		System.out.println(ClassLoaderEx.class.getName());
		System.out.println(ClassLoaderEx.class.getAnnotations());
	}
}
```
**Run with verbose:class
```
[Opened C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.lang.Object from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.nio.MappedByteBuffer from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.nio.DirectByteBuffer from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.nio.LongBuffer from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.nio.DirectLongBufferU from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.security.PermissionCollection from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.security.Permissions from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.net.URLConnection from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded sun.net.www.URLConnection from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded sun.net.www.protocol.file.FileURLConnection from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded sun.net.www.MessageHeader from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.io.FilePermission from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.io.FilePermission$1 from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.io.FilePermissionCollection from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.security.AllPermission from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.security.UnresolvedPermission from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.security.BasicPermissionCollection from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded com.java.deeplearning.ClassLoaderEx from file:/C:/Users/Krishnakanth/workspace/JavaDeepLearning/bin/]
[Loaded sun.launcher.LauncherHelper$FXHelper from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.lang.Class$MethodArray from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.lang.Void from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
ClassLoaders are loading class......!
com.java.deeplearning.ClassLoaderEx
[Loaded java.util.HashMap$EntrySet from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.util.HashMap$HashIterator from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.util.HashMap$EntryIterator from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded sun.reflect.annotation.AnnotationParser from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.util.Collections$EmptyIterator from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Ljava.lang.annotation.Annotation;@2a139a55
[Loaded java.lang.Shutdown from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar]
[Loaded java.lang.Shutdown$Lock from C:\Program Files\Java\jre1.8.0_45\lib\rt.jar] 
```
### JVM ARCHITECTURE
[
![jvm](https://user-images.githubusercontent.com/19643459/33497095-aaac15ae-d6f2-11e7-9ed0-7b76cef6f685.png)
](url)
