package com.example.adn_danielibarra.mvp.vista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adn_danielibarra.R;
import com.example.adn_danielibarra.databinding.ItemVehiculoBinding;
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
        dias = new ArrayList<>();

    }

    public void modificarVehiculoLista(List<Vehiculo> vehiculoLista) {
        this.vehiculoLista = vehiculoLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemVehiculoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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

        ItemVehiculoBinding binding;
        Vehiculo vehiculo;

        public ViewHolder(ItemVehiculoBinding bindingTemp) {
            super(bindingTemp.getRoot());
            this.binding = bindingTemp;
            binding.btnCobrar.setOnClickListener(v -> {
                vehiculoIngresado.obtenerVehiculo(vehiculo);
            });
        }

        public void llenarDatos(int posicion) {
            this.vehiculo = vehiculoLista.get(posicion);
            binding.tvPlaca.setText(vehiculo.obtenerPlaca());
            binding.tvFechaIngreso.setText(vehiculo.obtenerFechaIngreso().getTime().toString());
            if (vehiculo instanceof Moto) {
                binding.tvTipoVehiculo.setText(R.string.moto);
                binding.linCilindraje.setVisibility(View.VISIBLE);
                binding.tvCilindraje.setText(String.valueOf(((Moto) vehiculo).obtenerCilindraje()));

            } else {
                binding.tvTipoVehiculo.setText(R.string.carro);
                binding.linCilindraje.setVisibility(View.GONE);
            }
        }

        @Override
        public void onClick(View v) {

        }
    }
}
