package edu.pw.parser;

import java.util.Arrays;
import java.util.List;

public enum StandardFunction {
    PRINT("print"), TO_TEXT("toText"), LOAD_IMAGE("loadImage"), LOAD_TEXT("loadText"),
    COUNT_WORDS("countWords"), COUNT_PARAGRAPHS("countParagraphs"), COMPARE("compare"),
    OCR("ocr");

    private final String id;

    StandardFunction(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static boolean isStandard(String functionId){
        List<StandardFunction> standardLib = Arrays.asList(StandardFunction.values());
        for (StandardFunction function : standardLib) {
            if (function.getId().equals(functionId)) return true;
        }
        return false;
    }
}
