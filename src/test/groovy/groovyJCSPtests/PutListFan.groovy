package groovyJCSPtests

import jcsp.lang.*
import groovy.transform.CompileStatic
import groovy_jcsp.*

@CompileStatic
class PutListFan implements CSProcess {

	ChannelOutputList outList
	int instances = 0

	void run() {
		int listSize = outList.size()
        int chanToUse = 0
		for ( i in 1..instances){
            def dObj = new DataObject(value: i)
            ((ChannelOutput) outList[chanToUse]).write(dObj)
            chanToUse = (chanToUse + 1) % listSize
		}
	}

}
