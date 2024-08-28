package org.tejas.expenditure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddExpenditureActivity extends AppCompatActivity {

    private EditText etDescription, etAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenditure);

        etDescription = findViewById(R.id.etDescription);
        etAmount = findViewById(R.id.etAmount);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = etDescription.getText().toString().trim();
                double amount = Double.parseDouble(etAmount.getText().toString().trim());

                Intent resultIntent = new Intent();
                resultIntent.putExtra("description", description);
                resultIntent.putExtra("amount", amount);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
