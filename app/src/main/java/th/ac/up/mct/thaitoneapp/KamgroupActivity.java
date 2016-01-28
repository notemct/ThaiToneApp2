package th.ac.up.mct.thaitoneapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import th.ac.up.mct.thaitoneapp.domain.KamDiao;
import th.ac.up.mct.thaitoneapp.domain.KamGroup;
import th.ac.up.mct.thaitoneapp.ui.KamgroupButton;

public class KamgroupActivity extends ActionBarActivity {

    private ImageButton microphoneButton;
    private ImageButton spekerButton;
    protected static final int RESULT_SPEECH = 1;
    private TextView txtText;

    MediaPlayer mySound;
    KamGroup kamGroup;
    @Override
    protected void onStop() {
        super.onStop();
        try {
            if (mySound != null && mySound.isPlaying()) {
                mySound.stop();
                mySound.release();
            }
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kamgroup);

        //Sound
        spekerButton = (ImageButton)findViewById(R.id.spekerButton);
        spekerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mySound !=null){

                    mySound.release();

                }
                int soundid = getResources().getIdentifier(kamGroup.soundth,"raw",getPackageName());
                mySound = MediaPlayer.create(KamgroupActivity.this, soundid);
                mySound.start();
                mySound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

            }


        });




        ImageView kamgroupImage = (ImageView) findViewById(R.id.kamgroupImage);
        ImageView kamgroupImageIPA = (ImageView)findViewById(R.id.kamkuImageIPA);

        ImageButton spekerButton  = (ImageButton)findViewById(R.id.spekerButton);
        microphoneButton = (ImageButton)findViewById(R.id.microphoneButton);
        txtText = (TextView) findViewById(R.id.txtText);


        Intent intent = getIntent();
        long kamkuId = intent.getLongExtra("KAMGROUP_ID", 0);
        kamGroup = KamGroup.get(kamkuId);

        int id0 = getResources().getIdentifier(kamGroup.pictureword, "drawable", getPackageName());
        kamgroupImage.setBackgroundResource(id0);

       // int id1 = getResources().getIdentifier(kamGroup.pictureipa,"drawable",getPackageName());
        //kamgroupImageIPA.setBackgroundResource(id1);

        microphoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                String languagePref = "th";//or, whatever iso code...
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, languagePref);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, languagePref);
                intent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE, languagePref);

                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    txtText.setText("");
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Opps! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    txtText.setText(text.get(0));
                    //Logger.i
//                    if(text.get(0).equals("ขา")){
//
//                    }else {
//
//                    }
//

                }
                break;

            }

        }
    }



}


