package com.inputfilter.test;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 过滤非中文字符
 * Created by liyanan on 16/3/23.
 */
public class ChineseInputFilter implements InputFilter {
    private Pattern filterPattern;

    public ChineseInputFilter() {
        filterPattern = Pattern.compile("^[\\u4E00-\\u9FA5]+$");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String checkString = TextUtils.concat(dest.subSequence(0, dstart), source.subSequence(start, end),
                dest.subSequence(dend, dest.length())).toString();
        Matcher matcher = filterPattern.matcher(checkString);
        if (!matcher.matches()) {
            return "";
        }
        return null;
    }
}
