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


    private String idCarString, currentMileString, ACTString, ACTnextString,
            taxString, taxnextString, insureString, insurenextString,
            battString, battnextString, tireString, tirenextString, engineOilString, engineOilNextString;

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
        objCursor.moveToPosition(intID - 1);
        Log.d("car", "idCar = " + objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUM_Id_Car)));

        idCarString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUM_Id_Car));
        currentMileString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUM_MileCar));
        ACTString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUM_ACT));
        taxString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUM_TAX));
        insureString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUM_Insure));
        battString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUM_Batt));
        tireString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUM_Tire));
        engineOilString = objCursor.getString(objCursor.getColumnIndex(ManageTABLE.COLUM_Engine_oil));

        //Show at TextView
        idCarTextView.setText(idCarString);
        currentMileTextView.setText(currentMileString);
        ACTtextView.setText(ACTString);
        taxTextView.setText(taxString);
        insureTextView.setText(insureString);
        battTextView.setText(battString);
        tireTextView.setText(tireString);
        engineOilTextView.setText(engineOilString);

        //Split String
        String[] ACTStrings = ACTString.split("/");
        for (int i = 0; i < ACTStrings.length; i++) {
            Log.d("car", "ACTStrings[" + Integer.toString(i) + "] = " + ACTStrings[i]);
        }   //for

        //Increase Year
        int intYear = Integer.parseInt(ACTStrings[2]);
        intYear += 1;
        ACTnextString = ACTStrings[0] + "/" + ACTStrings[1] + "/" + Integer.toString(intYear);
        ACTnextTextView.setText(ACTnextString);

        String[] taxStrings = taxString.split("/");
        int intYearTax = Integer.parseInt(taxStrings[2]) + 1;
        taxnextTextView.setText(taxStrings[0] + "/" + taxStrings[1] + "/" + Integer.toString(intYearTax));

        String[] insureStrings = insureString.split("/");
        int intYearInsure = Integer.parseInt(insureStrings[2]) + 1;
        insurenextTextView.setText(insureStrings[0] + "/" + insureStrings[1] + "/" + Integer.toString(intYearInsure));

        String[] battStrings = battString.split("/");
        int intYearBatt = Integer.parseInt(battStrings[2]) + 2;
        battnextTextView.setText(battStrings[0] + "/" + battStrings[1] + "/" + Integer.toString(intYearBatt));

        String[] tireStrings = tireString.split("/");
        int intYearTire = Integer.parseInt(tireStrings[2]) + 2;
        tirenextTextView.setText(tireStrings[0] + "/" + tireStrings[1] + "/" + Integer.toString(intYearTire));

        int intEngineOil = Integer.parseInt(engineOilString) + 10000;
        engineOilNextTextView.setText(Integer.toString(intEngineOil));

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
