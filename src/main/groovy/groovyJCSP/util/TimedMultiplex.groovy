    //////////////////////////////////////////////////////////////////////
    //                                                                  //
    //  groovyJCSP (groovy support for "CSP for Java") Libraries        //
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

package groovyJCSP.util

import groovyJCSP.*
//import ggJCSPPlugAndPlay.*
import jcsp.lang.*
import jcsp.plugNplay.*


class TimedMultiplex implements CSProcess {

  ChannelInputList inChannels
  ChannelOutput outChannel
  long timeout      // period during which process will run

  void run () {
    def timer = new CSTimer()
    def timerIndex = inChannels.size()
    def alt = new ALT( [inChannels, timer] )
    timer.setAlarm( timer.read() + timeout )
    def running = true
    while (running) {
      def index = alt.select ()
      if (index == timerIndex) {
        running = false
        println "TimedMultiplex has stopped"
      } else {
        outChannel.write (inChannels[index].read())
      }
    }
  }
}
