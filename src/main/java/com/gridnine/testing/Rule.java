package com.gridnine.testing;

/**
 * Базовый интерфейс для правил фильтрации
 */
public interface Rule{
    boolean check(Flight flight);
}
