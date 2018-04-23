package groovyJCSPtests

import jcsp.lang.*
import groovy.transform.CompileStatic
import groovyJCSP.*

@CompileStatic
class GetListFan implements CSProcess {

	ChannelInputList inList
	int instances = 0
    int sum = 0
    
	void run() {
        DataObject dObj = new DataObject()
		int listSize = inList.size()
        int chanToUse = 0
		for ( i in 1..instances){
            dObj = (DataObject)((ChannelInput) inList[chanToUse]).read()
            chanToUse = (chanToUse + 1) % listSize
            sum += dObj.value
		}
	}

}
