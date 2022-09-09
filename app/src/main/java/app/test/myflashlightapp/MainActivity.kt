package app.test.myflashlightapp

import android.content.Context
import android.graphics.PorterDuff
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private var flashLightStatus: Boolean = false


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val powerimg = findViewById<ImageView>(R.id.onflash)
        val powerimg1 = findViewById<ImageView>(R.id.onflash1)
        powerimg1.setOnClickListener {
            powerimg.visibility = ImageView.VISIBLE
            powerimg1.visibility = ImageView.INVISIBLE
            val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
            val cameraId = cameraManager.cameraIdList[0]
            if (!flashLightStatus) {
                //image color red
                powerimg.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.MULTIPLY)
                try {
                    cameraManager.setTorchMode(cameraId, true)
                    flashLightStatus = true
                } catch (e: CameraAccessException) {
                }
            } else {
                try {
                    cameraManager.setTorchMode(cameraId, false)
                    flashLightStatus = false
                } catch (e: CameraAccessException) {
                }
            }
        }
        powerimg.setOnClickListener {
            powerimg.visibility = ImageView.INVISIBLE
            powerimg1.visibility = ImageView.VISIBLE
                powerimg.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.MULTIPLY)
                val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
                val cameraId = cameraManager.cameraIdList[0]
                if (!flashLightStatus) {
                    //image color red
                    powerimg.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.MULTIPLY)
                    try {
                        cameraManager.setTorchMode(cameraId, true)
                        flashLightStatus = true
                    } catch (e: CameraAccessException) {
                    }
                } else {
                    try {
                        cameraManager.setTorchMode(cameraId, false)
                        flashLightStatus = false
                    } catch (e: CameraAccessException) {
                    }
                }
            }
        }
    }



