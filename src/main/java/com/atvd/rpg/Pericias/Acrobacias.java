/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atvd.rpg.Pericias;

import com.atvd.rpg.data.PersonagemEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Moisés
 */
public class Acrobacias implements Pericias {

    private int dador;
    private int resultado;
    int maior = 0;

    public List testarContra(PersonagemEntity personagem) {
        Random random = new Random();
        int agilidade = personagem.getAgilidade();
        int maior = 0; // Variável para armazenar o maior resultado do dado
        List dadoss = new ArrayList();
        // Loop para realizar o teste de agilidade
        for (int i = 0; i < agilidade; i++) {
            int dador = random.nextInt(20) + 1; // Gera um número aleatório entre 1 e 20
            dadoss.add(dador);
            if (dador > maior) {
                maior = dador;
            } else {
                maior = maior;
            }

        }

        int resultado = maior + personagem.getAcrobacias();
        dadoss.add(resultado);
        return dadoss;
    }
}
