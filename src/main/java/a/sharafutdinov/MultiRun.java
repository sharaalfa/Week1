package a.sharafutdinov;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by innopolis on 08.02.17.
 */
public class MultiRun {
    /**
     * Логгирование
     */
    private static final Logger logger = Logger.getLogger(MultiRun.class);

    /**
     * Потоки
     */
    private ArrayList<Thread> threads = new ArrayList<Thread>();

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
        PropertyConfigurator.configure("src/main/resources/log4j.xml");
    }

    /**
     * @param resources - путь до файла
     */
    public void work(String[] resources) {

        for (String resource: resources) {
            try {
                final ResourceReader reader = new ResourceReader(resource, this.m);
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        reader.read();
                    }
                });
                threads.add(thread);
            } catch (ParserErrorException e) {
                logger.error("Ошибка с чтением ресурса", e);
                return;
            }
        }

        logger.info("Запуск потоков в количестве" + threads.size());
        for (Thread thread: threads) {
            thread.start();
        }

        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                logger.error("Ошибка при работе с потоками");
            }
        }
    }
}
