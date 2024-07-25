package br.com.nomeempresa.restaurante.infra.feign.interceptor;

import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MercadoPagoInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHORIZATION_TOKEN = "Bearer APP_USR-2769775558422450-070119-ee41e11f02358748e2a66a0e0a63c8d4-354315215";

    private static final String IDEMPOTENCY_KEY_HEADER = "X-Idempotency-Key";
    private static final String IDEMPOTENCY_KEY = "0d5020ed-1af6-469c-ae06-c3bec19954ba";

    private static final String ACCEPT_HEADER = "accept";
    private static final String ACCEPT_TYPE = "application/json";

    private static final String CONTENT_TYPE_HEADER = "content-type";
    private static final String CONTENT_TYPE = "application/json";

    public void interceptor(RequestTemplate template) {
        template.header(AUTHORIZATION_HEADER, AUTHORIZATION_TOKEN);
        template.header(IDEMPOTENCY_KEY_HEADER, IDEMPOTENCY_KEY);
        template.header(ACCEPT_HEADER, ACCEPT_TYPE);
        template.header(CONTENT_TYPE_HEADER, CONTENT_TYPE);
    }

}
