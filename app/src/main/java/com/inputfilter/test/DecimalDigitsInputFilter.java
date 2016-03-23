package com.inputfilter.test;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * EditText输入过滤器(只限输入数字,且第一位不可为0)
 * 例:
 * setFilters(new InputFilter[]{new DecimalDigitsInputFilter(5, 2)});
 * 小数点前限制输入5位数字，小数点后限制输入2位小数
 * Created by liyanan on 16/3/22.
 */
public class DecimalDigitsInputFilter implements InputFilter {
    Pattern startPattern;
    Pattern filterPattern;

    /**
     * 传入小数点前限制位数和小数点后限制位数
     *
     * @param digitsBeforeZero 小数点前限制位数
     * @param digitsAfterZero
     */
    public DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero) {
        startPattern = Pattern.compile("^[1-9]");
        filterPattern = Pattern.compile("^\\d{1," + digitsBeforeZero + "}(\\.\\d{0," + digitsAfterZero + "})?$");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dStart, int dEnd) {
        String checkString = TextUtils.concat(dest.subSequence(0, dStart), source.subSequence(start, end),
                dest.subSequence(dEnd, dest.length())).toString();
        Matcher matcher;
        if (checkString.length() == 1) {
            //验证第一位不可为0
            matcher = startPattern.matcher(checkString);
        } else {
            matcher = filterPattern.matcher(checkString);
        }
        if (!matcher.matches())
            return "";
        return null;
    }
}
