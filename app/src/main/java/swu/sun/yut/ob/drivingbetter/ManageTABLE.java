package swu.sun.yut.ob.drivingbetter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by arthit on 11/24/15 AD.
 */
public class ManageTABLE {

    // Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE_CAR = "carTABLE";
    public static final String COLUM_ID = "_id";
    public static final String COLUM_Id_Car = "Id_Car";
    public static final String COLUM_Password = "Password";
    public static final String COLUM_MileCar = "MileCar";
    public static final String COLUM_Date = "Date";
    public static final String COLUM_Mile = "Mile";
    public static final String COLUM_ACT = "ACT";
    public static final String COLUM_TAX = "TAX";
    public static final String COLUM_Insure = "Insure";
    public static final String COLUM_Batt = "Batt";
    public static final String COLUM_Tire = "Tire";
    public static final String COLUM_Engine_oil = "Engine_oil";
    public static final String COLUM_Radiator = "Radiator";
    public static final String COLUM_Fullservice = "Fullservice";

    public static final String TABLE_EMER = "emerTABLE";
    private static final String COLUM_ImgService = "ImgService";
    private static final String COLUM_TelService = "TelService";
    private static final String COLUM_ImgInsure = "ImgInsure";
    private static final String COLUM_TelInsure = "TelInsure";

    public static final String TABLE_FIX = "fixTABLE";
    private static final String COLUM_Topig = "Topig";
    private static final String COLUM_Image = "Image";
    private static final String COLUM_DescripFix = "DescripFix";

    public static final String TABLE_LOGIN = "loginTABLE";
    private static final String COLUM_ID_car_login = "ID_car_login";
    private static final String COLUM_TimeDate = "TimeDate";
    private static final String COLUM_Lat= "Lat";
    private static final String COLUM_Lng = "Lng";




    public ManageTABLE(Context context) {


        //Connnected Database
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    } //Constustor

    public String[] searchIDcard(String strIDcard) {

        try {

            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(TABLE_CAR,
                    new String[]{COLUM_ID,
                            COLUM_Id_Car,
                            COLUM_Password,
                            COLUM_MileCar,
                            COLUM_Date,
                            COLUM_Mile,
                            COLUM_ACT,
                            COLUM_TAX,
                            COLUM_Insure,
                            COLUM_Batt,
                            COLUM_Tire,
                            COLUM_Engine_oil,
                            COLUM_Radiator,
                            COLUM_Fullservice},
                    COLUM_Id_Car + "=?",
                    new String[]{String.valueOf(strIDcard)},
                    null, null, null, null);

            if (objCursor != null) {
                if (objCursor.moveToFirst()) {

                    strResult = new String[objCursor.getColumnCount()];
                    for (int i = 0; i < objCursor.getColumnCount(); i++) {

                        strResult[i] = objCursor.getString(i);

                    } // for

                } // if2
            } // if1

            objCursor.close();
            return strResult;


        } catch (Exception e) {
            return null;
        }

    }   // searchIDcard


    public long addValueLoginTable(String strID,
                                   String strTimeDate,
                                   String strLat,
                                   String strLng) {

        ContentValues objContentValues =new ContentValues();

        objContentValues.put(COLUM_ID_car_login,strID);
        objContentValues.put(COLUM_TimeDate,strTimeDate);
        objContentValues.put(COLUM_Lat,strLat);
        objContentValues.put(COLUM_Lng,strLng);

        return writeSqLiteDatabase.insert(TABLE_LOGIN,null,objContentValues);
    }

    public long addValueFixTable(String strTopig,
                                 String strImageFix,
                                 String strDescripeFix) {
        ContentValues objContentValues = new ContentValues();

        objContentValues.put(COLUM_Topig,strTopig);
        objContentValues.put(COLUM_Image,strImageFix);
        objContentValues.put(COLUM_DescripFix,strDescripeFix);

        return writeSqLiteDatabase.insert(TABLE_FIX,null,objContentValues);
    }


    public long addValueEmerTABLE(String strImageSer,
                                  String strTelSer,
                                  String strImageInsure,
                                  String strTelInsure) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUM_ImgService,strImageSer);
        objContentValues.put(COLUM_TelService,strTelSer);
        objContentValues.put(COLUM_ImgInsure,strImageInsure);
        objContentValues.put(COLUM_TelInsure,strTelInsure);
        return writeSqLiteDatabase.insert(TABLE_EMER, null, objContentValues);
    }


    public long addValueCarTABLE(String strIDcar,
                                 String strPass,
                                 String strMileCar,
                                 String strDate,
                                 String strMile,
                                 String strACT,
                                 String strTAX,
                                 String strInsure,
                                 String strBatt,
                                 String strTire,
                                 String strEngine_oil,
                                 String strRadiator,
                                 String strFullService) {
        ContentValues objContentValues = new ContentValues();

        objContentValues.put(COLUM_Id_Car,strIDcar);
        objContentValues.put(COLUM_Password,strPass);
        objContentValues.put(COLUM_MileCar,strMileCar);
        objContentValues.put(COLUM_Date,strDate);
        objContentValues.put(COLUM_Mile,strMile);
        objContentValues.put(COLUM_ACT,strACT);
        objContentValues.put(COLUM_TAX,strTAX);
        objContentValues.put(COLUM_Insure,strInsure);
        objContentValues.put(COLUM_Batt,strBatt);
        objContentValues.put(COLUM_Tire,strTire);
        objContentValues.put(COLUM_Engine_oil,strEngine_oil);
        objContentValues.put(COLUM_Radiator,strRadiator);
        objContentValues.put(COLUM_Fullservice,strFullService);

        return writeSqLiteDatabase.insert(TABLE_CAR,null,objContentValues);
    }

} //Mainclass
