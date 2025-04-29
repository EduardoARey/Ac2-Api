package com.example.demo.Exceptions;

public class RegraNegocioException extends RuntimeException{
    
    public RegraNegocioException(String mensagemErro) {
        super(mensagemErro);
        }
}
