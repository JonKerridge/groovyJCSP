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


import groovy.transform.CompileStatic
import jcsp.lang.*
import jcsp.plugNplay.ProcessRead

/**
  * ChannelInputList is used to create a list of <code>ChannelInputEnds</code>
  *
  *
  **/

/**
 * @author Jon Kerridge
 *
 */
@CompileStatic
class ChannelInputList {

	/** The list that holds the Channel Input Ends */
  List <ChannelInput> cList = []

/**
  * ChannelInputList uses the <code>ArrayList</code> class of java
  * This constructor takes an array of <code>One2One Channels</code> as its
  * constructor parameter and converts them to a list of <code>ChannelInputEnds</code>
  *
  * @param channelArray an array of channels
  **/

  ChannelInputList( One2OneChannel[] channelArray) {
    AltingChannelInput [] inEnds  = Channel.getInputArray( channelArray )
      for ( c in 0..< channelArray.size()) cList[c] = inEnds[c]
  }

  /**
  * ChannelInputList uses the <code>ArrayList</code> class of java
  * This constructor takes an array of <code>One2Any Channels</code> as its
  * constructor parameter and converts them to a list of <code>ChannelInputEnds</code>
  *
 * @param channelArray
 */
ChannelInputList( One2AnyChannel[] channelArray) {
    SharedChannelInput [] inEnds  = Channel.getInputArray( channelArray )
      for ( c in 0..< channelArray.size()) cList[c] = inEnds[c]
  }

  /**
  * ChannelInputList uses the <code>ArrayList</code> class of java
  * This constructor takes an array of <code>Any2Any Channels</code> as its
  * constructor parameter and converts them to a list of <code>ChannelInputEnds</code>
  *
 * @param channelArray
 */
ChannelInputList( Any2AnyChannel[] channelArray) {
    SharedChannelInput [] inEnds  = Channel.getInputArray( channelArray )
      for ( c in 0..< channelArray.size()) cList[c] = inEnds[c]
    }

  /**
  * ChannelInputList uses the <code>ArrayList</code> class of java
  * This constructor takes an array of <code>Any2One Channels</code> as its
  * constructor parameter and converts them to a list of <code>ChannelInputEnds</code>
  *
 * @param channelArray
 */
ChannelInputList( Any2OneChannel[] channelArray) {
    AltingChannelInput [] inEnds  = Channel.getInputArray( channelArray )
      for ( c in 0..< channelArray.size()) cList[c] = inEnds[c]
      }


  /**
  * ChannelInputList uses the <code>ArrayList</code> class of java
  * This constructor creates an empty <code>ArrayList</code> to be populated with
  * <code>NetChannelInputs</code> or Channel Input Ends
  **/

  ChannelInputList() {
    // nothing required it is just an empty list
  }

  /**
   * Appends the channel input end or net channel input to the ChannelInputList.
   *
   * @param value The channel end to be added to the list of channels
   */
  void append ( ChannelInput value) {
    cList << value
  }

  /**
   * Returns the length of the Channel Input List
   *
   * @return the number of elements in the Channel Input List
   */
  int size() {
    return cList.size()
  }

  /**
   * The method contains determines whether or not the Channel Input List contains a specific value
   *
   * @param value The element value which is to be looked for
   * @return a boolean such that if value is contained in the Channel Input List true is returned and false otherwise
   */

  boolean contains ( ChannelInput value ) {
    return cList.contains (value)
  }

  /**
   * This method removes a value that is a channel input end from the list
 * @param value the channel input end to be removed
 * @return true if the value has been removed otherwise false
 */
boolean remove ( ChannelInput value ) {
    return cList.remove ( value )
  }

// removed plus and minus due to them not compiling under @compileStatic
  /**
   * minus removes the elements specified in the list from the channel list
   * @param list the list of channel ends to be removed
   */

  void minus ( List <ChannelInput> list ) {
    cList = cList - list
  }

  /**
   * plus adds the elements contained in the list parameter to the channel list
   * @param list a list of channel input ends to be added to the existing channel list
   */
  void plus ( List <ChannelInput> list ) {
    cList =  cList + list
  }


  /**
   * This method puts a channel end specified by value at the position specified by index
   * into the channel list
 * @param index the subscript of the element to be set
 * @param value a channel input end
 * @return the channel list with the element subscripted by index set to value
 */
void putAt ( int index, ChannelInput value ) {
    cList.set ( index, value )
  }

  /**
   * This method returns the channel input end located at the subscript specified by index
 * @param index the subscript of the channel end returned form the ChannelInputList
 * @return the ChannelInputEnd at subscript index
 */
ChannelInput getAt ( int index  ) {
    return cList.get (index )
  }

  /**
   * converts the ChannelInputList to an array
 * @return the array of ChannelInputEnds
 */
ChannelInput[] toArray () {
    return ( cList.toArray () as ChannelInput[])
  }

  /**
   * Reads in parallel from every element if the ChannelInputList.
   *
 * @return a list of values one for each channel input that has been read
 */
  List read () {

	  List values = [ ]
	  int channels = cList.size()
	  def readerList = []
	  (0 ..< channels).each { int i -> readerList [i] = new ProcessRead ( (ChannelInput)cList[i] )
	                        }
	  PAR parRead = new PAR ( readerList )
	  parRead.run()
	  (0 ..< channels).each { i -> values[i] = ((ProcessRead)readerList[i]).value }
	  return values
  }


  /**
   * The same as read except that the channels are read in sequence
   *
 * @return a list of values one for each channel input that has been read
 */
List readSeq(){
	List values = [ ]
	int channels = cList.size()
	for ( i in 0..< channels) values << ((ChannelInput)cList[i]).read()
	return values
  }
}
