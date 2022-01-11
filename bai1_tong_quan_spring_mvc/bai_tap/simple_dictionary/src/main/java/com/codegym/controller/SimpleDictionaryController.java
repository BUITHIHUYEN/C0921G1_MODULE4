package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
@Controller
public class SimpleDictionaryController {
    @GetMapping({"","/dictionary"})
    public String dictionary() {
        return "index";
    }

    @PostMapping({"","/dictionary"})
    public String simpleDictionary(@RequestParam String search, Model model) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("hello", "xin chào");
        stringMap.put("how", "Thế nào");
        stringMap.put("book", "Quyển vở");
        stringMap.put("computer", "Máy tính");
        stringMap.put("telephone","điện thoại");
        stringMap.put("street","đường");
        stringMap.put("tree","cây");
        for (Map.Entry<String,String> entry: stringMap.entrySet()) {
//            return entry.getKey() +""+ entry.getValue();
            if(search.equals(entry.getKey())){
                model.addAttribute("result", entry.getValue());

            }
        }
        return "index";
    }
}
