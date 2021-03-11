package groovyJCSPtests

import jcsp.lang.*
import groovy.transform.CompileStatic
import groovy_jcsp.*

@CompileStatic
class PutListWriteSeq implements CSProcess {

	ChannelOutputList outList
    List valueList

	void run() {
		int listSize = valueList.size()
		for ( i in 0..< listSize){
            outList.writeSeq((List)valueList[i])
		}
	}

}
