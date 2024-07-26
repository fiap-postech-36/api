package br.com.nomeempresa.restaurante.infra.feign.utils;

import java.time.LocalDateTime;

public class MercadoPagoUtils {

    public static LocalDateTime expirationQrCode() {
        return LocalDateTime.now().plusHours(2);
    }

}
