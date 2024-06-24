package com.example.coviddetails.MyUtils;

import android.content.Context;
import android.widget.Toast;

public class MethodHelper {
    public static void showToast(String message  , Context context){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
