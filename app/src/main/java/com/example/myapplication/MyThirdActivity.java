package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MyThirdActivity extends AppCompatActivity {

    ConstraintLayout linearLayout;
    double firstNum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_third);

        Button num0 = findViewById(R.id.b0);
        Button num1 = findViewById(R.id.b1);
        Button num2 = findViewById(R.id.b2);
        Button num3 = findViewById(R.id.b3);
        Button num4 = findViewById(R.id.b4);
        Button num5 = findViewById(R.id.b5);
        Button num6 = findViewById(R.id.b6);
        Button num7 = findViewById(R.id.b7);
        Button num8 = findViewById(R.id.b8);
        Button num9 = findViewById(R.id.b9);

        Button ON = findViewById(R.id.ON);
        Button OFF = findViewById(R.id.OFF);
        Button AC = findViewById(R.id.AC);
        Button DEL = findViewById(R.id.DEL);
        Button DIV = findViewById(R.id.division);
        Button multiple = findViewById(R.id.multipl);
        Button plus = findViewById(R.id.somme);
        Button equal = findViewById(R.id.EGALE);
        Button min = findViewById(R.id.sous);
        Button point = findViewById(R.id.point);

        TextView screen = findViewById(R.id.screen);

        // Gestion de l'affichage ON/OFF
        OFF.setOnClickListener(view -> screen.setVisibility(View.GONE));
        ON.setOnClickListener(view -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        });

        // Boutons numériques
        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for (Button b : nums) {
            b.setOnClickListener(view -> {
                String currentText = screen.getText().toString();
                if (currentText.equals("0")) {
                    screen.setText(b.getText().toString());
                } else {
                    screen.setText(currentText + b.getText().toString());
                }
            });
        }

        // Boutons des opérations
        ArrayList<Button> opers = new ArrayList<>();
        opers.add(DIV);
        opers.add(multiple);
        opers.add(plus);
        opers.add(min);

        for (Button b : opers) {
            b.setOnClickListener(view -> {
                String currentText = screen.getText().toString();
                operation = b.getText().toString();
                firstNum = Double.parseDouble(currentText);
                screen.setText(currentText + " " + operation + " ");
            });
        }

        // Supprimer un caractère
        DEL.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length() > 1) {
                screen.setText(num.substring(0, num.length() - 1));
            } else {
                screen.setText("0");
            }
        });

        // Bouton du point
        point.setOnClickListener(view -> {
            String currentText = screen.getText().toString();
            if (!currentText.contains(".")) {
                screen.setText(currentText + ".");
            }
        });

        // Bouton égal
        equal.setOnClickListener(view -> {
            String currentText = screen.getText().toString();
            String[] parts = currentText.split(" "); // Diviser l'affichage
            if (parts.length == 3) {
                double secondNum = Double.parseDouble(parts[2]);
                double result;
                switch (operation) {
                    case "/":
                        result = firstNum / secondNum;
                        break;
                    case "*":
                        result = firstNum * secondNum;
                        break;
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    default:
                        result = 0;
                }
                screen.setText(String.valueOf(result)); // Afficher le résultat
                firstNum = result; // Stocker le résultat pour la prochaine opération
            }
        });

        // Réinitialisation
        AC.setOnClickListener(view -> {
            firstNum = 0;
            operation = "";
            screen.setText("0");
        });

        linearLayout = findViewById(R.id.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Standard) {
            Snackbar.make(linearLayout, "Are you sure", Snackbar.LENGTH_LONG).setAction("YES", v -> {
                Snackbar.make(linearLayout, "Operation annulee", Snackbar.LENGTH_LONG)
                        .setTextColor(Color.RED)
                        .setBackgroundTint(Color.YELLOW)
                        .show();
                startActivity(new Intent(MyThirdActivity.this, MainSecondActivity.class));
            }).setActionTextColor(Color.RED).setBackgroundTint(Color.GREEN).show();
            return true;
        } else if (id == R.id.Scientific) {
            // Option scientifique
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}