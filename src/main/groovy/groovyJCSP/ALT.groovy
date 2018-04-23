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

package groovyJCSP

import groovy.transform.CompileStatic
import jcsp.lang.*

/**
 * ALT provides an easier way of creating the non-deterministic choice Alternative class of JCSP
 *
 **/
@CompileStatic
class ALT extends Alternative {

/**
  * If the ALT operates over a set of Alting Channel Input Ends these can be passed as a
  * ChannelInputList
  *
  * @param channelList A list of channel input ends
  **/

  ALT (ChannelInputList channelList) {
    super(channelList.toArray() as Guard[])

  }
/**
  * ALT takes a list of <code>Guards</code> as its constructor parameter
  * and converts them to an array of <code>Guards</code>
  * as required by <code>Alternative</code>.
 *
 * @param guardList A list of <code>Guards</code> including channel input ends, timer alarms and SKIP
 **/
  ALT ( List guardList) {
    super(guardList.toArray() as Guard[])
  }

}
