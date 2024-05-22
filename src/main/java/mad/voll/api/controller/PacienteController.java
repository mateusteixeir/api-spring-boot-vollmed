package mad.voll.api.controller;

import jakarta.validation.Valid;
import mad.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    @Autowired
    private PacienteRepository pacienteRepository;


    @PostMapping
    @Validated
    public void CadastrarPaciente(@RequestBody DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listar(@PageableDefault(size = 3, sort = {"nome"}) Pageable pageable){

        return repository.findAll(pageable).map(DadosListagemPacientes::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPacientes dados){
        //var paciente = new Paciente();
         Paciente paciente = new Paciente();

         paciente = repository.getReferenceById(dados.id());

         paciente.atualizarInformacoes(dados);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){

        Paciente paciente = new Paciente();

        paciente = repository.getReferenceById(id);
        paciente.excluirPaciente(id);

    }
}
