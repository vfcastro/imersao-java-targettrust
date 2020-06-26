package br.com.tt.petshop.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "credito-api", url="${app.servicos.credito.host}")
public interface CreditoFeignClient {

    @GetMapping("/credito/{cpf}")
    CreditoDto consultaSituacaoCpf(@PathVariable("cpf") String cpf);
}
