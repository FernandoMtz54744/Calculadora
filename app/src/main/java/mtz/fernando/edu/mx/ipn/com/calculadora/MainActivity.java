package mtz.fernando.edu.mx.ipn.com.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView operacion;
    Button clear;
    String[] numAr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operacion = (TextView) findViewById(R.id.operacion);
        clear = (Button) findViewById(R.id.borrar);
        clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clicklargo();
                return true;
            }
        });

    }


    public void uno(View v) {
        operacion.setText(operacion.getText() + "1");
    }

    public void dos(View v) {
        operacion.setText(operacion.getText() + "2");
    }

    public void tres(View v) {
        operacion.setText(operacion.getText() + "3");
    }

    public void cuatro(View v) {
        operacion.setText(operacion.getText() + "4");
    }

    public void cinco(View v) {
        operacion.setText(operacion.getText() + "5");
    }

    public void seis(View v) {
        operacion.setText(operacion.getText() + "6");
    }

    public void siete(View v) {
        operacion.setText(operacion.getText() + "7");
    }

    public void ocho(View v) {
        operacion.setText(operacion.getText() + "8");
    }

    public void nueve(View v) {
        operacion.setText(operacion.getText() + "9");
    }

    public void cero(View v) {
        operacion.setText(operacion.getText() + "0");
    }

    public void dot(View v) {
        operacion.setText(operacion.getText() + ".");
    }

    public void igual(View v) {
        Double res = calcular(operacion.getText().toString(), "");
        if (res != 0.0001) {
            operacion.setText(Double.toString(res));
        }
    }

    public void sumar(View v) {
        Double res = calcular(operacion.getText().toString(), "+");
        if (res != 0.0001) {
            operacion.setText(Double.toString(res) + "+");
        }
    }

    public void restar(View v) {
        Double res = calcular(operacion.getText().toString(), "-");
        if (res != 0.0001) {
            operacion.setText(Double.toString(res) + "-");
        }
    }

    public void multiplicar(View v) {
        Double res = calcular(operacion.getText().toString(), "*");
        if (res != 0.0001) {
            operacion.setText(Double.toString(res) + "*");
        }
    }

    public void dividir(View v) {
        Double res = calcular(operacion.getText().toString(), "/");
        if (res != 0.0001) {
            operacion.setText(Double.toString(res) + "/");
        }
    }

    public void borrar(View v) {
        String oper = operacion.getText().toString();
        if (!oper.equals("")) {
            oper = oper.substring(0, (oper.length() - 1));
            operacion.setText(oper);
        }
    }

    public void clicklargo() {
        operacion.setText("");
    }


    public void sen(View v) {
        double res = calcular(operacion.getText().toString(), "");
        res = Math.sin(res);
        operacion.setText(Double.toString(res));
    }

    public void cos(View v) {
        double res = calcular(operacion.getText().toString(), "");
        res = Math.cos(res);
        operacion.setText(Double.toString(res));
    }

    public void tan(View v) {
        double res = calcular(operacion.getText().toString(), "");
        res = Math.tan(res);
        operacion.setText(Double.toString(res));
    }

    public void pow(View v){
        double res = calcular(operacion.getText().toString(), "");
        res = Math.pow(res, 2);
        operacion.setText(Double.toString(res));
    }

    public void sqrt(View v){
        double res = calcular(operacion.getText().toString(), "");
        res = Math.sqrt(res);
        operacion.setText(Double.toString(res));
    }


    public Double calcular(String num, String op){
        double res = 0.0001;
        if(num.charAt(num.length()-1) == '+' || num.charAt(num.length()-1) == '-' || num.charAt(num.length()-1) == '*' || num.charAt(num.length()-1) == '/'){
            num = num.substring(0, (num.length() - 1)) + op;
            operacion.setText(num);
        }else {
            if (num.indexOf('+') != -1) {
                numAr = num.split("\\+");
                res = Double.parseDouble(numAr[0]) + Double.parseDouble(numAr[1]);

            } else {
                if (num.indexOf('-') != -1) {
                    numAr = num.split("-");
                    res = Double.parseDouble(numAr[0]) - Double.parseDouble(numAr[1]);

                } else {
                    if (num.indexOf('*') != -1) {
                        numAr = num.split("\\*");
                        res = Double.parseDouble(numAr[0]) * Double.parseDouble(numAr[1]);

                    } else {
                        if (num.indexOf("/") != -1) {
                            numAr = num.split("/");
                            res = Double.parseDouble(numAr[0]) / Double.parseDouble(numAr[1]);
                        } else {
                            res = Double.parseDouble(operacion.getText().toString());
                        }
                    }
                }
            }
        }
        return res;
    }
}
