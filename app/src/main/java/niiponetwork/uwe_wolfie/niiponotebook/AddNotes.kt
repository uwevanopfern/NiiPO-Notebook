package niiponetwork.uwe_wolfie.niiponotebook

/**
 * Created by UWE_WOLFIE on 12/1/2017.
 */

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_notes.*

class AddNotes : AppCompatActivity() {
    val dbTable="Notes"
    var id=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        try{
            var bundle:Bundle=intent.extras
            id=bundle.getInt("ID",0)
            if(id!=0) {
                etTitle.setText(bundle.getString("name") )
                etDes.setText(bundle.getString("des") )

            }
        }catch (ex:Exception){}
    }

    fun  buAdd(view:View){
        var dbManager=DbManager(this)

        if (etTitle.text.isEmpty()){
            Toast.makeText(this, "Provide title", Toast.LENGTH_LONG).show()
        }else if(etDes.text.isEmpty()){
            Toast.makeText(this, "Provide description", Toast.LENGTH_LONG).show()
        }
        else{
            var values= ContentValues()
            values.put("Title",etTitle.text.toString())
            values.put("Description",etDes.text.toString())

            if(id==0) {
                val ID = dbManager.Insert(values)
                if (ID > 0) {
                    Toast.makeText(this, "Note is added", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(this, "Can not add note ", Toast.LENGTH_LONG).show()
                }
            }
            else{
                var selectionArs= arrayOf(id.toString())
                val ID = dbManager.Update(values,"ID=?",selectionArs)
                if (ID > 0) {
                    Toast.makeText(this, "Note is added", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(this, "Can not add note ", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}