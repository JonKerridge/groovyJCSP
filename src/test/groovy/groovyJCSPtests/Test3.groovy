package groovyJCSPtests

import groovyJCSP.*
import jcsp.lang.*
import org.junit.Test

class Test3 {

    @Test
    public void test() {
        int N = 4
        int instances = 20
        def chan1 = Channel.one2oneArray(N)
        def chan1out = new ChannelOutputList(chan1)
        def expected = []
        for ( p in 1..N) {
            expected[p-1] = p
        }
        for ( p in 1..N) {
            for (repeats in 1 ..< instances/N)
                expected[p-1] += p + (repeats * N)
        }
//        println "Expected: $expected"
        List valueList = []
        int repeats = (int)(instances / N)
        int current = 1
        for ( r in 1..repeats){
            List newList = []
            for ( l in 1 .. N){
                newList << current
                current +=1
            }
            valueList << newList
        }
//        println "valueList: $valueList"
        def network = []
        network << new PutListWriteSeq(outList: chan1out, valueList: valueList)
        for ( p in 0..<N) network << new GetOneInt( input: chan1[p].in(),
                                                    instances: 5,
                                                    expected: expected[p])
        PAR testParallel = new PAR(network)
        testParallel.run()
        testParallel.removeAllProcesses()

        for ( p in 1..N) {
            assert ((GetOneInt)network[p]).result : "GetOneInt[$p] failed"
        }
        println "Test3 OK"
    }

}
