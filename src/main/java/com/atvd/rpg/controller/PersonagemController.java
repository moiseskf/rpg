/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atvd.rpg.controller;

import com.atvd.rpg.Pericias.Acrobacias;
import com.atvd.rpg.Pericias.Pericias;
import com.atvd.rpg.data.PersonagemEntity;
import com.atvd.rpg.service.PersonagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Moisés
 */
@Controller
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    @GetMapping("/")
    public String viewHomePage(@CookieValue(name = "prefestilo", defaultValue = "escuro") String tema, Model model) {
        // model.addAttribute("tema", tema);
        //model.addAttribute("listaFilmes", filmeservice.listarTFilmes());
        return "index";
    }

    @GetMapping("/FormPersonagem")
    public String cadPersonagem(Model model) {
        //model.addAttribute("tema", tema);
        PersonagemEntity personagem = new PersonagemEntity();
        personagem.setForca(1);
        personagem.setAgilidade(1);
        personagem.setPresenca(1);
        personagem.setVigor(1);
        personagem.setInteligencia(1);
        model.addAttribute("personagem", personagem);
        return "CadPersonagem";
    }

    @PostMapping("/CadPersonagem")
    public String salvarPersonagem(@Valid @ModelAttribute("personagem") PersonagemEntity personagem, BindingResult result,Model model) {
        //model.addAttribute("tema", tema);
        if (result.hasErrors()) { 
         return "CadPersonagem"; 

        } 
        if (personagem.getId() == null) {
            personagemService.criarPersonagem(personagem);
        } else {
            personagemService.atualizarPersonagem(personagem.getId(), personagem);
        }
        

        return "redirect:/";
    
    
    }
PersonagemEntity pssp = new PersonagemEntity();
    @GetMapping("/ListaPersonagem")
    public String listPersonagem(Model model) {
        //model.addAttribute("tema", tema);
        model.addAttribute("listaPersonagens", personagemService.listarTpersonagens());
        return "ListarPersonagem";
    }

    @GetMapping("/deletarPersonagem/{id}")
    public String deletarPersonagem(Model model, @PathVariable(value = "id") Integer id) {
        //model.addAttribute("tema", tema);
        personagemService.deletarPersonagem(id);
        return "redirect:/";
    }

    @GetMapping("/Sessao")
    public String sessa(Model model) {
        //model.addAttribute("tema", tema);
        PersonagemEntity pp = new PersonagemEntity();
        model.addAttribute("listaPersonagens", personagemService.listarTpersonagens());
         model.addAttribute("pers", pp);
        return "Sessao";
    }

    @PostMapping("/acao")
    public String acao( @RequestParam("acaoSelecionada") int acaoSelecionada, Model model) {
        
        model.addAttribute("listaValores", personagemService.dado(pssp.getId(), acaoSelecionada));
        model.addAttribute("listaPersonagens", personagemService.listarTpersonagens());
        model.addAttribute("pers", pssp);
        return "Sessao";
    }

    @PostMapping("/Pers")
    public String pers(@RequestParam("personagemSelecionado") int personagemId, Model model) {
        pssp = personagemService.getPersonagemPId(personagemId);
        model.addAttribute("pers", personagemService.getPersonagemPId(personagemId));
        model.addAttribute("listaPersonagens", personagemService.listarTpersonagens());

        return "Sessao";
    }
    
    
        @GetMapping("/atualizarPersonagemForm/{id}")
    public String atualizarFuncionarioForm(@PathVariable(value = "id") Integer id, Model model) {

        PersonagemEntity perso = personagemService.getPersonagemPId(id);

        model.addAttribute("personagem", perso);

        return "atualizarPersonagem";
    }
}
