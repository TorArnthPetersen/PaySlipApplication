package com.example.pay_slip_application;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class GeneralInformation extends AppCompatActivity {

    VideoView generalVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplement_information);


        //Get's the size of the phone's screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        // puts the width and height of the phone's screen into int variables
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        //set the window to not fill the entire screen in order to make it look like a popup-screen
        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));



        generalVideo = findViewById(R.id.videoView2);
        // locate the required video from resources
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.generalvideo;
        Uri uri = Uri.parse(videoPath);
        // set the VideoView to play the required video
        generalVideo.setVideoURI(uri);
        generalVideo.start();

        // includes a media controller to make it possible to start/stop or jump in the video
        MediaController mediaController = new MediaController(this);
        generalVideo.setMediaController(mediaController);
        mediaController.setAnchorView(generalVideo);


    }

    // closes the screen by opening the previous screen.
    public void closeVideo(View view) {
        super.onBackPressed();
    }


}
