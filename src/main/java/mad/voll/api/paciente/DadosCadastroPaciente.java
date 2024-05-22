package mad.voll.api.paciente;

import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import mad.voll.api.endereco.DadosEndereco;
import mad.voll.api.model.Endereco;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{1,11}",message = "O cpf deve conter de 1 a 11 digitos!")
        String cpf,
        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
