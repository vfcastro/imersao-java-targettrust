package br.com.tt.petshop.client;

import br.com.tt.petshop.exception.ErroNegocioException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component// ou @Service
public class CreditoRestTemplateClient {

    private final RestTemplate restTemplate;
    private final String creditoUrl;

    public CreditoRestTemplateClient(RestTemplate restTemplate,
                                     @Value("${app.servicos.credito.url}") String creditoUrl) {
        this.restTemplate = restTemplate;
        this.creditoUrl = creditoUrl;
    }

    /*
       Retorno esperado: {"situacao":"NEGATIVADO","pontos":-679}
     */
    public CreditoDto consultaSituacaoCpf(String cpf) {
        //ResponseEntity<CreditoDto> retorno = restTemplate.getForEntity(url, CreditoDto.class);
        //String headerToken = retorno.getHeaders().getFirst("Authorization");
        //return retorno.getBody();

        try {
            return restTemplate.getForObject(creditoUrl, CreditoDto.class, cpf);
        }catch (HttpClientErrorException e){
            if(e.getStatusCode().ordinal() == 422){
                throw new ErroNegocioException("erro_externo", e.getResponseBodyAsString());
            }
            throw new ErroNegocioException("erro_externo", "Erro desconhecido!");

        }catch (HttpServerErrorException e){
            throw new ErroNegocioException("erro_externo", "Ocorreu um erro na chamada a api de crédito!");
        }
    }
}









