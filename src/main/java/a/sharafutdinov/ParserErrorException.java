package a.sharafutdinov;

/**
 * Created by innopolis on 08.02.17.
 */
public class ParserErrorException extends Exception {

    /**
     * Конструктор
     * @param s строка сообщения
     */
    public ParserErrorException(String s) {
        super("Неверные данные: '" + s + "'");
    }
}
