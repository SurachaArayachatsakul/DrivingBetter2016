package swu.sun.yut.ob.drivingbetter;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SignUpActivity extends AppCompatActivity {

    //Explicit
    private EditText idcardEditText, passwordEditText, MilecarEditText, actEditText, taxEditText, insureEditText, battEditText,
            tireEditText, engineoilEditText;
    private String idcarString, passwordString, MilecarString,
            mileString, actString, taxString, insureString, battString,
            tireString, engineoilString, radiatorString, fullserviceString, dateString, provincceString;

    private TextView dateTextView;
    private Spinner provinceSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //Blind Widget
        blindWidget();

        //Get&Showtime

        getAndShowtime();

        //Create Spinner
        createSpiner();


    } //Main

    private void createSpiner() {
        final String[] strProvinceArray = getResources().getStringArray(R.array.province);
        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strProvinceArray);
        provinceSpinner.setAdapter(objAdapter);
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                provincceString = strProvinceArray[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                provincceString = strProvinceArray[0];
            }
        });
    } //Create Spinner

    private void getAndShowtime() {
        DateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        dateString = myDateFormat.format(currentDate);
        dateTextView.setText(dateString);
    }  //getAndShowtime


    public void clickSaveData(View view) {

        idcarString = idcardEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        MilecarString = MilecarEditText.getText().toString().trim();
        actString = actEditText.getText().toString().trim();
        taxString = taxEditText.getText().toString().trim();
        insureString = insureEditText.getText().toString().trim();
        battString = battEditText.getText().toString().trim();
        tireString = tireEditText.getText().toString().trim();
        engineoilString = engineoilEditText.getText().toString().trim();

        //check space
        if (idcarString.equals("") ||
                passwordString.equals("") ||
                MilecarString.equals("") ||
                actString.equals("") ||
                taxString.equals("") ||
                insureString.equals("") ||
                battString.equals("") ||
                tireString.equals("") ||
                engineoilString.equals("")) {

            //Have space
            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.errorDialog(SignUpActivity.this, "มีช่องว่าง", "กรุณากรอกข้อมูลให้ครบ");

        } else {

            //No Space
            checkIDcar();
        }

    } //ClickSAveData

    private void checkIDcar() {

        try {

            //Alert Have This IDcar On my database
            ManageTABLE objManageTABLE = new ManageTABLE(this);
            String[] strResult = objManageTABLE.searchIDcard(idcarString);

            MyAlertDialog objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.errorDialog(SignUpActivity.this, "Error IDcar", "มี หมายเลขทะเบียน " + strResult[1] + "ใน ฐานข้อมูลของเราแล้ว ให้ใช้ หมายเลข ทะเบยนอื่น");
        } catch (Exception e) {
            //Confirm to mySQL
            comfirmToMySQL();

        }
    }

    private void comfirmToMySQL() {

        //SetUpnewPolicy
        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();

        StrictMode.setThreadPolicy(myPolicy);

        try {

            ArrayList<NameValuePair> objNameValuePairs = new ArrayList<NameValuePair>();
            objNameValuePairs.add(new BasicNameValuePair("isAdd", "true"));
            objNameValuePairs.add(new BasicNameValuePair("Id_Car", idcarString));
            objNameValuePairs.add(new BasicNameValuePair("Password",passwordString));
            objNameValuePairs.add(new BasicNameValuePair("MileCar", mileString));
            objNameValuePairs.add(new BasicNameValuePair("Date", dateString));
            objNameValuePairs.add(new BasicNameValuePair("Mile", mileString));
            objNameValuePairs.add(new BasicNameValuePair("ACT", actString));
            objNameValuePairs.add(new BasicNameValuePair("TAX", taxString));
            objNameValuePairs.add(new BasicNameValuePair("Insure", insureString));
            objNameValuePairs.add(new BasicNameValuePair("Batt", battString));
            objNameValuePairs.add(new BasicNameValuePair("Tire", tireString));
            objNameValuePairs.add(new BasicNameValuePair("Engine_oil", engineoilString));
            objNameValuePairs.add(new BasicNameValuePair("Radiator", radiatorString));
            objNameValuePairs.add(new BasicNameValuePair("Fullservice", fullserviceString));

            HttpClient objHttpClient = new DefaultHttpClient();
            HttpPost objHttpPost = new HttpPost("http://swiftcodingthai.com/car/php_add_data_car.php");
            objHttpPost.setEntity(new UrlEncodedFormEntity(objNameValuePairs,"UTF-8"));
            objHttpClient.execute(objHttpPost);


            Toast.makeText(SignUpActivity.this, "Update ข้อมูลสำเร็จแล้ว", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(SignUpActivity.this, "ไม่สามารถ เชื่อมต่อ Server ได้", Toast.LENGTH_SHORT).show();
        }


    } // ConfirmtoMySQL

    private void blindWidget() {

        idcardEditText = (EditText) findViewById(R.id.editText3);
        passwordEditText = (EditText) findViewById(R.id.editText4);
        MilecarEditText = (EditText) findViewById(R.id.editText5);
        actEditText = (EditText) findViewById(R.id.editText6);
        taxEditText = (EditText) findViewById(R.id.editText7);
        insureEditText = (EditText) findViewById(R.id.editText8);
        battEditText = (EditText) findViewById(R.id.editText9);
        tireEditText = (EditText) findViewById(R.id.editText10);
        engineoilEditText = (EditText) findViewById(R.id.editText11);
        dateTextView = (TextView) findViewById(R.id.textView16);
        provinceSpinner = (Spinner) findViewById(R.id.spinner);


    }  //blindwidget


} //Main Class
