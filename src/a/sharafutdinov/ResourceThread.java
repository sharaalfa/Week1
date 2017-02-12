package a.sharafutdinov;

import java.io.FileNotFoundException;

/**
 * Created by innopolis on 08.02.17.
 */
public class ResourceThread extends Thread {

    /**
     * Чтение
     */
    private ResourceReader resourceReader;

    /**
     * Конструктор
     * @param resourceReader чтение
     */
    public ResourceThread(ResourceReader resourceReader) {
        this.resourceReader=resourceReader;
    }

    /**
     * Запуск потока
     */
    @Override
    public void run() {
        this.resourceReader.read();
    }
}
