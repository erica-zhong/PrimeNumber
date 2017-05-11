package com.example.ericazhong.primenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    TextView result, instructions, divisors;
    EditText input;
    Button button;

    int number;
    String output;
    String divisor_nums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.result);
        divisors = (TextView) findViewById(R.id.divisors);
        instructions = (TextView)findViewById(R.id.instructions);
        input = (EditText)findViewById(R.id.input);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = Integer.parseInt(input.getText().toString()) ;
                output = "Yes";
                for(int num = 2; num < number; num++) {
                    if (number % num == 0) {
                        output = "No";
                        break;
                    }
                }
                if (number == 0 || number == 1){
                    output = "No, a prime number must be greater than 1.";
                }
                result.setText(output.toString());

                if(output.equals("No")){
                    divisor_nums = " ";
                    for (float num = 2; num <= number / 2; num++) {
                        if (number % num == 0) {
                            divisor_nums = divisor_nums + Math.round(num) + ", ";
                        }
                    }
                    output = "Divisors of " + number + " are " + "1," + divisor_nums + number;
                    divisors.setText(output);
                }


            }
        });
    }
}
