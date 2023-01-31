package com.usman.madrasafaizululoom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.usman.madrasafaizululoom.data.RecordDBHandler;
import com.usman.madrasafaizululoom.data.StudentDBHandler;
import com.usman.madrasafaizululoom.model.Record;
import com.usman.madrasafaizululoom.model.Students;

import java.util.List;

public class AddRecord extends AppCompatActivity {

    EditText todayDate, studentSabaq, studentSabqi, studentManzil;
    Button btnAdd, btnUpdate, btnDelete;
    ListView listRecordData;
    RecordDBHandler db = new RecordDBHandler(this);

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        todayDate = findViewById(R.id.editTextDate);
        studentSabaq = findViewById(R.id.editTxtSabaq);
        studentSabqi = findViewById(R.id.editTxtSabqi);
        studentManzil = findViewById(R.id.editTxtManzil);

        listRecordData = findViewById(R.id.listViewRecord);

        btnAdd = findViewById(R.id.btnAddRecord);
        btnUpdate = findViewById(R.id.btnUpdateRecord);
        btnDelete = findViewById(R.id.btnDeleteRecord);

        Intent intent = getIntent();
        int studentID = Integer.parseInt(intent.getStringExtra("StudentID"));

        displayRecord();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = todayDate.getText().toString();
                String sabaq = studentSabaq.getText().toString();
                String sabqi = studentSabqi.getText().toString();
                String manzil = studentManzil.getText().toString();

                if (!date.isEmpty() && !sabaq.isEmpty() && !sabqi.isEmpty() && !manzil.isEmpty())
                {
                    Record obj = new Record(date, sabaq, sabqi, manzil, studentID);
                    db.addRecord(obj);
                    todayDate.getText().clear();
                    studentSabaq.getText().clear();
                    studentSabqi.getText().clear();
                    studentManzil.getText().clear();
                    Toast.makeText(AddRecord.this, "Record Added", Toast.LENGTH_SHORT).show();
                    displayRecord();
                }
                else
                {
                    Toast.makeText(AddRecord.this, "All Field Required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void displayRecord()
    {
        List<Record> recordAllList = db.getAllRecord();
        ArrayAdapter<Record> empAdapter = new ArrayAdapter<Record>(this, android.R.layout.simple_list_item_1, recordAllList)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setText(recordAllList.get(position).toString());
                return view;
            }
        };
        listRecordData.setAdapter(empAdapter);
    }
}