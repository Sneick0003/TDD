package com.example.tdd;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precioComida1, cantidadComida1;
    private EditText precioComida2, cantidadComida2;
    private EditText precioComida3, cantidadComida3;
    private TextView resultadoTxt;

    // Nombres predefinidos de las comidas
    private String comida1 = "Pizza";
    private String comida2 = "Hamburguesa";
    private String comida3 = "Ensalada";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar los campos
        precioComida1 = findViewById(R.id.precioComida1);
        cantidadComida1 = findViewById(R.id.cantidadComida1);

        precioComida2 = findViewById(R.id.precioComida2);
        cantidadComida2 = findViewById(R.id.cantidadComida2);

        precioComida3 = findViewById(R.id.precioComida3);
        cantidadComida3 = findViewById(R.id.cantidadComida3);

        resultadoTxt = findViewById(R.id.resultadoTxt);
    }

    public void calcularTotal(View view) {
        // Obtener datos de precio y cantidad
        double precio1 = Double.parseDouble(precioComida1.getText().toString());
        int cantidad1 = Integer.parseInt(cantidadComida1.getText().toString());

        double precio2 = Double.parseDouble(precioComida2.getText().toString());
        int cantidad2 = Integer.parseInt(cantidadComida2.getText().toString());

        double precio3 = Double.parseDouble(precioComida3.getText().toString());
        int cantidad3 = Integer.parseInt(cantidadComida3.getText().toString());

        // Cálculo de los totales de cada comida
        double totalComida1 = precio1 * cantidad1;
        double totalComida2 = precio2 * cantidad2;
        double totalComida3 = precio3 * cantidad3;

        // Determinar cuál es la comida más cara
        String comidaMasCara = comida1;
        double maxTotal = totalComida1;

        if (totalComida2 > maxTotal) {
            maxTotal = totalComida2;
            comidaMasCara = comida2;
        }

        if (totalComida3 > maxTotal) {
            maxTotal = totalComida3;
            comidaMasCara = comida3;
        }

        // Cálculo de impuestos y descuentos
        double totalCompra = totalComida1 + totalComida2 + totalComida3;
        double impuesto = totalCompra * 0.15;
        double totalConImpuesto = totalCompra + impuesto;

        if (totalConImpuesto > 100) {
            totalConImpuesto *= 0.9; // Aplicar descuento del 10%
        }

        // Mostrar resultado
        String resultado = "Comida más cara: " + comidaMasCara +
                "\nTotal (con impuestos y descuentos): $" + totalConImpuesto;
        resultadoTxt.setText(resultado);
    }
}