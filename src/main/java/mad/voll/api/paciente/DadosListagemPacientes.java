package mad.voll.api.paciente;


public record DadosListagemPacientes(String nome, String cpf, String email, String telefone) {

    public DadosListagemPacientes(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }


}
