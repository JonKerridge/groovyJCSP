    //////////////////////////////////////////////////////////////////////
    //                                                                  //
    //  groovy_jcsp (groovy support for "CSP for Java") Libraries        //
    // Copyright 2005-2017 Jon Kerridge                                 //
    //                                                                  //
    // Licensed under the Apache License, Version 2.0 (the "License");  //
    // you may not use this file except in compliance with the License. //
    // You may obtain a copy of the License at                          //
    //                                                                  //
    //      http://www.apache.org/licenses/LICENSE-2.0                  //
    //                                                                  //
    // Unless required by applicable law or agreed to in writing,       //
    // software distributed under the License is distributed on         //
    // an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,  //
    // either express or implied. See the License for the specific      //
    // language governing permissions and limitations under the License.//
    //                                                                  //
    //  Author contact: J.Kerridge@napier.ac.uk                         //
    //                                                                  //
    //////////////////////////////////////////////////////////////////////

package groovy_jcsp.plugAndPlay

import jcsp.lang.*
import groovy_jcsp.*
import jcsp.plugNplay.ProcessRead

class GParPrint implements CSProcess {

  ChannelInputList inChannels
  List<String> headings
  long delay = 200

  void run() {
    def inSize = inChannels.size()
    def readerList = []
    (0 ..< inSize).each { i ->
      readerList [i] = new ProcessRead ( inChannels[i] )
    }

    def parRead = new PAR ( readerList )

    if ( headings == null ) {
      println "No headings provided"
    }
    else {
      headings.each { print "\t${it}" }
      println ()
    }

    def timer = new CSTimer()
    while ( true) {
      parRead.run()
 //     print "\t"
//      readerList.each { pr -> print "${pr.value}\t" }
      readerList.each { pr -> print "\t" + pr.value.toString() }
      println ()
      if (delay > 0 ) {
        timer.sleep ( delay)
      }
    }
  }
}