package skycap.android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import skycap.android.core.setVisibleOrGone
import skycap.android.core.setVisibleOrInvisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        message.setVisibleOrGone(true)
        message.setVisibleOrInvisible(true)
    }
}
