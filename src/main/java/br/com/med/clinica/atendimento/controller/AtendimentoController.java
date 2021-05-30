package br.com.med.clinica.atendimento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.med.clinica.atendimento.model.Atendimento;
import br.com.med.clinica.atendimento.model.Exame;
import br.com.med.clinica.atendimento.model.Receita;
import br.com.med.clinica.atendimento.repository.AtendimentoRepository;
import br.com.med.clinica.atendimento.repository.ExameRepository;
import br.com.med.clinica.atendimento.repository.ReceitaRepository;

@Controller
public class AtendimentoController {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private ReceitaRepository receitaRepository;

	@GetMapping("/atendimento")
	public String listAtendimento(Model model) {
		List<Atendimento> atendimentos = atendimentoRepository.findAll();
		model.addAttribute("atendimentos", atendimentos);
		return "/atendimento/atendimento";
	}

	/**
	 * Carrega o formulario sem id formulario para novo atendimento ->
	 * localhost/atendimento/form com id formulario para edição atendimento ->
	 * localhost/atendimento/form?id=N
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/atendimento/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Atendimento atendimento = new Atendimento();
		List<Exame> exames = new ArrayList<>();
		List<Receita> receitas = new ArrayList<>();
		List<Atendimento> historico = new ArrayList<>();

		if (id != null) {
			Optional<Atendimento> op = atendimentoRepository.findById(id);
			if (op.isPresent()) {
				atendimento = op.get();
				// Lazy
				exames = exameRepository.findByAtendimento(atendimento);
				// Eagle
				// atendimento.getExames();
				receitas = receitaRepository.findByAtendimento(atendimento);
				historico = atendimentoRepository.findAllByPaciente(atendimento.getPaciente());

			}
		}
		model.addAttribute("historico", historico); 
		model.addAttribute("receitas", receitas);
		model.addAttribute("exames", exames);
		model.addAttribute("atendimento", atendimento);

		return "/atendimento/atendimentoform";
	}

	/**
	 * redirect: 302 redirecione para /atendimento
	 * 
	 * @param atendimento
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/atendimento/salvar")
	public String salvar(@Valid Atendimento atendimento, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
//			System.out.println("Erros");
//		bindingResult.getAllErrors()
//		.forEach(e -> System.out.println(e));

			return "/atendimento/atendimentoform";// em caso de erro, volte para o form

		}

		atendimento.setConsultas_oid((long) (Math.random() * 10000));
		atendimentoRepository.save(atendimento); // esse save tem papel de update tbm
		return "redirect:/atendimento"; // funciona de acordo ao que ele recebe
										// para atendimento novo ou editado.
		// se o id vir vazio, ele cria um novo id e salva o novo dado.
		// se vier com id preenchido, o save vai trabalhar como update.

	}

	@GetMapping("/atendimento/delete")
	public String delete(Long id) {
		atendimentoRepository.deleteById(id);
		return "redirect:/atendimento";
	}

}
