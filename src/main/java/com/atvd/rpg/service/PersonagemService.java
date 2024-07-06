/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atvd.rpg.service;

import com.atvd.rpg.Pericias.Acrobacias;
import com.atvd.rpg.Pericias.Adestramento;
import com.atvd.rpg.Pericias.Pericias;
import com.atvd.rpg.data.PersonagemEntity;
import com.atvd.rpg.data.PersonagemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Moisés
 */
@Service
public class PersonagemService {

    @Autowired
    PersonagemRepository personagemRepository;

    public PersonagemEntity criarPersonagem(PersonagemEntity personagem) {

        personagem.setId(null);

        personagemRepository.save(personagem);

        return personagem;

    }

    public List<PersonagemEntity> listarTpersonagens() {

        return personagemRepository.findAll();

    }

    public PersonagemEntity getPersonagemPId(Integer personagemId) {

        return personagemRepository.findById(personagemId).orElse(null);

    }

    public void deletarPersonagem(Integer funcId) {
        PersonagemEntity personagem = getPersonagemPId(funcId);
        personagemRepository.delete(personagem);

    }

    public List dado(Integer funcId, int acao) {
        PersonagemEntity personagem = getPersonagemPId(funcId);
        List v = null;
        switch (acao) {
            case 0:
                Pericias P1 = new Acrobacias();
                v = P1.testarContra(personagem);
                break;
            case 1:
                Pericias p2 = new Adestramento();
                v = p2.testarContra(personagem);
                break;
            // Outros cases
            default:
                System.out.println("Dia inválido");
        }
        return v;
    }
     public PersonagemEntity atualizarPersonagem(Integer personagemId, PersonagemEntity personagemD) {
        PersonagemEntity perso = getPersonagemPId(personagemId);
        perso.setNome(personagemD.getNome());
        perso.setAcrobacias(personagemD.getAcrobacias());
        perso.setAdestramento(personagemD.getAdestramento());
        perso.setAgilidade(personagemD.getAgilidade());
        perso.setArtes(personagemD.getArtes());
        perso.setAtletismo(personagemD.getAtletismo());
        perso.setCiencia(personagemD.getCiencia());
        //perso.setTelefone(personagemD.getClass());
        perso.setDiplomacia(personagemD.getDiplomacia());
        perso.setEnganacao(personagemD.getEnganacao());
        perso.setForca(personagemD.getForca());
        perso.setFortitude(personagemD.getFortitude());
        perso.setFurtividade(personagemD.getFurtividade());
        perso.setInfo(personagemD.getInfo());
        perso.setIniciativa(personagemD.getIniciativa());
        perso.setInteligencia(personagemD.getInteligencia());
        perso.setIntimidacao(personagemD.getIntimidacao());
        perso.setLuta(personagemD.getLuta());
        perso.setMedicina(personagemD.getMedicina());
        //perso.setNome(personagemD.getNome());
        perso.setPercepcao(personagemD.getPercepcao());
        perso.setPilotagem(personagemD.getPilotagem());
        perso.setPontaria(personagemD.getPontaria());
        perso.setPresenca(personagemD.getPresenca());
        perso.setReflexo(personagemD.getReflexo());
        perso.setSanidade(personagemD.getSanidade());
        perso.setSobrevivencia(personagemD.getSobrevivencia());
        perso.setTecnologia(personagemD.getTecnologia());
        perso.setVida(personagemD.getVida());
        perso.setVigor(personagemD.getVigor());
        perso.setVontade(personagemD.getVontade());
        
        
        
        personagemRepository.save(perso);
        return perso;

    }
}
