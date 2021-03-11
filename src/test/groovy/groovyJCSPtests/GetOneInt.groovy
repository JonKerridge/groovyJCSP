package groovyJCSPtests

import jcsp.lang.*
import groovy.transform.CompileStatic
import groovy_jcsp.*

@CompileStatic
class GetOneInt implements CSProcess {

	ChannelInput input
	int instances = 0
    int expected = 0
    boolean result = false

	void run() {
        int sum = 0
		for ( i in 1..instances) {
            int v = (int)input.read()
            sum += v
		}
        assert sum == expected : "sum: $sum, does not equal expected: $expected"
        result = true
	}

}
