package in.adityashukla.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWt,edFt,edIn;
        Button btnCal;
        TextView textResult;
        LinearLayout layLL;

        edtWt = findViewById(R.id.edtWt);
        edFt = findViewById(R.id.edFt);
        edIn = findViewById(R.id.edIn);
        btnCal = findViewById(R.id.btnCal);
        textResult = findViewById(R.id.textResult);
        layLL= findViewById(R.id.layLL);

        btnCal.setOnClickListener(view -> {
            int wt = Integer.parseInt(edtWt.getText().toString());
            int ft = Integer.parseInt(edFt.getText().toString());
            int in = Integer.parseInt(edIn.getText().toString());

            int totalIn = ft * 12 + in;
            double totalCm = totalIn * 2.54;
            double totalM = totalCm/100;
            double bmi = wt/(totalM * totalM);

            if(bmi > 25){
                textResult.setText("You are over weight");
                layLL.setBackgroundColor(getResources().getColor(R.color.red));
            }else if(bmi < 18.5){
                  textResult.setText("You are under weight");
                layLL.setBackgroundColor(getResources().getColor(R.color.green));
            }else{
                textResult.setText("You are normal");
                layLL.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
        });




    }
}