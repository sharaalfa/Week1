package a.sharafutdinov;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by innopolis on 08.02.17.
 */
public class MultiRun {

    /**
     * Потоки
     */
    private ArrayList<Thread> threads = new ArrayList<>();

    /**
     * Распорядитель ресурсов
     */
    private Manager m;

    /**
     * Конструктор
     * @param  m ресурсов
     */
    public MultiRun(Manager m) {
        this.m = m;
    }

    /**
     * @param resources - путь до файла
     */
    public void work(String[] resources) {

        for (String resource: resources) {
            try {
                ResourceReader reader = new ResourceReader(resource, this.m);
                Thread thread = new ResourceThread(reader);
                threads.add(thread);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        for (Thread thread: threads) {
            thread.start();
        }

        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка при работе с потоками");
            }
        }
    }
}
