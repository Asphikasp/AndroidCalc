package ru.asphikasp.androidcalc;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    TextView mNumberField;
    TextView mOperationField;
    TextView mResultField;
    long a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumberField = findViewById(R.id.numberField);
        mOperationField = findViewById(R.id.operationField);
        mResultField = findViewById(R.id.resultField);
        setA(0);
        setB(0);
    }

    private void setA(long v) {
        a=v;
        mNumberField.setText(String.valueOf(a));
    }

    private void setB(long v) {
        b=v;
        if (b == 0)
            mResultField.setText("");
        else
            mResultField.setText(String.valueOf(b));
    }

    public void onNumberClick(View view) {
        Button mButton = (Button)view;
        a = a*10 + parseInt((String) mButton.getText());
        mNumberField.setText(String.valueOf(a));
    }

    public void onOperationClick(View view){
        Button mButton = (Button)view;
        String op = (String)mOperationField.getText();
        if (op.isEmpty()) {
            setB(a);
        } else switch (op.charAt(0)){
            case '+':
                setB(a+b);
                break;
            case '-':
                setB(a-b);
                break;
            case '*':
                setB(a*b);
                break;
            case '/':
                setB(a/b);
                break;
        }
        setA(0);
        String newop = (String)mButton.getText();
        if (newop.equals("="))
            mOperationField.setText("");
        else
            mOperationField.setText(mButton.getText());
    }
}