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

package groovy_jcsp.util


abstract class TestUtilities {

  static boolean  listContains (list1, list2) {

    if (list1.size != list2.size) {
      return false
    }
    else {
      list1.sort()
      list2.sort()
      return (list1 == list2)
    }
  } // end listContains

  static boolean list1GEList2 (list1, list2) {

    if (list1.size != list2.size) {
      return false
    }
    else {
      for (i in 0 ..< list1.size ) {
        if (list1[(int)i] < list2[(int)i]) {
          return false
        }
      }
      return true
    }

  }


}
