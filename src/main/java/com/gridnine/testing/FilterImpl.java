package com.gridnine.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для применения правил фильтрации
 */
public class FilterImpl implements Filter{
    private List<Rule> ruleList = new ArrayList<>();

    /**
     *  Добавление в список действующих фильтров нового фильтра
     *
     * @param rule Правило фильтрации
     */
    @Override
    public void addRule(Rule rule) {
        ruleList.add(rule);
    }

    /**
     * Добавление нескольких правил фильтрации
     * @param rules правила для фильтрация
     */
    @Override
    public void addAllRules(Rule ... rules){
        ruleList.addAll(Arrays.asList(rules));
    }

    /**
     * Добавление нескольких правил фильтрации
     * @param rules правила для фильтрация
     */
    @Override
    public void addAllRules(List<Rule> rules){
        ruleList.addAll(rules);
    }

    /**
     * Очистить список фильтров
     */
    @Override
    public void clearRules(){
        ruleList.clear();
    }

    /**
     * Фильтрация списка перелетов, по заданным фильтрам
     *
     * @param flights Список перелетов для фильтрации
     * @return Отфильтрованный список перелетов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = flights;
        for(Rule rule: ruleList){
            result = result.stream()
                    .filter(rule::check)
                    .collect(Collectors.toList());
        }
        return result;
    }
}
