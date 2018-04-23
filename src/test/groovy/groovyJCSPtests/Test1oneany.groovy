package groovyJCSPtests

import groovyJCSP.*
import jcsp.lang.*
import org.junit.Test

class Test1oneany {

    @Test
    public void test() {
        int N = 4
        int instances = 20
        def chan1 = Channel.one2anyArray(N)
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

        def network = []
        network << new PutListFan(outList: chan1out, instances: instances)
        for ( p in 0..<N) network << new GetOne( input: chan1[p].in(),
                                                instances: 5,
                                                expected: expected[p])
        PAR testParallel = new PAR(network)
        testParallel.run()
        testParallel.removeAllProcesses()

        for ( p in 1..N) {
            assert ((GetOne)network[p]).result : "GetOne[$p] failed"
        }
        println "Test1one2any OK"
    }

}
