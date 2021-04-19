package com.example.adn_danielibarra.mvp.vista.contratos;

public interface VistaGeneral {

    void mostrarDialogoAlerta(int titulo, int mensaje);

    void mostrarDialogoAlerta(int titulo, String mensaje);

    void mostrarDialogoCargando(int titulo, int mensaje);

    void cancelarDialogoCargando();

}
