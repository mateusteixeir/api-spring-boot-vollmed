package mad.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import mad.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoPacientes(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
