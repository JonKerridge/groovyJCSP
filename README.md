

The groovy_jcsp library provides a set of Groovy helper classes that make the 
use of the JCSP library (https://github.com/CSPforJAVA )much easier by reducing 
the amount of code that has to be written to build parallel systems.<p>


The library uses the @CompileStatic Groovy annotation to improve 
performance of the library.

These classes are used extensively in the books<p>
"Using Concurrency and Parallelism Effectively parts i & ii"
by Jon Kerridge published by Bookboon, free of charge.<p>

http://bookboon.com/en/using-concurrency-and-parallelism-effectively-i-ebook
http://bookboon.com/en/using-concurrency-and-parallelism-effectively-ii-ebook

The groovy_jcsp library is published using the Apache 2.0 Licence.

The groovy_jcsp library source is available at https://github.com/JonKerridge/groovy_jcsp

The library can be obtained from  https://github.com/JonKerridge/groovy_jcsp/releases/tag/1.1.8.

The release contains the binaries which can be saved in a Local Maven repository 
from where they can be accessed by a build file.

Download the groovy_jcsp-1.1.8-binaries.zip file and extract the contents to the directory

%user_name%/.m2/repository/cspforjava/jcsp/1.1.8

where %user_name% is the user's local directory for example in
Windows 10 it is C:\Users\username
in a unix system it is /user/username OR /home/username OR /users/username

It is assumed that the cspforjava.jcsp.1.1.8 library has already been downloaded 
to the Local Maven repository from https://github.com/CSPforJAVA/jcsp/releases/tag/1.1.8 ,

In order to use jcsp, groovy_jcsp and Groovy the following will be required in the build.gradle file.
<pre>
repositories {
    ...
    maven {
      url "https://mvnrepository.com/artifact/org.codehaus.groovy/groovy-all"
    }
    mavenLocal()
}

dependencies {
    implementation 'org.codehaus.groovy:groovy-all:3.0.7'
    implementation 'cspforjava:jcsp:1.1.8'
    implementation 'groovy_jcsp:groovy_jcsp:1.1.8'
}
</pre>


Contact J.Kerridge@napier.ac.uk
