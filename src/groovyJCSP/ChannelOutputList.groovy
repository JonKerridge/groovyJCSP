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
 *
 * @version 1.1 included the empty  constructor to enable
 * easier <code>NetChannelOUTPUT</code> list creation (Jon Kerridge)
 * and changes to comply with Groovy-jsr03
 */


import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import jcsp.lang.*
import jcsp.plugNplay.ProcessWrite
import jcsp.util.ints.BufferIntSizeError

/**
  * ChannelOutputList is used to create a list of
  * <code>ChannelOutputEnds</code>
  **/

@CompileStatic
class ChannelOutputList {
  List <ChannelOutput> cList = []

/**
  * ChannelOutputList uses the <code>ArrayList</code> class of java
  * This ChannelOutputList takes an array of <code>Any2Any Channels</code> as its
  * constructor parameter and converts them to a list of <code>Channel Output Ends</code>
  *
  * @param channelArray
  *
  **/

  ChannelOutputList( Any2AnyChannel []channelArray) {
      SharedChannelOutput[] outEnds = Channel.getOutputArray( channelArray )
      for ( c in 0..< channelArray.size()) cList[c] = outEnds[c]
//    cList = ( Arrays.asList(Channel.getOutputArray( channelArray )) )
  }

  /**
  * ChannelOutputList uses the <code>ArrayList</code> class of java
  * This ChannelOutputList takes an array of <code>One2Any Channels</code> as its
  * constructor parameter and converts them to a list of <code>Channel Output Ends</code>
  *
 * @param channelArray
 */
ChannelOutputList( One2AnyChannel []channelArray) {
      ChannelOutput[] outEnds = Channel.getOutputArray( channelArray )
      for ( c in 0..< channelArray.size()) cList[c] = outEnds[c]
//    cList = ( Arrays.asList(Channel.getOutputArray( channelArray )) )
  }

  /**
  * ChannelOutputList uses the <code>ArrayList</code> class of java
  * This ChannelOutputList takes an array of <code>Any2One Channels</code> as its
  * constructor parameter and converts them to a list of <code>Channel Output Ends</code>
  *
 * @param channelArray
 */
ChannelOutputList( Any2OneChannel []channelArray) {
      SharedChannelOutput[] outEnds = Channel.getOutputArray( channelArray )
      for ( c in 0..< channelArray.size()) cList[c] = outEnds[c]
//    cList = ( Arrays.asList(Channel.getOutputArray( channelArray )) )
  }

  /**
   * ChannelOutputList uses the <code>ArrayList</code> class of java
  * This ChannelOutputList takes an array of <code>One2One Channels</code> as its
  * constructor parameter and converts them to a list of <code>Channel Output Ends</code>
  *
* @param channelArray
 */
ChannelOutputList( One2OneChannel []channelArray) {
      ChannelOutput[] outEnds = Channel.getOutputArray( channelArray )
      for ( c in 0..< channelArray.size()) cList[c] = outEnds[c]
//    cList = ( Arrays.asList(Channel.getOutputArray( channelArray )) )
  }

/**
  * ChannelOutputList uses the <code>ArrayList</code> class of java
  * This constructor creates an empty <code>ArrayList</code> to be populated with
  * <code>Channel Output Ends</code>
  **/

  ChannelOutputList() {
    // nothing required it is just an empty list
  }

  /**
   * Appends the channel output end or net channel output to the ChannelOutputList.
   *
   * @param value The channel end to be added to the list of channels
   */
 void append ( ChannelOutput value) {
    cList << value
  }

 /**
  * Returns the length of the Channel Output List
  *
  * @return the number of elements in the Channel Output List
  */
  int size() {
    return cList.size()
  }

  /**
   * The method contains determines whether or not the Channel Output List contains a specific value
   *
   * @param value The element value which is to be looked for
   * @return a boolean such that if value is contained in the Channel Output List true is returned and false otherwise
   */

  boolean contains ( ChannelOutput value ) {
    return cList.contains (value)
  }

  /**
   * This method removes a value that is a channel output end from the list
 * @param value the channel output end to be removed
 * @return boolean indicating whether the required element has been removed
 */

  boolean remove ( ChannelOutput value ) {
    return cList.remove ( value )
  }

  /**
   * This method removes the elements specified in the list from the channel list
 * @param list the list of channel ends to be removed
 * @return the channel list with the specified elements removed
 */

  void minus ( List list ) {
	  cList = cList - list
  }

  /**
   * This method adds the elements contained in the list parameter to the channel list
 * @param list a list of channel output ends to be added to the existing channel list
 * @return the augmented list
 */
  void plus ( List <ChannelOutput>  list ) {
	  cList = cList + list
  }

  /**
   * This method puts a channel end specified by value at the position specified by index
   * into the channel list
 * @param index the subscript of the element to be set
 * @param value a channel output end
 * @return the channel list with the element subscripted by index set to value
 */
  void putAt ( int index, ChannelOutput value ) {
    cList.set ( index, value )
  }

  /**
   * This method returns the channel output end located at the subscript specified by index
 * @param index the subscript of the channel end returned form the ChannelOutputList
 * @return the ChannelOutputEnd at subscript index
 */
  ChannelOutput getAt ( int index  ) {
    return cList.get (index )
  }

  /**
   * converts the ChannelOutputList to an array
 * @return the array of ChannelOutputEnds
 */
  ChannelOutput [] toArray () {
    return (cList.toArray() as ChannelOutput[])
  }

  /**
   * The write method writes to each channel in a ChannelOutputList a value from the list
   * of values, one value per channel end, both subscripted using the same index.
   * The channels are written to in parallel
 * @param valueList A list containing the values to be written one for each
 * 					channel in the ChannelOutputList
 */
  void write ( List valueList) {
	  int channels = cList.size()
	  List writerList = []
	  (0 ..< channels).each { i -> writerList [i] = new ProcessWrite ( cList[i] )
	                               ((ProcessWrite)writerList[i]).value = valueList[i]
	                        }
	  PAR parWrite = new PAR ( writerList )
	  parWrite.run()
  }


  /**
   * The writeSeq method writes to each channel in a ChannelOutputList a value from the list
   * of values, one value per channel end, both subscripted using the same index.
   * The channels are written to in sequence
 * @param valueList A list containing the values to be written one for each
 * 					channel in the ChannelOutputList
 */
  void writeSeq ( List valueList) {
	  int channels = cList.size()
	  for (i in 0 ..< channels) (cList[i]).write(valueList[i])
  }

  /**
   * The broadcast method writes the same cloned value to each element of the ChannelOutputList.
   * The channels are written to in parallel
   * @param value The value to be written, which must implement Cloneable
   */
  @CompileDynamic
  void broadcast (Object bValue) {
	  int channels = cList.size()
	  List <ProcessWrite> writerList = []
	  writerList = (0 ..< channels).collect{i ->new ProcessWrite ( cList[i] )}
	  (0 ..< channels).each { i -> writerList[i].value = bValue.clone()}
	  PAR parWrite = new PAR ( writerList )
	  parWrite.run()
  }

  /**
   * The broadcastSeq method writes the  cloned value to each element of the ChannelOutputList.
   * The channels are written to in sequence
   * @param value The value to be written, which must implement Cloneable
   */
  @CompileDynamic
  void broadcastSeq ( Object value) {
	  int channels = cList.size()
	  for (i in 0 ..< channels) cList[i].write(value.clone())
  }


}