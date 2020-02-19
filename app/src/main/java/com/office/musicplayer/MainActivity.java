package com.office.musicplayer;

import android.app.NotificationChannel;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play, pause, stop;
    int pausecurrentpos;

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.play_button);
        pause = (Button) findViewById(R.id.pause_button);
        stop = (Button) findViewById(R.id.stop_button);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.play_button:
                if (mediaPlayer==null){
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.quran);
                mediaPlayer.start();}

                else if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pausecurrentpos);
                    mediaPlayer.start();
                }
                break;

            case R.id.pause_button:
                if(mediaPlayer!=null){
                    mediaPlayer.pause();
                     pausecurrentpos = mediaPlayer.getCurrentPosition();
                }
                break;

            case R.id.stop_button:
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }
                break;
        }
    }

}
