package a.sharafutdinov;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;

/**
 * Created by innopolis on 08.02.17.
 */
public class Manager {
    /**
     *  Логгирование
     */

    private static final Logger logger = Logger.getLogger(Manager.class);
    /**
     * Результат операции
     */
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    /**
     * Флаг, используется для остановки потоков
     * в случае ошибки при мультипоточной обработке
     */
    private boolean chFlag = true;

    /**
     *  Инициализация
     */

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.xml");
    }

    /**
     * Добавляет элемент в обработку
     * @param wrd входной элемент
     */
    public synchronized void add(String wrd) {
        Integer countWord;
        countWord = map.get(wrd);
        if(countWord==null){
            map.put(wrd, 1);} else{
            map.put(wrd, countWord=countWord+1);}
        //map.put(wrd, countWord == null ? 1 : countWord + 1);
        logger.trace(map);
    }

    /**
     * Возвращает результат обработки данных
     * @return результат обработки
     */
    public HashMap getResult() {
        return map;
    }

    /**
     * Активен ли обработчик
     * @return флаг активности
     */
    public boolean isChFlag() {
        return chFlag;
    }

    /**
     * Установка флага активности обработчика
     * @param flag флага активности
     */
    public synchronized void setChFlag(boolean flag) {
        chFlag = flag;
    }
}
