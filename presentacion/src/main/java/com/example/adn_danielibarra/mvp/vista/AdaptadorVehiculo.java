package com.example.adn_danielibarra.mvp.vista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adn_danielibarra.R;
import com.example.dominio.modelo.Moto;
import com.example.dominio.modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorVehiculo extends RecyclerView.Adapter<AdaptadorVehiculo.ViewHolder> {

    List<Vehiculo> vehiculoLista;
    ObtenerVehiculoIngresado vehiculoIngresado;
    List<String> dias;

    public AdaptadorVehiculo(List<Vehiculo> vehiculoLista, ObtenerVehiculoIngresado vehiculoIngresado) {
        this.vehiculoLista = vehiculoLista;
        this.vehiculoIngresado = vehiculoIngresado;
        dias=new ArrayList<>();

    }

    public void modificarVehiculoLista(List<Vehiculo> vehiculoLista) {
        this.vehiculoLista = vehiculoLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vehiculo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.llenarDatos(position);
    }

    @Override
    public int getItemCount() {
        return vehiculoLista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView tarjetaContenedora;
        TextView placa;
        TextView fechaIngreso;
        TextView tipoVehiculo;
        TextView cilindraje;
        Vehiculo vehiculo;
        Button btnCobrar;
        LinearLayout linCilindraje;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tarjetaContenedora = itemView.findViewById(R.id.card_contenedor);
            placa = itemView.findViewById(R.id.tv_placa);
            fechaIngreso = itemView.findViewById(R.id.tv_fecha_ingreso);
            tipoVehiculo = itemView.findViewById(R.id.tv_tipo_vehiculo);
            linCilindraje = itemView.findViewById(R.id.lin_cilindraje);
            btnCobrar = itemView.findViewById(R.id.btn_cobrar);
            cilindraje = itemView.findViewById(R.id.tv_cilindraje);
            btnCobrar.setOnClickListener(v -> {
                vehiculoIngresado.obtenerVehiculo(vehiculo);
            });
        }

        public void llenarDatos (int posicion) {
            this.vehiculo = vehiculoLista.get(posicion);
            placa.setText(vehiculo.obtenerPlaca());
            fechaIngreso.setText(vehiculo.obtenerFechaIngreso().getTime().toString());
            if (vehiculo instanceof Moto) {
                tipoVehiculo.setText(R.string.moto);
                linCilindraje.setVisibility(View.VISIBLE);
                cilindraje.setText(String.valueOf(((Moto)vehiculo).obtenerCilindraje()));

            } else {
                tipoVehiculo.setText(R.string.carro);
                linCilindraje.setVisibility(View.GONE);
            }
        }

        @Override
        public void onClick(View v) {

        }
    }
}
