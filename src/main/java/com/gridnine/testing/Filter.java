package com.gridnine.testing;

import java.util.List;

/**
 * Базовый интерфейс отвечающий за фильтрацию
 */
public interface Filter {
    /**
     * Добавление в список действующих фильтров нового фильтра
     *
     * @param rule Правило фильтрации
     */
    public void addRule(Rule rule);

    /**
     * Добавление нескольких правил фильтрации
     *
     * @param rules правила для фильтрация
     */
    public void addAllRules(Rule... rules);

    /**
     * Добавление нескольких правил фильтрации
     *
     * @param rules правила для фильтрация
     */
    public void addAllRules(List<Rule> rules);

    /**
     * Очистить список фильтров
     */
    public void clearRules();

    /**
     * Фильтрация списка перелетов, по заданным фильтрам
     *
     * @param flights Список перелетов для фильтрации
     * @return Отфильтрованный список перелетов
     */
    List<Flight> filter(List<Flight> flights);
}