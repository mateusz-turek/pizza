package com.mat.pizza.JsonMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToJson {

    public ObjectMapper objectMapper;

    @Autowired
    public ToJson(ObjectMapper objectMapper) {
        this.objectMapper = new ObjectMapper();
    }

    public String parse(String argument) {

        StringBuilder valueToParse = new StringBuilder(argument);
        for (int i = 0; i < valueToParse.length(); i++) {
            if (valueToParse.charAt(i) == '(') {
                valueToParse.replace(i, i + 1, "*:[{*");
            }
            if (valueToParse.charAt(i) == ')') {
                valueToParse.replace(i, i + 1, "*}]}");
            }
            if (valueToParse.charAt(i) == '=') {
                valueToParse.replace(i, i + 1, "*:*");
            }
            if (valueToParse.charAt(i)== ',') {
                valueToParse.replace(i, i +1, "*");
            }
            if(valueToParse.charAt(i)==' '){
                valueToParse.replace(i,i+1,",*");
            }
        }
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append('"');
        json.append(valueToParse);

        for (int i = 0; i <json.length() ; i++) {
            if (json.charAt(i)=='1'){
                json.replace(i-1,i+2,"1");
            }
        }
        String jsonString = "";
        for (int i = 0; i < json.length(); i++) {
            if (json.charAt(i)=='['){
                jsonString = json.substring(i+1,json.length()-2);
            }
        }

        String output = jsonString;
        return output.replace('*','"');
    }
}
