package com.littleyellow.jcentertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.littleyellow.jcentertest.RxDeviceTool.getAndroidId;
import static com.littleyellow.jcentertest.RxDeviceTool.getDeviceSoftwareVersion;
import static com.littleyellow.jcentertest.RxDeviceTool.getIMEI;
import static com.littleyellow.jcentertest.RxDeviceTool.getUniqueSerialNumber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.test);
        StringBuilder sb  = new StringBuilder();
        sb.append("手机唯一标识序列号:").append(getUniqueSerialNumber()).append("\n")
                .append("设备的IMEI:").append(getIMEI(this)).append("\n")
                .append("设备的软件版本号").append(getDeviceSoftwareVersion(this)).append("\n")
                .append("ANDROID ID:").append(getAndroidId(this)).append("\n");

//        textView.setText(SimpleUtils.getTestStr());
        textView.setText(sb.toString());
    }
}
