package javase03.t03.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class HtmlParser {
    public HtmlParser() {
    }

    public String[] parse() {
        //"<(div|p)>.+</(div|p)>"
        //<[/]?\w+((\s+\w+(\s*=\s*(?:".*?"|'.*?'|[\^'">\s]+))?)+\s*|\s*)[/]?>

        //([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\s*(\d+[,]?)+[)]?
        //(\s|э[.]д[.]с[.]?|[А-яё,()0-9-–»«+=])*(([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\s*(\d+[,]?)+[)]?)(э[.]д[.]с[.]?|([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\s+(\d+[,]?)+[)]?|[А-яё,()0-9-–»«+=]|\s)*[.?!]

        String textTagsRegex = "<(div|p)>.+</(div|p)>";
        String tagRegex = "<[/]?\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[\\^'\">\\s]+))?)+\\s*|\\s*)[/]?>";
        String sentenceRegex = "(\\s|э[.]д[.]с[.]?|[А-яё,()0-9-–»«+=])*(([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\\s*(\\d+[,]?)+[)]?)(э[.]д[.]с[.]?|([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\\s+(\\d+[,]?)+[)]?|[А-яё,()0-9-–»«+=]|\\s)*[.?!]";

        String html = readHtml();
        html = clearHtml(html);
        String[] sentences = parseByRegex(html, textTagsRegex);
        sentences = deletePattern(sentences, tagRegex);
        sentences = parseByRegex(sentences, sentenceRegex);
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].trim();
        }

        return sentences;
    }

    public boolean checkForOrder(String[] sentences){
        return true;
    }

    public String readHtml() {
        StringBuilder html = new StringBuilder();
        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource("javase03/t03/html").toURI());
            Files.lines(path, Charset.forName("CP1251")).forEach(line -> {
                html.append(line);
                html.append("\n");
            });
        } catch (URISyntaxException uriEx) {
            System.out.println("ERR: URI Exception!");
        } catch (IOException ioEx) {
            System.out.println("ERR: IO Exception!");
        }
        return html.toString();
    }

    private String clearHtml(String text) {
        Pattern pattern = Pattern.compile("<span>|</span>|<br>|&nbsp;");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("");
    }

    private String[] parseByRegex(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> parsed = new ArrayList<>();

        while (matcher.find()) {
            parsed.add(matcher.group());
        }
        return parsed.toArray(new String[0]);
    }

    private String[] parseByRegex(String[] text, String regex) {
        List<String> parsed = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        for (String s : text) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                parsed.add(matcher.group());
            }
        }
        return parsed.toArray(new String[0]);
    }

    private String[] deletePattern(String[] textWith, String regex) {
        Pattern pattern = Pattern.compile(regex);
        List<String> textWithout = new ArrayList<>();

        for (String text : textWith) {
            Matcher matcher = pattern.matcher(text);
            String s = matcher.replaceAll("");
            if (!s.equals(""))
                textWithout.add(s);
        }

        return textWithout.toArray(new String[0]);
    }
}


/*
Рисунок рис paser:
([(](рис[.]|pic[.]|Pic[.]|Рис[.])\s+\d+([a-bа-я]|[,-])*[)])|([Рр](исунке|исунок)\s\d+)

tags parse:
>.+<

<\w+((\s+\w+(\s*=\s*(?:".*?"|'.*?'|[\^'">\s]+))?)+\s*|\s*)>.*<[/]\w+((\s+\w+(\s*=\s*(?:".*?"|'.*?'|[\^'">\s]+))?)+\s*|\s*)>
or
.*<[/]\w+((\s+\w+(\s*=\s*(?:".*?"|'.*?'|[\^'">\s]+))?)+\s*|\s*)>|<\w+((\s+\w+(\s*=\s*(?:".*?"|'.*?'|[\^'">\s]+))?)+\s*|\s*)>.*

find tags
<[/]?\w+((\s+\w+(\s*=\s*(?:".*?"|'.*?'|[\^'">\s]+))?)+\s*|\s*)[/]?>

find &nbsp
&nbsp

 */