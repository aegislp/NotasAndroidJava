package com.example.layout.interfaces;

import com.example.layout.model.Nota;

public interface NotaInteractionListener {
    void editNotaClick(Nota nota);
    void eliminarNotaClick(Nota nota);
    void favoritaNotaClick(Nota nota);
}
