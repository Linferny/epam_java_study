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
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class HtmlParser {
    public HtmlParser() {
    }

    public String[] parse() {
        //PATTERN div/p tags:
        //"<(div|p)>.+</(div|p)>"
        //PATTERN for all tags and inside:
        //<[/]?\w+((\s+\w+(\s*=\s*(?:".*?"|'.*?'|[\^'">\s]+))?)+\s*|\s*)[/]?>

        //PATTERN for sentences:
        //(\s|э[.]д[.]с[.]?|[А-яё,()0-9-–»«+=])*(([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\s*(\d+(-?[a-zа-я]?[,]?)+)+[)]?)(э[.]д[.]с[.]?|(([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\s*(\d+(-?[a-zа-я]?[,]?)+)+[)]?)|[А-яё,()0-9-–»«+=]|\s)*[.?!]

        String textTagsRegex = "<(div|p)>.+</(div|p)>";
        String tagRegex = "<[/]?\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[\\^'\">\\s]+))?)+\\s*|\\s*)[/]?>";
        String sentenceRegex = "(\\s|э[.]д[.]с[.]?|[А-яё,()0-9-–»«+=])*" +
                "(([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\\s*(\\d+(-?[a-zа-я]?[,]?)+)+[)]?)" +
                "(э[.]д[.]с[.]?|(([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\\s*(\\d+(-?[a-zа-я]?[,]?)+)+[)]?)|[А-яё,()0-9-–»«+=]|\\s)*[.?!]";

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

    public boolean checkForOrder(String[] sentences) {
        //PATTERN for image:
        //(([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\s*(\d+(-?[a-zа-я]?[,]?)+)+[)]?)

        if (sentences.length < 1)
            return false;

        StringBuilder allSentences = new StringBuilder();
        Arrays.stream(sentences).forEach(allSentences::append);

        Pattern imgPattern = Pattern.compile("(([(]?[Рр]ис[.]|[Рр]исун(ке|ка))\\s*(\\d+(-?[a-zа-я]?[,]?)+)+[)]?)");
        Pattern numPattern = Pattern.compile("\\d+");

        int curNum;
        int maxNum = -1;

        Matcher matcher = imgPattern.matcher(allSentences);
        while (matcher.find()) {
            Matcher numMatch = numPattern.matcher(matcher.group());
            while (numMatch.find()) {
                curNum = Integer.parseInt(numMatch.group());

                if (curNum > maxNum) {
                    if (maxNum == -1 || curNum == maxNum + 1)
                        maxNum = curNum;
                    else
                        return false;
                }

            }
        }

        return true;
    }

    private String readHtml() {
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
        } catch (NullPointerException e) {
            System.out.println("ERR: Null resource");
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
OBSOLED:

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