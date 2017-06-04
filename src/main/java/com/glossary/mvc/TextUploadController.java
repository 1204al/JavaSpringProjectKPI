package com.glossary.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by aliubivyi on 31.05.17.
 */
@Controller
public class TextUploadController {

    @RequestMapping(value = "/uploadText", method = RequestMethod.POST)
    public @ResponseBody
    String handleTextUpload(@RequestParam("text") String text) {
        String[] parts = (text + " ").split("\\p{P}?[ \\t\\n\\r]+");
        List<String> words=Arrays.asList(parts);
        TreeMap<String, Integer> wordsFrequency = new TreeMap<String, Integer>();  // key:words; value:times the word comes across in the book
        for (int i = 0; i < words.size(); i++) {
            String s=words.get(i).toLowerCase();
            if(wordsFrequency.containsKey(s)){
                wordsFrequency.put(s,wordsFrequency.get(s)+1);
            }else{
                wordsFrequency.put(s,1+1);
            }
        }
        class WordFrequency implements Comparable{
            public WordFrequency(String word, int frequency) {
                this.word = word;
                this.frequency = frequency;
            }
            public String word;
            public int frequency;
            @Override
            public int compareTo(Object o) {
                return this.frequency-((WordFrequency) o).frequency;
            }
        }

        List<WordFrequency> listOfWordFrequencies=new ArrayList<WordFrequency>();
        for (Map.Entry<String,Integer> entry:wordsFrequency.entrySet()) {
            String word=entry.getKey();
            Integer frequency=entry.getValue();
            listOfWordFrequencies.add(new WordFrequency(word,frequency));
        }
        List<String> listOfWords=new ArrayList<>();
        for (int i = 0; i < listOfWordFrequencies.size(); i++) {
            listOfWords.add(listOfWordFrequencies.get(i).word);
        }
        System.out.println(listOfWords);




        return "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCc";

    }

}
