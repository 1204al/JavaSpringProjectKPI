package com.glossary.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println(words);

        return "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCc";

    }

}
