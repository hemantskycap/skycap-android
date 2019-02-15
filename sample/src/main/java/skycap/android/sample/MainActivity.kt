package skycap.android.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import skycap.android.core.view.setVisibleOrGone

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.showHideButton).setVisibleOrGone(true)
    }
}
