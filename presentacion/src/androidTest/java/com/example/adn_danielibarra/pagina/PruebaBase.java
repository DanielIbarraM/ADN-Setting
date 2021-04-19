package com.example.adn_danielibarra.pagina;

import androidx.test.espresso.action.ViewActions;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class PruebaBase {

    public static void clicBoton(Integer idRecurso) {
        onView(withId(idRecurso))
                .perform(click());
    }

    public static void editarCajaTexto(Integer idRecurso, String texto) {
        onView(withId(idRecurso))
                .perform(typeText(texto), ViewActions.closeSoftKeyboard());
    }

}
