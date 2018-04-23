package groovyJCSPtests

class DataObject implements Cloneable {
    int value
	
	DataObject clone() {
		DataObject newObj = new DataObject()
		newObj.value = this.value 
//		println "Cloned $value"
		return newObj
	}
	
	String toString() {
		return "DataObject has value $value"
	}
}
