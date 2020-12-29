package tk.anikdas.anikdas012.androidtestguruklub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import tk.anikdas.anikdas012.androidtestguruklub.ui.ListFragment

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: called")
    }
}