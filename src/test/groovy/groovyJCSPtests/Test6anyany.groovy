package groovyJCSPtests

import groovy_jcsp.*
import jcsp.lang.*
import org.junit.Test

class Test6anyany {

    @Test
    public void test() {
        int N = 4
        int instances = 5
        def chan1 = Channel.any2anyArray(N)
        def chan1in = new ChannelInputList(chan1)

        def network = []
        network << new GetListFan(inList: chan1in, instances: N * instances)
        for ( p in 0..<N) network << new PutOne( out: chan1[p].out(),
                                                instances: instances)
        PAR testParallel = new PAR(network)
        testParallel.run()
        testParallel.removeAllProcesses()


        assert ((GetListFan)network[0]).sum == 60 : "GetListFan failed"
        println "Test6any2any OK"
    }

}
