package groovyJCSPtests

import groovyJCSP.*
import jcsp.lang.*
import org.junit.Test

class Test4 {

    @Test
    public void test() {
        int N = 4
        int instances = 5
        def chan1 = Channel.one2oneArray(N)
        def chan1out = new ChannelOutputList(chan1)
        def valueList = [1,2,3,4,5]

//        println "valueList: $valueList"
        def network = []
        network << new PutListBroadcast(outList: chan1out, valueList: valueList)
        for ( p in 0..<N) network << new GetOne( input: chan1[p].in(),
                                                    instances: 5,
                                                    expected: 15)
        PAR testParallel = new PAR(network)
        testParallel.run()
        testParallel.removeAllProcesses()

        for ( p in 1..N) {
            assert ((GetOne)network[p]).result : "GetOneInt[$p] failed"
        }
        println "Test4 OK"
    }

}
