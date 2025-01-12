package com.example.gameratehub_androidstudio;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GameListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private TextView totalTextView;

    // Mover la lista de juegos a un campo global
    private List<Encapsulador> juegos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);  // Asegúrate de que este layout sea correcto

        // Inicializar RecyclerView y TextView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        totalTextView = findViewById(R.id.total_price);

        // Inicializar la lista de juegos
        juegos = new ArrayList<>();
        juegos.add(new Encapsulador(R.drawable.uno, "The Legend of Zelda: Breath of the Wild", "Un juego de aventura de mundo abierto en el que exploras un mundo vasto y resuelves acertijos.", "$59.99"));
        juegos.add(new Encapsulador(R.drawable.dos, "God of War", "Una épica aventura de acción que sigue la vida de Kratos mientras busca venganza y redención.", "$49.99"));
        juegos.add(new Encapsulador(R.drawable.tres, "Minecraft", "Un juego de construcción y supervivencia en un mundo generado proceduralmente, con posibilidades infinitas.", "$26.95"));
        juegos.add(new Encapsulador(R.drawable.cuatro, "Red Dead Redemption 2", "Un juego de acción en un mundo abierto donde juegas como un forajido, explorando y viviendo aventuras.", "$59.99"));
        juegos.add(new Encapsulador(R.drawable.cinco, "Fortnite", "Un juego de batalla real donde 100 jugadores luchan hasta quedar uno solo. Gratis pero con compras dentro del juego.", "$0.00"));
        juegos.add(new Encapsulador(R.drawable.seis, "FIFA 23", "El juego de fútbol más famoso del mundo, con las mejores ligas y equipos del planeta.", "$59.99"));
        juegos.add(new Encapsulador(R.drawable.siete, "Call of Duty: Modern Warfare 2", "Un juego de disparos en primera persona con modo campaña y multijugador emocionante.", "$69.99"));
        juegos.add(new Encapsulador(R.drawable.ocho, "The Witcher 3: Wild Hunt", "Una experiencia de RPG con una historia épica y una jugabilidad de mundo abierto fantástica.", "$39.99"));
        juegos.add(new Encapsulador(R.drawable.nueve, "Assassin's Creed Valhalla", "Adéntrate en el mundo de los vikingos, haciendo misiones y luchando por un destino en el mundo antiguo.", "$49.99"));
        juegos.add(new Encapsulador(R.drawable.diez, "Cyberpunk 2077", "Un juego de rol futurista ambientado en una distópica ciudad cyberpunk, lleno de acción y narrativa profunda.", "$59.99"));


        // Configurar el adaptador
        adapter = new Adaptador(juegos);
        recyclerView.setAdapter(adapter);
    }

    // Método para actualizar el total
    public void actualizarTotal() {
        double total = 0.0;

        for (Encapsulador juego : juegos) {
            if (juego.isSelected()) {
                double price = Double.parseDouble(juego.getPrecio().substring(1)); // Asumiendo que el precio tiene un '$' al principio
                total += price;
            }
        }

        // Actualizamos el texto de total
        totalTextView.setText("Total: $" + String.format("%.2f", total));
    }

}
