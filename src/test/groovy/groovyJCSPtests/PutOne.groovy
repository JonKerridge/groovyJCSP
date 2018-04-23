package groovyJCSPtests

import jcsp.lang.*
import groovy.transform.CompileStatic
import groovyJCSP.*

@CompileStatic
class PutOne implements CSProcess {

	ChannelOutput out
	int instances = 0

	void run() {
		for ( i in 1..instances) {
            def dObj = new DataObject(value : i)
            out.write(dObj)
		}
	}

}
