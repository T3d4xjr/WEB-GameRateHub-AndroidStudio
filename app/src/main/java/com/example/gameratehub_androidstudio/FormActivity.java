package com.example.gameratehub_androidstudio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class FormActivity extends AppCompatActivity {

    private TextInputEditText inputName, inputEmail, inputPassword;
    private MaterialButton btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);  // Verifica que el layout sea el correcto

        // Inicialización de los campos
        inputName = findViewById(R.id.input_name);
        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);
        btnSubmit = findViewById(R.id.btn_submit);

        // Al presionar el botón de registro
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                // Validación de los campos vacíos
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(FormActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Guardamos los datos del usuario en SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", name);
                    editor.putString("email", email);
                    editor.putString("password", password);
                    editor.apply();

                    // Mostramos un mensaje de éxito
                    Toast.makeText(FormActivity.this, "Datos guardados con éxito", Toast.LENGTH_SHORT).show();

                    // Después de registrar, ir a LoginActivity
                    Intent intent = new Intent(FormActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();  // Cerramos la actividad de registro
                }
            }
        });
    }
}
