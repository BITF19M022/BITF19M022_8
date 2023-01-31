package com.usman.madrasafaizululoom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.usman.madrasafaizululoom.data.StudentDBHandler;
import com.usman.madrasafaizululoom.model.Students;

public class Student extends AppCompatActivity {

    EditText studentName, studentPhone, studentCity;
    Button btnAdd, btnAllStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        studentName = findViewById(R.id.editTxtName);
        studentPhone = findViewById(R.id.editTxtPhone);
        studentCity = findViewById(R.id.editTxtCity);

        btnAdd = findViewById(R.id.btnAdd);
        btnAllStudent = findViewById(R.id.btnAllStudent);
        StudentDBHandler dbStudent = new StudentDBHandler(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = studentName.getText().toString();
                String phone = studentPhone.getText().toString();
                String city = studentCity.getText().toString();

                if (!name.isEmpty() && !phone.isEmpty() && !city.isEmpty())
                {
                    Students std = new Students(name, phone, city);
                    dbStudent.addStudent(std);
                    studentName.getText().clear();
                    studentPhone.getText().clear();
                    studentCity.getText().clear();
                    Toast.makeText(Student.this, "Employee Added", Toast.LENGTH_SHORT).show();
//                    displayEmployee();
                }
                else
                {
                    Toast.makeText(Student.this, "All Field Required", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}