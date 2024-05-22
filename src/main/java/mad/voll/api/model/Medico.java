package mad.voll.api.model;
import mad.voll.api.model.Endereco;

public class Medico {


    private final String nome;
    private final String email;
    private final String crm;
    private final String especialidade;
    private final Endereco endereco;

    public Medico(String nome, String email,String crm,String especialidade, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }
}
