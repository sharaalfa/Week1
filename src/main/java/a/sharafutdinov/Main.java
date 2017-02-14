package a.sharafutdinov;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    /**
     * Логгирование
     */
    private static final Logger logger = Logger.getLogger(Main.class);

    /**
     * Инициализация
     */
    static {
        PropertyConfigurator.configure(
                "/home/innopolis/Yandex.Disk/Java_study/Week1/src/main/resources/log4j.xml");
    }

    public static void main(String[] args) {
        Manager m = new Manager();

        args = new String[]{
                "/data/1.txt",
                "/data/2.txt",
                "/data/3.txt",

        };
        multiThread(args, m);

        if (m.isChFlag()) {
            logger.trace("Итог = " + m.getResult());
        } else {
            logger.trace("Ошибка обработки ресурсов!");
        }
    }

    /**
     * Обработка ресурсов в многопоточном режиме
     * @param resources список ресурсов
     * @param m - распорялитель всех ресурсов
     */
    private static void multiThread(String[] resources, Manager m) {
        MultiRun multiRun = new MultiRun(m);
        multiRun.work(resources);
    }
}
