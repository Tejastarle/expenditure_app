package org.tejas.expenditure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.tejas.expenditure.Expenditure;
import org.tejas.expenditure.ExpenditureAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExpenditureAdapter adapter;
    private List<Expenditure> expenditureList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expenditureList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ExpenditureAdapter(expenditureList);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.btnAddExpenditure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, AddExpenditureActivity.class), 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            String description = data.getStringExtra("description");
            double amount = data.getDoubleExtra("amount", 0);
            expenditureList.add(new Expenditure(description, amount));
            adapter.notifyDataSetChanged();
        }
    }
}
