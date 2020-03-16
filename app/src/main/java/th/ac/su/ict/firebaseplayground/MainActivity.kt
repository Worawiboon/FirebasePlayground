package th.ac.su.ict.firebaseplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherCollection = db.collection("weather")

        val data1:MutableMap<String,Any> = HashMap()
        data1["temp"] = 21
        data1["humidity"] = 90


        //weatherCollection.document("DKHE7dfyuWx4LGotVy8T").set(data1)  การแก้


        //weatherCollection.add(data1)

//        weatherCollection.add(data1)
//            .addOnSuccessListener {
//
//                Log.d("firebase_debug",it.id)
//            }
//            .addOnFailureListener({
//
//                Log.d("firebase_debug",it.toString())
//
//            }) การที่ add ไม่ได้

        val data2:MutableMap<String,Any> = HashMap()
        data2["temp"] = 23
        data2["humidity"] = 60

        weatherCollection.document("BKK").set(data2)

        val bkkDocRef = db.collection("weather").document("BKK")

        bkkDocRef.get()
            .addOnSuccessListener {

                Log.d("firebase_debug",it.data.toString())

                val temp = it["temp"]
                val humidity = it["humidity"]

                tvTemp.text = temp.toString()
                Hud.text =  humidity.toString()
            }

    }
}
