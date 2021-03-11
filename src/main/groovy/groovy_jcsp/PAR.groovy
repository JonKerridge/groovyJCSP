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

package groovy_jcsp

/**
 * <p>Title: Groovy Classes to Implement JCSP parallelism</p>
 *
 * <p>Description: Classes required to implement JCSP Constructs within
 * Groovy</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: Napier University</p>
 *
 * @author Jon Kerridge, Ken Barclay, John Savage
 * @version 1.0
 * @version 1.1 modified to compile under groovy jsr03
 */

import groovy.transform.CompileStatic
import jcsp.lang.*

/**
  * PAR is used to create a <code>Parallel</code> object
  * PAR extends the <code>Parallel</code> class of JCSP
  * PAR either takes a list of processes as its constructor parameter
  * or can be created as an empty object to which processes can
  * be added using <code>addProcess</code>
  **/

@CompileStatic
class PAR extends Parallel {



  PAR(List processList){
    super ()
    processList.each{p->
                     this.addProcess((CSProcess)p)
                    }
  }

  PAR(){
    super()
  }

}
