package com.example.notification11
import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import com.example.notification11.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val CHANNEL_ID = "channelId1"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun createNotificationChannel(){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                      description = "this my own notification"

                }
                val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
            }
        }
        createNotificationChannel()
        val intent = Intent(this, MainActivity::class.java)
        val pendingintent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("hello arjun bhai")
            .setContentText("kaise bhau sab tike na")
            .setSmallIcon(R.drawable.baseline_announcement_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingintent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
     binding.btn1.setOnClickListener {
         if (ActivityCompat.checkSelfPermission(
                 this,
                 Manifest.permission.POST_NOTIFICATIONS
             ) != PackageManager.PERMISSION_GRANTED
         ) {
             // TODO: Consider calling
             //    ActivityCompat#requestPermissions
             // here to request the missing permissions, and then overriding
             //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
             //                                          int[] grantResults)
             // to handle the case where the user grants the permission. See the documentation
             // for ActivityCompat#requestPermissions for more details.

         }
         notificationManager.notify(NOTIFICATION_ID, notification)
     }
    }
}