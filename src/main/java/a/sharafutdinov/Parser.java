package a.sharafutdinov;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by innopolis on 08.02.17.
 */
public class Parser {

    /**
     * Входные данные
     */
    private Scanner input;

    /**
     * Конструктов
     * @param input входные данные
     */
    public Parser(Scanner input) {
        this.input = input;
    }

    /**
     * Возвращает следующее слово,
     * если найдена латинница выбрасывает исключение ParserErrorException
     * @return следующее слово
     * @throws ParserErrorException в случае, если есть латинские буквы
     */
    public String getNext() throws ParserErrorException {
        if (input.hasNext()) {
            String s = input.next();
            s = s.replaceAll(",|\\.|!|\\?", "");
            Pattern p = Pattern.compile("[А-яЁё][-А-яЁё]+");
            Matcher m = p.matcher(s);
            if (!m.matches()) {
                throw new ParserErrorException(s);
            }

            return s;
        } else {
            input.close();
        }

        return null;
    }
}
