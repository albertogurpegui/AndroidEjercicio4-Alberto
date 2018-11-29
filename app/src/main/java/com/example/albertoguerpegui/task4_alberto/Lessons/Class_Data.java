package com.example.albertoguerpegui.task4_alberto.Lessons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.albertoguerpegui.task4_alberto.R;


public class Class_Data extends AppCompatActivity{
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_data);

        btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
}
    private void openDialog() {
        Class_FragmentDialog cfd = new Class_FragmentDialog();
        cfd.show(getSupportFragmentManager(), "example");
    }
}