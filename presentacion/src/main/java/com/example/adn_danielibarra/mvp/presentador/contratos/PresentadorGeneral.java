package com.example.adn_danielibarra.mvp.presentador.contratos;

public interface PresentadorGeneral {
    void mostrarDialogoAlerta(int titulo, int mensaje);

    void mostrarDialogoAlerta(int titulo, String mensaje);

    void mostrarDialogoCargando(int titulo, int mensaje);

    void cancelarDialogoCargando();
}
