package groovyJCSPtests

import org.junit.runner.JUnitCore

result = JUnitCore.runClasses (
            Test1oneone,
            Test1oneany,
            Test1anyone,
            Test1anyany,
            Test2,
            Test3,
            Test4,
            Test5,
            Test6oneone,
            Test6oneany,
            Test6anyone,
            Test6anyany,

            )

String message = "Ran: " + result.getRunCount() +
                 ", Ignored: " + result.getIgnoreCount() +
                  ", Failed: " + result.getFailureCount()
if (result.wasSuccessful()) {
    println "\nSUCCESS! " + message
} else {
    println "\nFAILURE! " + message + "\n"
    result.getFailures().each {
        println it.toString()
    }
}