/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atvd.rpg.Pericias;

import com.atvd.rpg.data.PersonagemEntity;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Moisés
 */
public class Adestramento implements Pericias {

    public List testarContra(PersonagemEntity personagem) {
        Random random = new Random();
        int agilidade = personagem.getInteligencia();
        List dadoss = new ArrayList();
        int maior = 0; // Variável para armazenar o maior resultado do dado

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

        int resultado = maior + personagem.getAdestramento();
        dadoss.add(resultado);
        return dadoss;
    }

}
