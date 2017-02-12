package a.sharafutdinov;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by innopolis on 11.02.17.
 */
public class ResourceReader {

    /**
     *  Чтение ресурсов
     */
    private Parser parser;

    /**
     * Распорядитель ресурсов
     */
    private Manager m;

    /**
     * Конструктор
     * @param resource ресурс - путь до файла
     * @param m распорядитель ресурсов
     * @throws FileNotFoundException, если ресурс не найден
     */
    public ResourceReader(String resource, Manager m) throws FileNotFoundException {
        InputStream stream = getStream(resource);
        if (stream == null) {
            throw new FileNotFoundException();
        }

        this.parser = new Parser(new Scanner(stream));
        this.m = m;
    }

    /**
     * Чтение ресурсов
     * Если найдены латинские буквы, то распорядитель меняет флаг
     * и потоки останавливаются
     */
    public void read() {
        String val = null;
        try {
            while ((val = parser.getNext()) != null && m.isChFlag()) {
                m.add(val);
            }
        } catch (ParserErrorException e) {
            System.out.println(e.getMessage());
            m.setChFlag(false);
        }
    }

    /**
     * Возвращает поток данных соответствующего ресурса
     * @param path ресурс - путь до файла
     * @return потом данных для чтения
     */
    private InputStream getStream(String path) {
        URL url;

        url = getClass().getResource(path);
        if (url == null) {
            System.out.println("Ошибка чтения файла ресурса:" + path);
            return null;
        }


        try {
            return url.openStream();
        } catch (IOException e) {
            System.out.println("Ошибка при работе с ресурсом:" + path);
        }

        return null;
    }
}
