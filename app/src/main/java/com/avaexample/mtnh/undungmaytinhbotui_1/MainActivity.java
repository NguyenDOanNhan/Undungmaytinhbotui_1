package com.avaexample.mtnh.undungmaytinhbotui_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNhap;
    private TextView txtResult;
    private Button btnnumber0;
    private Button btnnumber1;
    private Button btnnumber2;
    private Button btnnumber3;
    private Button btnnumber4;
    private Button btnnumber5;
    private Button btnnumber6;
    private Button btnnumber7;
    private Button btnnumber8;
    private Button btnnumber9;

    private Button btn_sum;
    private Button btn_tru;
    private Button btn_mutil;
    private Button btn_div;

    private Button btn_dot;
    private Button btn_clear;
    private Button btn_clearall;
    private Button btn_equal;
    private final String tag = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initkhoitao();
        seteventOnclickViews();
    }

    private void Initkhoitao() {
        txtNhap = (EditText) findViewById(R.id.txtNhap);
        txtResult = (TextView) findViewById(R.id.tvResult);

        btnnumber0 = (Button) findViewById(R.id.btnnumber0);
        btnnumber1 = (Button) findViewById(R.id.btnnumber1);
        btnnumber2 = (Button) findViewById(R.id.btnnumber2);
        btnnumber3 = (Button) findViewById(R.id.btnnumber3);
        btnnumber4 = (Button) findViewById(R.id.btnnumber4);
        btnnumber5 = (Button) findViewById(R.id.btnnumber5);
        btnnumber6 = (Button) findViewById(R.id.btnnumber6);
        btnnumber7 = (Button) findViewById(R.id.btnnumber7);
        btnnumber8 = (Button) findViewById(R.id.btnnumber8);
        btnnumber9 = (Button) findViewById(R.id.btnnumber9);

        btn_sum = (Button) findViewById(R.id.btn_sum);
        btn_tru = (Button) findViewById(R.id.btn_tru);
        btn_mutil = (Button) findViewById(R.id.btn_multiplication);
        btn_div = (Button) findViewById(R.id.btn_divide);


        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_clearall = (Button) findViewById(R.id.btn_clearall);
        btn_equal = (Button) findViewById(R.id.btn_equal);
    }

    public void seteventOnclickViews() {

        btnnumber0.setOnClickListener(this);
        btnnumber1.setOnClickListener(this);
        btnnumber2.setOnClickListener(this);
        btnnumber3.setOnClickListener(this);
        btnnumber4.setOnClickListener(this);
        btnnumber5.setOnClickListener(this);
        btnnumber6.setOnClickListener(this);
        btnnumber7.setOnClickListener(this);
        btnnumber8.setOnClickListener(this);
        btnnumber9.setOnClickListener(this);

        btn_sum.setOnClickListener(this);
        btn_tru.setOnClickListener(this);
        btn_mutil.setOnClickListener(this);
        btn_div.setOnClickListener(this);

        btn_dot.setOnClickListener(this);
        btn_clearall.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_equal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnnumber0:
                txtNhap.append("0");
                break;
            case R.id.btnnumber1:
                txtNhap.append("1");
                break;
            case R.id.btnnumber2:
                txtNhap.append("2");
                break;
            case R.id.btnnumber3:
                txtNhap.append("3");
                break;
            case R.id.btnnumber4:
                txtNhap.append("4");
                break;
            case R.id.btnnumber5:
                txtNhap.append("5");
                break;
            case R.id.btnnumber6:
                txtNhap.append("6");
                break;
            case R.id.btnnumber7:

                txtNhap.append("7");
                break;
            case R.id.btnnumber8:
                txtNhap.append("8");
                break;
            case R.id.btnnumber9:
                txtNhap.append("9");
                break;
//
            case R.id.btn_sum:
                txtNhap.append("+");
                break;
            case R.id.btn_tru:
                txtNhap.append("-");
                break;
            case R.id.btn_multiplication:
                txtNhap.append("*");
                break;
            case R.id.btn_divide:
                txtNhap.append("/");
                break;

            case R.id.btn_dot:
                txtNhap.append(".");
                break;
            case R.id.btn_clear:
                BaseInputConnection TxtnhapbaseInputConnection = new BaseInputConnection(txtNhap, true);
                TxtnhapbaseInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btn_clearall:
                txtNhap.setText("");
                break;
            case R.id.btn_equal:
                double result = 0;
                addOparation(txtNhap.getText().toString());
                addNumber(txtNhap.getText().toString());
                for (int i = 0; i < (arrNumber.size() - 1); i++) {
                    switch (arrOparation.get(i)) {
                        case "+":
                            if (i == 0) {
                                result = arrNumber.get(i) + arrNumber.get(i + 1);
                            } else {
                                result = result + arrNumber.get(i + 1);
                            }
                            break;
                        case "-":
                            if (i == 0) {
                                result = arrNumber.get(i) - arrNumber.get(i + 1);
                            } else {
                                result = result - arrNumber.get(i + 1);
                            }
                        case "*":
                            if (i == 0) {
                                result = arrNumber.get(i) * arrNumber.get(i + 1);
                            } else {
                                result = result * arrNumber.get(i + 1);
                            }
                        case "/":
                            if (i == 0) {
                                result = arrNumber.get(i) / arrNumber.get(i + 1);
                            } else {
                                result = result / arrNumber.get(i + 1);
                            }

                        default:
                            break;
                    }

                }
                txtResult.setText(String.valueOf(result));
                break;
        }
    }

    //    mang chua phep tinh
    public ArrayList<String> arrOparation;
    //    Mang chua so
    public ArrayList<Double> arrNumber;

    //  lay tat ca cac phep tinh luu vao mang arrOparation
    public int addOparation(String input) {
        arrOparation = new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOparation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOparation.add(cArray[i] + "");
                case '*':
                    arrOparation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOparation.add(cArray[i] + "");
                default:
                    break;
            }
        }
        return 0;
    }

    // lay tat ca cac so vao mang
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");// dinh dang ko lay ca phep toan chi lay cac so sau dau phep tinh
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()) {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
