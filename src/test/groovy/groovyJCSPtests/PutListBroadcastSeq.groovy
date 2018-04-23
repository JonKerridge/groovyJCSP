package groovyJCSPtests

import jcsp.lang.*
import groovy.transform.CompileStatic
import groovyJCSP.*

@CompileStatic
class PutListBroadcastSeq implements CSProcess {

	ChannelOutputList outList
    List valueList

	void run() {
		int listSize = valueList.size()
		for ( i in 0..< listSize){
            outList.broadcastSeq(new DataObject(value: (int)valueList[i]))
		}
	}

}
