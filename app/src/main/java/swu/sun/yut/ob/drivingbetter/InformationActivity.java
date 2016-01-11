package swu.sun.yut.ob.drivingbetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    //Explicit

    private TextView Id_CarTextView,MileCarTextView,DateTextView,MileTextView,ACTextView,TAXTextView,InsureTextView,BattTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

    }  //Main Method
}  //MainClass
