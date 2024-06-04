package com.aluracursos.screenmatch.screenmatch_v3.service;

public interface IDataConversor {
    <T> T getData(String json, Class<T> tClass);
}
