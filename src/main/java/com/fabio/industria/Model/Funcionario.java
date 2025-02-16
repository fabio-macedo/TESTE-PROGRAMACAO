package com.fabio.industria.Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Funcionario")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Funcionario extends Pessoa{
    @JsonProperty("Salário")
    private BigDecimal salario;

    @JsonProperty("Função")
    private String funcao;


    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat formatNumber = NumberFormat.getInstance();
        formatNumber.setGroupingUsed(true);


        return String.format("""
                Nome: %s
                Data de Nascimento: %s
                Salário: %s
                Função: %s
                """
        , getNome(), getDataNascimento().format(formatter), formatNumber.format(getSalario()), getFuncao());
                }


}
