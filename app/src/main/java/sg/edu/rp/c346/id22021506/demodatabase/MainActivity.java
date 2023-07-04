package sg.edu.rp.c346.id22021506.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    TextView tvResults;

    ListView list;

    EditText etDesc;
    EditText etDate;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);
        list = findViewById(R.id.list);
        etDesc =findViewById(R.id.etdesc);
        etDate = findViewById(R.id.etdate);




        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBhelper db = new DBhelper(MainActivity.this);

                // Insert a task
                String etdesc = etDesc.getText().toString();
                String etdate = etDate.getText().toString();
                db.insertTask(etdesc, etdate);
                etDesc.setText("");
                etDate.setText("");


            }
        });
        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBhelper db = new DBhelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                ArrayList<Task> data1 =db.getTasks();
                db.close();



                ArrayAdapter adapter= new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, data1);

                list.setAdapter(adapter);
            }
        });
    }


}
