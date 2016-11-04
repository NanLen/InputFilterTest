package com.inputfilter.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_number;
    private EditText et_chinese;
    private EditText et_english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_number = (EditText) findViewById(R.id.et_number);
        et_number.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(6, 2)});
        et_chinese = (EditText) findViewById(R.id.et_chinese);
        et_chinese.setFilters(new InputFilter[]{new ChineseInputFilter()});
        et_english = (EditText) findViewById(R.id.et_english);
        et_english.setFilters(new InputFilter[]{new EnglishInputFilter()});
        Log.d("lyn","测试1");
    }
}
