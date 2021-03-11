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

package groovy_jcsp.examples

import jcsp.lang.*
import groovy_jcsp.*
import groovy_jcsp.plugAndPlay.*

class FibonacciV1 implements CSProcess {

  ChannelOutput outChannel

  void run () {

    def a  = Channel.one2one()
    def b  = Channel.one2one()
    def c  = Channel.one2one()
    def d  = Channel.one2one()

    def testList = [ new GPrefix ( prefixValue: 0,
                                   inChannel: d.in(),
                                   outChannel: a.out() ),
                     new GPrefix ( prefixValue: 1,
                                   inChannel: c.in(),
                                   outChannel: d.out() ),
                     new GPCopy ( inChannel: a.in(),
                                  outChannel0: b.out(),
                                  outChannel1: outChannel ),
                     new GStatePairs ( inChannel: b.in(),
                                       outChannel: c.out() ),
                   ]
    new PAR ( testList ).run()
  }
}
