package com.github.crazyuploader.covid19.ui;

import android.content.Context;
import android.widget.Toast;

public class Custom_Toast {
    public static void show(Context context, String message, int length)
    {
        Toast.makeText(context, message, length).show();
    }
}
