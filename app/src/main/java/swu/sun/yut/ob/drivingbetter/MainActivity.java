package swu.sun.yut.ob.drivingbetter;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler objHandler = new Handler();
        objHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        }, 4000);

        //SoundEffect
        MediaPlayer introMediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.soundeffect);
        introMediaPlayer.start();

    } //onCreate


} //Mainclass
