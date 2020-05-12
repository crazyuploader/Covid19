package com.github.crazyuploader.covid19.misc;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Format {

  public static String number(int number) {
    return NumberFormat.getNumberInstance(Locale.US).format(number);
  }

  public static String number(long number) {
    return NumberFormat.getNumberInstance(Locale.US).format(number);
  }

  public static String number(double number) {
    return NumberFormat.getNumberInstance(Locale.US).format(number);
  }

  public static String date(Long input) {
    Date date = new Date(input);
    SimpleDateFormat simpleDateFormat =
        new SimpleDateFormat("MMM dd, yyyy ; HH:mm:ss", Locale.getDefault());
    return simpleDateFormat.format(date);
  }
}
