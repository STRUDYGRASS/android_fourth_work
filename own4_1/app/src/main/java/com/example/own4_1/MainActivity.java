package com.example.own4_1;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    SharedPreferences preferences;
    int count;
    ContentResolver contentResolver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("count", MODE_PRIVATE);
        //读取SharedPreferences里的count数据
        count = preferences.getInt("count", 0);
        //显示程序以前使用的次数
        Toast.makeText(this, "程序以前被使用了" + count + "次。", Toast.LENGTH_SHORT).show();
        Editor editor = preferences.edit();
        //存入数据
        editor.putInt("count", ++count);
        //提交修改
        editor.commit();
    }

}
