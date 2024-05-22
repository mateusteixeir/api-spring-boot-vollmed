package mad.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import mad.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedicos(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
