package com.usman.madrasafaizululoom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.usman.madrasafaizululoom.data.StudentDBHandler;
import com.usman.madrasafaizululoom.model.Students;

import java.util.List;

public class AllStudents extends AppCompatActivity {

    StudentDBHandler db = new StudentDBHandler(this);
    ListView stdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_students);

        List<Students> stdAllList = db.getAllStudent();
        stdView = findViewById(R.id.listViewAllStudents);
        displayEmployee();

        final int[] updatedID = new int[1];
        stdView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Students std = stdAllList.get(position);
                updatedID[0] = std.getStdID();

                Intent intent = new Intent(AllStudents.this, AddRecord.class);
                intent.putExtra("StudentID", updatedID);
                startActivity(intent);
            }
        });

    }



    public void displayEmployee()
    {
        List<Students> stdAllList = db.getAllStudent();
        ArrayAdapter<Students> empAdapter = new ArrayAdapter<Students>(this, android.R.layout.simple_list_item_1, stdAllList)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setText(stdAllList.get(position).toString());
                return view;
            }
        };
        stdView.setAdapter(empAdapter);
    }


}