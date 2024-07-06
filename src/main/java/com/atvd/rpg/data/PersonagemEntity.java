/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atvd.rpg.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Moisés
 */
@Data
@Entity
@Table(name = "Personagem")
public class PersonagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private SessaoEntity sessaoAtual;
    
    @Size(min=2, message="Informe ao menos 2 caracteres para o campo nome") 
    private String Nome;
    
    //@NotNull(message="Vida obrigatória")
    @Min(value = 1, message = "A vida não pode ser menor que 1.")
    private int vida;
    
    @Min(value = 1, message = "A sanidade não pode ser menor que 1.")
    private int sanidade;
   
    private int mana;
    
    @Min(value = 1, message = "A forca não pode ser menor que 1.")
    private int forca;
    @Min(value = 1, message = "A agilidade não pode ser menor que 1.")
    private int agilidade;
    @Min(value = 1, message = "A presenca não pode ser menor que 1.")
    private int presenca;
    @Min(value = 1, message = "o vigor não pode ser menor que 1.")
    private int vigor;
    @Min(value = 1, message = "A inteligencia não pode ser menor que 1.")
    private int inteligencia;
    
    
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int acrobacias; // agilidade
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int adestramento; // inteligencia
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int artes; //inteligencia
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int atletismo; //agilidade
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int crime; //
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int ciencia; // inteligencia
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int reflexo; //agilidade
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int diplomacia; //presença
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int enganacao; //inteligencia
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int fortitude; //vida
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int religiao; //presenca
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int furtividade; //agilidade
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int iniciativa; //agiligade
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int intimidacao; //presença
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int sobrevivencia; //inteligencia
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int intuicao; //inteligencia
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int luta; //forca
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int medicina; // inteligencia
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int percepcao; //inteligencia
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int pilotagem; //agilidade
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int pontaria; //agilidade
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int tecnologia; //inteligencia
    @Min(value = 0, message = "Nao pode ser menor que 0.")
    private int vontade; //presenca
    
    
   
   
    private String info;
    
}
