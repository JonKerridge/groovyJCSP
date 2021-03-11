package groovyJCSPtests

import jcsp.lang.*
import groovy.transform.CompileStatic
import groovy_jcsp.*

@CompileStatic
class PutListBroadcast implements CSProcess {

	ChannelOutputList outList
    List valueList

	void run() {
		int listSize = valueList.size()
		for ( i in 0..< listSize){
			DataObject dObj = new DataObject(value: (int)valueList[i])
            outList.broadcast(dObj)
		}
	}

}
