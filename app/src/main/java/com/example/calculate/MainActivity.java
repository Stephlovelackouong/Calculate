package com.example.calculate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btnEqual;
    String sign ="";
    Double val1=0.0, val2=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView) findViewById(R.id.text);
        btnEqual = (Button) findViewById(R.id.btnEquals);

        btnEqual.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double num = Double.parseDouble(txt.getText().toString());
                        if (sign.equals("+"))
                            val2 = val1 + num;
                        else if (sign.equals("-"))
                            val2 = val1 - num;
                        else if (sign.equals("*"))
                            val2 = val1 * num;
                        else if (sign.equals("/"))
                            val2 = val1 / num;
                        txt.setText(val2.toString());
                    }
                }
        );

    }
    public void Number_Buttons_Clicked (View view)
    {
        Button btn = (Button) view;
        txt.append(btn.getText());

    }
    public void Sign_Buttons_Clicked (View view)
    {
        Button btn = (Button) view;
        sign = btn.getText().toString();
        val1 = Double.parseDouble(txt.getText().toString());
        txt.setText("");

    }
    public void Clear_Buttons_Clicked (View view)
    {
        try
        {
            Button btn = (Button) view;
            if (btn.getText().equals("CE"))
                txt.setText(txt.getText().toString().substring(0,txt.getText().length() -1));
            else if(btn.getText().equals("C"))
                txt.setText("");
        }catch (Exception ex) {
            txt.setText("");
        }
    }

}