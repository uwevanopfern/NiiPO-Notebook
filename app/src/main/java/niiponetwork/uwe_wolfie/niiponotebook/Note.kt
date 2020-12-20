package niiponetwork.uwe_wolfie.niiponotebook

/**
 * Created by UWE_WOLFIE on 12/1/2017.
 */

class Note{

    var noteID:Int?=null
    var noteName:String?=null
    var noteDes:String?=null

    constructor(noteID:Int,noteName:String,noteDes:String){
        this.noteID=noteID
        this.noteName=noteName
        this.noteDes=noteDes
    }
}