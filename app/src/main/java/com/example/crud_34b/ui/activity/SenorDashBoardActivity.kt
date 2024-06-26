package com.example.crud_34b.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_34b.R
import com.example.crud_34b.databinding.ActivitySenorDashBoardBinding

class SenorDashBoardActivity : AppCompatActivity() {

    lateinit var senorDashBoardBinding: ActivitySenorDashBoardBinding;





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        senorDashBoardBinding = ActivitySenorDashBoardBinding.inflate(layoutInflater)
        setContentView(senorDashBoardBinding.root)

        senorDashBoardBinding.button.setOnClickListener{
            var intent = Intent(this@SenorDashBoardActivity,
                SensorListActivity::class.java)
            startActivity(intent)
        }

        senorDashBoardBinding.buttonAccelerometer.setOnClickListener{
            var intent = Intent(this@SenorDashBoardActivity,
                AccelerometerActivity::class.java)
            startActivity(intent)
        }

        senorDashBoardBinding.btnLight.setOnClickListener{
            var intent = Intent(this@SenorDashBoardActivity,
                LightSensorActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}