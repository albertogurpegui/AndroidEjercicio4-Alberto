package com.example.albertoguerpegui.task4_alberto.Teachers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.albertoguerpegui.task4_alberto.R;


public class Teacher_Data extends AppCompatActivity{
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_data);

        btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
}
    private void openDialog() {
        Teacher_FragmentDialog cfd = new Teacher_FragmentDialog();
        cfd.show(getSupportFragmentManager(), "example");
    }
}