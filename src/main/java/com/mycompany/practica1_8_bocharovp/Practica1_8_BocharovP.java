/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica1_8_bocharovp;

/**
 *
 * @author pankr
 */
import java.util.Map.Entry;
import java.util.*;

public class Practica1_8_BocharovP {
    public static void main(String[] args) {
        TreeMap<String, List<String>> dictionary = new TreeMap<>();

        Scanner input = new Scanner(System.in);

        dictionary.put("Abdication", Arrays.asList("отречение", "отказ", "сложение полномочий"));
        dictionary.put("Aperitif", Collections.singletonList("аперитив"));
        dictionary.put("Mead", Arrays.asList("мёд", "луг"));
        dictionary.put("Zizz", Collections.singletonList("жужжание"));

        System.out.println("1 - добавить слово, 2 - удалить слово, 0 - выйти");

        int flag = input.nextInt();

        while (flag != 0) {
            if (flag == 1) {
                System.out.println("Введите слово на английском ");
                String word = input.next();
                System.out.println("Введите перевод, если несколько, то через запятую");
                String translationInput = input.next();
                List<String> translations = Arrays.asList(translationInput.split(", "));
                if (dictionary.containsKey(word)) {
                    List<String> ifWordExists = dictionary.get(word);
                    translations.forEach(ifWordExists::add);
                } else {
                    dictionary.put(word, translations);
                }
                for (Entry<String, List<String>> entry : dictionary.entrySet()) {
                    List<String> translationsPrint = entry.getValue();
                    Collections.sort(translationsPrint);
                    System.out.println(entry.getKey() + " - " + translationsPrint);
                }
                System.out.println("1 - добавить слово, 2 - удалить слово, 0 - выйти");
                flag = input.nextInt();
            } else if (flag == 2) {
                System.out.println("Введите слово на англйском ");
                String word = input.next();
                if (dictionary.containsKey(word)) {
                    dictionary.remove(word);
                    System.out.println("Слово удалено");
                } else {
                    System.out.println("Такого слова нет");
                }
                for (Entry<String, List<String>> entry : dictionary.entrySet()) {
                    List<String> translationsPrint = entry.getValue();
                    Collections.sort(translationsPrint);
                    System.out.println(entry.getKey() + " - " + translationsPrint);
                }
                System.out.println("1 - добавить слово, 2 - удалить слово, 0 - выйти");
                flag = input.nextInt();
            }
        }
    }
}