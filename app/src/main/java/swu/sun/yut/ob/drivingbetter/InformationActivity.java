package swu.sun.yut.ob.drivingbetter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    //Explicit

    private TextView idCarTextView, currentMileTextView, ACTtextView, ACTnextTextView,
            taxTextView, taxnextTextView, insureTextView, insurenextTextView,
    battTextView, battnextTextView, tireTextView, tirenextTextView, engineOilTextView, engineOilNextTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        //Bind Widget
        bindWidget();

    }  //Main Method

    private void bindWidget() {

        idCarTextView = (TextView) findViewById(R.id.textView18);
        currentMileTextView = findViewById(R.id.textView20);
        ACTtextView = findViewById(R.id.textView22);
        ACTnextTextView = findViewById(R.id.textView33);
        taxTextView = findViewById(R.id.textView24);
        taxnextTextView = findViewById(R.id.textView34);
        insureTextView = findViewById(R.id.textView26);
        insurenextTextView = findViewById(R.id.textView35);
        battTextView = findViewById(R.id.textView28);
        battnextTextView = findViewById(R.id.textView36);
        tireTextView = findViewById(R.id.textView30);
        tirenextTextView = findViewById(R.id.textView37);
        engineOilTextView = findViewById(R.id.textView32);
        engineOilNextTextView = findViewById(R.id.textView38);


    }  //bindWidget


}  //MainClass
