

The groovyJCSP library provides a set of Groovy helper classes that make the 
use of the JCSP library (https://github.com/CSPforJAVA )much easier by reducing 
the amount of code that has to be written to build parallel systems.<p>


The library uses the @CompileStatic Groovy annotation to improve 
performance of the library.

These classes are used extensively in the books<p>
"Using Concurrency and Parallelism Effectively parts i & ii"
by Jon Kerridge published by Bookboon, free of charge.<p>

http://bookboon.com/en/using-concurrency-and-parallelism-effectively-i-ebook
http://bookboon.com/en/using-concurrency-and-parallelism-effectively-ii-ebook

The groovyJCSP library is published using the Apache 2.0 Licence.

The groovyJCSP library source is available at https://github.com/JonKerridge/groovyJCSP

The library can be downloaded from JitPack using the following Gradle definitions:

<pre>
repositories {
    ...
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.JonKerridge:groovyJCSP:1.1.6'
}
</pre>


Contact J.Kerridge@napier.ac.uk
