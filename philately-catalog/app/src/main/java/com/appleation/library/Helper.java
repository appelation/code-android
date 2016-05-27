package com.appleation.library;

import android.content.Context;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kparthasarathy on 09-03-2016.
 */
public class Helper {

    /**   # Start of group
     *    (
     *      (?=.*\d)		#   must contains one digit from 0-9
     *      (?=.*[a-z])		#   must contains one lowercase characters
     *      (?=.*[A-Z])		#   must contains one uppercase characters
     *      (?=.*[@#$%])	#   must contains one special symbols in the list "@#$%"
     *      .		        #   match anything with previous condition checking
     *      {6,12}	        #   length at least 6 characters and maximum of 12
     *    )
     *    # End of group
     */
    private static final String PWD_REG_EXPR = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,12})";
    private static Pattern password_pattern = null;
    private static Matcher password_matcher = null;
    private static Matcher confirm_password_matcher = null;

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public final static boolean isValidPassword(CharSequence password){
        password_pattern = Pattern.compile(PWD_REG_EXPR);
        password_matcher = password_pattern.matcher(password);
        return password_matcher.matches();
    }

    public final static boolean isValidPassword(CharSequence password, CharSequence confirm_password){
        password_pattern = Pattern.compile(PWD_REG_EXPR);
        password_matcher = password_pattern.matcher(password);
        confirm_password_matcher = password_pattern.matcher(confirm_password);

        if (password_matcher.matches() && confirm_password_matcher.matches())
        {
            if (!password.equals(confirm_password)) { return false; }

            return true;
        }
        else
        {
            return false;
        }
    }

    // don't forget to add <uses-permission android:name="android.permission.SEND_SMS"/>
    public final static void sendSMS(String phoneNo, String message, Context context){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(context, "Message Sent Successfully!", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(context,ex.getMessage().toString(), Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

    // don't forget to add <uses-permission android:name="android.permission.SEND_SMS"/>
    public final static void sendMultiPartSMS(String phoneNo, String message, Context context){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            ArrayList<String> parts = smsManager.divideMessage(message);
            smsManager.sendMultipartTextMessage(phoneNo, null, parts, null, null);
            Toast.makeText(context, "Multipart Message Sent Successfully!", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(context,ex.getMessage().toString(), Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

    // don't forget to add <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    public final static String getLine1PhoneNumber(Context context) {
        TelephonyManager tMgr = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tMgr.getLine1Number();
    }
}