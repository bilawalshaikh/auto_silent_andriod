package com.example.time;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    public static AudioManager mAudioManager;
    Button btnEndTimePicker, btnTimePicker;
//    EditText txtDate,txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute,hrs,min,sec,hrsg,ming,secg,hourextra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEndTimePicker=(Button)findViewById(R.id.btn_date);
        btnTimePicker=(Button)findViewById(R.id.btn_time);
//        txtDate=(EditText)findViewById(R.id.in_date);
//        txtTime=(EditText)findViewById(R.id.in_time);

        btnEndTimePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
    }


    public void updateTimeOnEachSecond() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Calendar c = Calendar.getInstance();
                Log.d("myapp", "time changed");
                hrs = c.get(Calendar.HOUR_OF_DAY);
              min = c.get(Calendar.MINUTE);
                sec = c.get(Calendar.SECOND);
                 hourextra=hourextra+min ;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        // here you can define your hour and minute value.
//                        timePicker.setCurrentHour(hour);
//                        timePicker.setCurrentMinute(minute);

                        TimePicker timePicker1 =new TimePicker(getApplicationContext());
                        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
//                        timePicker1.setCurrentHour(timePicker1.getCurrentHour() ) ;
//                        timePicker1.setCurrentMinute(timePicker1.getCurrentMinute()) ;
                        int hours = timePicker1.getCurrentHour() ;
                        int mins = timePicker1.getCurrentMinute() ;


                        if ( mins  == min && hours == hrs )

                        {



                            mAudioManager =(AudioManager)MainActivity.this.getSystemService(Context.AUDIO_SERVICE);
                            mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                            //or adjust volume here instead setting silent profile for the ringer

                        }


                    }
                });

            }
        }, 0, 1000);

    }
    public void updateTimeOnEachSecond1() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Calendar c = Calendar.getInstance();
                Log.d("myapp", "time changed");
                hrsg = c.get(Calendar.HOUR_OF_DAY);
                 ming = c.get(Calendar.MINUTE);
                 secg = c.get(Calendar.SECOND);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TimePicker timePicker2;
                        timePicker2 = (TimePicker) findViewById(R.id.timePicker2);

//                        timePicker2.setCurrentHour(2);
                        int hoursg = timePicker2.getCurrentHour() ;
                        int minsg = timePicker2.getCurrentMinute() ;
//

//                        timePicker2.changeCurrentHour(65);
//                        timePicker2.setCurrentHour(timePicker2.getCurrentHour());
   //                     txtDate.setText(String.valueOf(ming)+minsg+"hour"+String.valueOf(hoursg)+hrsg);


                        if ( minsg  == ming && hoursg == hrsg )

                        {



                            mAudioManager =(AudioManager)MainActivity.this.getSystemService(Context.AUDIO_SERVICE);
                            mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                            //or adjust volume here instead setting silent profile for the ringer

                        }


                    }
                });

            }
        }, 0, 1000);

    }

    @Override
    public void onClick(View v) {

        if (v == btnEndTimePicker) {

            TimePicker timePicker2;
            timePicker2 = (TimePicker) findViewById(R.id.timePicker2);
            if(timePicker2.getVisibility()== View.INVISIBLE){
                timePicker2.setVisibility(View.VISIBLE);}

            TimePicker timePicker1;
            timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
            if(timePicker1.getVisibility()== View.VISIBLE){
                timePicker1.setVisibility(View.INVISIBLE);}

            Button btn;
            btn = (Button) findViewById(R.id.btn_timeset);
            if(btn.getVisibility()== View.INVISIBLE){
                btn.setVisibility(View.VISIBLE);}


//            int hours = timePicker1.getCurrentHour();
//            int mins = timePicker1.getCurrentMinute();


            //

            //
            updateTimeOnEachSecond1();


            // Get Current Date
//            final Calendar c = Calendar.getInstance();
//            mYear = c.get(Calendar.YEAR);
//            mMonth = c.get(Calendar.MONTH);
//            mDay = c.get(Calendar.DAY_OF_MONTH);
//
//
//            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
//                    new DatePickerDialog.OnDateSetListener() {
//
//                        @Override
//                        public void onDateSet(DatePicker view, int year,
//                                              int monthOfYear, int dayOfMonth) {
//
//                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
//
//                        }
//                    }, mYear, mMonth, mDay);
//            datePickerDialog.show();
        }
        if (v == btnTimePicker) {
            TimePicker timePicker2;
            timePicker2 = (TimePicker) findViewById(R.id.timePicker2);
            if(timePicker2.getVisibility()== View.VISIBLE){
                timePicker2.setVisibility(View.INVISIBLE);}
            NotificationManager notificationManager =
                    (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                    && !notificationManager.isNotificationPolicyAccessGranted()) {

                Intent intent = new Intent(
                        android.provider.Settings
                                .ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);

                startActivity(intent);
            }



            TimePicker timePicker1;
            timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
            if(timePicker1.getVisibility()== View.INVISIBLE){
                timePicker1.setVisibility(View.VISIBLE);}
            Button btn;
            btn = (Button) findViewById(R.id.btn_timeset);
            if(btn.getVisibility()== View.INVISIBLE){
                btn.setVisibility(View.VISIBLE);}


//            int hours = timePicker1.getCurrentHour();
//            int mins = timePicker1.getCurrentMinute();


  //

  //
            updateTimeOnEachSecond();
        }


        }

    public void Dialog(View view) {
        TimePicker timePicker1;
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        if(timePicker1.getVisibility()== View.VISIBLE){
            timePicker1.setVisibility(View.INVISIBLE);}
        TimePicker timePicker2;
        timePicker2 = (TimePicker) findViewById(R.id.timePicker2);
        if(timePicker2.getVisibility()== View.VISIBLE){
            timePicker2.setVisibility(View.INVISIBLE);}
        Button btn;
        btn = (Button) findViewById(R.id.btn_timeset);
        if(btn.getVisibility()== View.VISIBLE){
            btn.setVisibility(View.INVISIBLE);}


    }

}
