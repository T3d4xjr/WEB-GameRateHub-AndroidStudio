package com.example.gameratehub_androidstudio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.GameViewHolder> {

    private List<Encapsulador> juegos;

    public Adaptador(List<Encapsulador> juegos) {
        this.juegos = juegos;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Infla la vista para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        final Encapsulador juego = juegos.get(position);

        // Establece la imagen y texto del juego
        holder.imageView.setImageResource(juego.getImage());
        holder.nameTextView.setText(juego.getNombre());
        holder.descriptionTextView.setText(juego.getDescripcion());
        holder.priceTextView.setText(juego.getPrecio());

        // Configura el CheckBox y escucha cambios de selección
        holder.checkBox.setChecked(juego.isSelected());
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            juego.setSelected(isChecked);

        });
    }

    @Override
    public int getItemCount() {
        return juegos.size();
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView descriptionTextView;
        TextView priceTextView;
        CheckBox checkBox;

        public GameViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.game_image);
            nameTextView = itemView.findViewById(R.id.game_title);
            descriptionTextView = itemView.findViewById(R.id.game_description);
            priceTextView = itemView.findViewById(R.id.game_price);
            checkBox = itemView.findViewById(R.id.game_checkbox);
        }
    }
}
