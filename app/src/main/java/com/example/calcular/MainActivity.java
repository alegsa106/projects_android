package com.example.calcular;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //views
    RadioGroup mOperationsContainer;
    private EditText mNumberX;
    private EditText mNumberY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtener radio group
        mOperationsContainer = findViewById(R.id.operations_container);
        mOperationsContainer.check(R.id.addition_option);

        //obtener los campos de edición
        mNumberX = findViewById(R.id.number_x_field);
        mNumberY = findViewById(R.id.number_y_field);

        mOperationsContainer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                TextView operador = findViewById(R.id.operator_symbol);

                switch (mOperationsContainer.getCheckedRadioButtonId())
                {
                    case R.id.addition_option:
                        operador.setText("+");
                        break;

                    case R.id.subtraction_option:
                        operador.setText("-");
                        break;

                    case R.id.multiplication_option:
                        operador.setText("*");
                        break;

                    case R.id.division_option:
                        operador.setText("/");
                        break;
                }
            }
        });
    }

    public void calculate(View v) {
        //variables locales
        int a, b, c = 0;

        //convertir el texto a enteros
        a = Integer.parseInt(mNumberX.getText().toString());
        b = Integer.parseInt(mNumberY.getText().toString());

        //calcular resultado
        switch (mOperationsContainer.getCheckedRadioButtonId())
        {
            case R.id.addition_option:
                c = a + b;
                break;

            case R.id.subtraction_option:
                c = a - b;
                break;

            case R.id.multiplication_option:
                c = a * b;
                break;

            case R.id.division_option:
                c = a / b;
                break;
        }

        //asignar el resultado
        ((TextView) findViewById(R.id.result_text)).setText(String.valueOf(c));
    }
}