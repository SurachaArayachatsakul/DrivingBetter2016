package swu.sun.yut.ob.drivingbetter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        //Show View
        showView();

    }  //Main Method

    private void showView() {

        //Receive id from Intent
        String strID = getIntent().getStringExtra("id");
        int intID = Integer.parseInt(strID);

        //Get Value from Database
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME_,
                MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM carTABLE", null);
        objCursor.moveToFirst();
        objCursor.moveToPosition(intID-1);
        Log.d("car", "idCar = " + objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUM_Id_Car)));


    } //showView

    private void bindWidget() {

        idCarTextView = (TextView) findViewById(R.id.textView18);
        currentMileTextView = (TextView) findViewById(R.id.textView20);
        ACTtextView = (TextView) findViewById(R.id.textView22);
        ACTnextTextView = (TextView) findViewById(R.id.textView33);
        taxTextView = (TextView) findViewById(R.id.textView24);
        taxnextTextView = (TextView) findViewById(R.id.textView34);
        insureTextView = (TextView) findViewById(R.id.textView26);
        insurenextTextView = (TextView) findViewById(R.id.textView35);
        battTextView = (TextView) findViewById(R.id.textView28);
        battnextTextView = (TextView) findViewById(R.id.textView36);
        tireTextView = (TextView) findViewById(R.id.textView30);
        tirenextTextView = (TextView) findViewById(R.id.textView37);
        engineOilTextView = (TextView) findViewById(R.id.textView32);
        engineOilNextTextView = (TextView) findViewById(R.id.textView38);


    }  //bindWidget


}  //MainClass
