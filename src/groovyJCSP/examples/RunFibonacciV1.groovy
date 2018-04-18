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

package groovyJCSP.examples

import groovyJCSP.PAR
import groovyJCSP.plugAndPlay.GPrint
import jcsp.lang.Channel

def c = Channel.one2one()

def fib1 = new FibonacciV1(outChannel: c.out())
def prn = new GPrint(inChannel: c.in(), heading: "Fibonacci Numbers V1")

new PAR([fib1, prn]).run()


