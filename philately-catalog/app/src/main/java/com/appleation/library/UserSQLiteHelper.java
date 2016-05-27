package com.appleation.library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


/**
 * Created by kparthasarathy on 05-03-2016.
 */
public class UserSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION       = 2;
    private static final String DATABASE_NAME       = "pcatalog.db";
    private static final String TABLE_NAME          = "tbl_user";
    private static final String COLUMN_ID           = "tbl_user_id";
    private static final String COLUMN_FIRSTNAME    = "tbl_user_firstname";
    private static final String COLUMN_LASTNAME     = "tbl_user_lastname";
    private static final String COLUMN_EMAIL        = "tbl_user_email";
    private static final String COLUMN_PASSWORD     = "tbl_user_pwd";
    private static final String COLUMN_PHONE        = "tbl_user_phone";
    private static final String COLUMN_COUNTRY      = "tbl_user_country_id";

    private String mPhoneNumber = "";
    private String dbPath = "";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_FIRSTNAME + " TEXT NOT NULL, " +
            COLUMN_LASTNAME + " VARCHAR(50) NOT NULL, " +
            COLUMN_EMAIL + " VARCHAR(255) NOT NULL, " +
            COLUMN_PASSWORD + " VARCHAR(20) NOT NULL, " +
            COLUMN_PHONE + " VARCHAR(20), " +
            COLUMN_COUNTRY + " VARCHAR(50) NOT NULL);";

    public UserSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertUser(User user, Context context) {
        try {
            ContentValues values = new ContentValues();

            db = this.getWritableDatabase();
            dbPath = this.db.getPath();
            mPhoneNumber = ""; //Helper.getLine1PhoneNumber(context);

            values.put(COLUMN_FIRSTNAME, user.getFirst_name());
            values.put(COLUMN_LASTNAME, user.getSurname());
            values.put(COLUMN_EMAIL, user.getEmail());
            values.put(COLUMN_PASSWORD, user.getPassword());
            values.put(COLUMN_PHONE, mPhoneNumber);
            values.put(COLUMN_COUNTRY, user.getCountry());

            Toast.makeText(context, dbPath, Toast.LENGTH_LONG).show();

            if (isUserExist(user.getEmail(), context)) {
                Toast.makeText(context, "Unable to insert user '" + user.getEmail() + "'. User already exist!", Toast.LENGTH_SHORT).show();
            }
            else {
                db.insert(TABLE_NAME, null, values);
                Toast.makeText(context, "New user login created successfully!", Toast.LENGTH_SHORT).show();
            }

            db.close();
            context.deleteDatabase(DATABASE_NAME);

        } catch (SQLiteException e) {
            e.printStackTrace();
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean isUserExist(String username, Context context) {
        db = this.getReadableDatabase();
        String query = "select " + COLUMN_EMAIL + " from " + TABLE_NAME + " where " + COLUMN_EMAIL + " = '" + username + "'";
        Toast.makeText(context, query, Toast.LENGTH_LONG).show();

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int cnt = cursor.getCount();
        cursor.close();
        Toast.makeText(context, ""+ cnt, Toast.LENGTH_LONG).show();

        if(cnt > 0){
            return true;
        }

        return false;
    }

    public void deleteUser(String username, Context context) {
        db = this.getWritableDatabase();
        String query = "delete from " + TABLE_NAME + " where " + COLUMN_EMAIL + " = '" + username + "'";
        db.execSQL(query);
        db.close();
        Toast.makeText(context, "User deleted successfully", Toast.LENGTH_LONG).show();
    }

    public void exportDB(Context context) throws IOException {
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();

        FileChannel source = null;
        FileChannel destination = null;

        String currentDBPath = "data/com.appelation.philatelycatalog/databases/" + DATABASE_NAME;
        String backupDBPath = DATABASE_NAME + ".bkp";

        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, backupDBPath);

        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
            Toast.makeText(context, "DB Exported to '" + backupDBPath + "'", Toast.LENGTH_LONG).show();
        } catch(IOException e) {
            e.printStackTrace();
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
//
//        //Open your local db as the input stream
//        String inFileName = "/data/data/com.appelation.philatelycatalog/databases/" + DATABASE_NAME;
//        File dbFile = new File(inFileName);
//        FileInputStream fis = new FileInputStream(dbFile);
//
//        String outFileName = Environment.getExternalStorageDirectory() + DATABASE_NAME + ".bkp";
//        //Open the empty db as the output stream
//        OutputStream output = new FileOutputStream(outFileName);
//        //transfer bytes from the inputfile to the outputfile
//        byte[] buffer = new byte[1024];
//        int length;
//        while ((length = fis.read(buffer))>0){
//            output.write(buffer, 0, length);
//        }
//        //Close the streams
//        output.flush();
//        output.close();
//        fis.close();
//        Toast.makeText(context, "DB Exported to '" + outFileName + "'", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
