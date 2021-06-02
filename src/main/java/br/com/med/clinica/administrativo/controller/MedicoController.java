package br.com.med.clinica.administrativo.controller;

import br.com.med.clinica.administrativo.model.Medico;
import br.com.med.clinica.administrativo.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class MedicoController {


        @Autowired
        private MedicoRepository medicoRepository;

    @GetMapping("/medico")
        public String listMedico(Model model) {
            List<Medico> medicos =  medicoRepository.findAll();
            model.addAttribute("medicos",medicos);
            return "/administrativo/medicolist";

        }


        @GetMapping("/medico/form")
        public String form(Model model,@Param(value = "id") Long id) {
            Medico medico = new Medico();
            if(id != null) {
                Optional<Medico> op = medicoRepository.findById(id);
                if(op.isPresent()) {
                    medico = op.get();
                }
            }
            model.addAttribute("Medico",medicoRepository);

            return "/administrativo/medicoform";

        }


        @PostMapping("/medico/salvar")
        public String salvar(@Valid Medico medico, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "/administrativo/medicosform";
            }
            medicoRepository.save(medico);
            return "redirect:/medico";
        }


        @GetMapping("/medico/delete")
        public String delete(Long id) {
            medicoRepository.deleteById(id);
            return "redirect:/medico";
        }


    }

