package com.userModule.registrationService.Logic;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Author : Rohit Parihar
 * Date : 11/25/2022
 * Time : 3:39 PM
 * Class : logicProcessor
 * Project : Bloggios-Backend
 */

@Component
public class logicProcessor {

    public String capitalizeLetter(String input) {
        StringBuffer name = new StringBuffer();
        Arrays
                .stream(input
                        .replaceAll("\\s+", " ")
                        .trim()
                        .split(" "))
                .collect(Collectors.toList())
                .forEach(e -> {
                    String finalName = e.substring(0,1).toUpperCase() + e.substring(1);
                    name.append(finalName).append(" ");
                });
        return name
                .toString()
                .trim();
    }
}
