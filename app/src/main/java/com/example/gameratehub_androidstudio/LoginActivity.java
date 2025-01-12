package com.example.gameratehub_androidstudio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText inputUsername, inputPassword;
    private MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // Asegúrate que este layout existe

        // Inicialización de vistas
        inputUsername = findViewById(R.id.input_name);
        inputPassword = findViewById(R.id.input_password);
        btnLogin = findViewById(R.id.btn_login);

        // Obtenemos los datos del usuario guardados en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("name", "");
        String savedPassword = sharedPreferences.getString("password", "");

        // Si el usuario ya está registrado, iniciar sesión automáticamente
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredName = inputUsername.getText().toString();
                String enteredPassword = inputPassword.getText().toString();

                // Verificamos las credenciales
                if (enteredName.equals(savedName) && enteredPassword.equals(savedPassword)) {
                    Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    // Redirigimos al usuario a GameListActivity
                    Intent intent = new Intent(LoginActivity.this, GameListActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
