package mad.voll.api.controller;

import jakarta.validation.Valid;
import mad.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados){
        repository.save(new Medico(dados));

    }

    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 3,sort = {"nome"})Pageable pageable){

        return repository.findAllByAtivoTrue(pageable).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados){

        //Medico medico = repository.getReferenceById(dados.id());
        var medico = new Medico();
        medico = repository.getReferenceById(dados.id());

        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluirMedico();

    }
}













