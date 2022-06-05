

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

The groovy_jcsp library source is available at https://github.com/JonKerridge/groovyJCSP

In order to use jcsp, groovy_jcsp and Groovy the named Github packages will 
be required in the build.gradle file.
<pre>
repositories {
    mavenCentral()
    maven { // to download the CSPforJAVA.jcsp library
        name = "GitHubPackages"
        url = "https://maven.pkg.github.com/CSPforJAVA/jcsp"
        credentials {
            username = project.findProperty("gpr.user")
            password = project.findProperty("gpr.key")
        }
    }
    maven { // to download the jonkerridge.groovy_jcsp library
        name = "GitHubPackages"
        url = "https://maven.pkg.github.com/JonKerridge/groovyJCSP"
        credentials {
            username = project.findProperty("gpr.user")
            password = project.findProperty("gpr.key")
        }
    }
}

dependencies {
    implementation 'org.codehaus.groovy:groovy-all:3.0.7'
    implementation 'cspforjava:jcsp:1.1.?'  // replace ? with release number
    implementation 'jonkerridge:groovy_jcsp:1.1.?'  // replace ? with same number as the one above
}
</pre>

**Please note**

In order to download Github Packages a user requires to have a Github Personal Access Token.  
See https://docs.github.com/en/github/authenticating-to-github/creating-a-personal-access-token

A gradle.properties file is required at the same directory level as the 
build.gradle file that contains

<pre>
gpr.user=userName
gpr.key=userPersonalAccessToken
</pre>


Contact J.Kerridge @ napier.ac.uk
