package swu.sun.yut.ob.drivingbetter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by arthit on 11/24/15 AD.
 */
public class MyOpenHelper extends SQLiteOpenHelper{
    //Explicit
    public static final String DATABASE_NAME_ = "car.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_CAR_TABLE = "create table carTABLE (_id integer primary key," +
            "Id_Car text," +
            "Password text," +
            "MileCar text," +
            "Date text," +
            "Mile text," +
            "ACT text," +
            "TAX text," +
            "Insure text," +
            "Batt text," +
            "Tire text," +
            "Engine_oil text," +
            "Radiator text," +
            "Fullservice text);";

    public static  final  String CREATE_EMER ="create table emerTable(_id integer primary key, " +
            "ImgService text, " +
            "TelService text," +
            "ImgInsure text," +
            "TelInsure text);";

    public static final  String CREATE_FIX ="create table fixTable(_id integer primary key," +
            "Topig text," +
            "Image text," +
            "DescripFix text);";

    public static final String CREATE_LOGIN="create table loginTable(_id integer primary key," +
            "ID_car_login text," +
            "TimeDate text," +
            "Lat text," +
            "Lng text)";

    public MyOpenHelper(Context context) {
        super(context,DATABASE_NAME_,null,DATABASE_VERSION);
    } //Constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CAR_TABLE);
        db.execSQL(CREATE_EMER);
        db.execSQL(CREATE_FIX);
        db.execSQL(CREATE_LOGIN);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}  //Main Class

