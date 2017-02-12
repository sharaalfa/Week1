package a.sharafutdinov;

public class Main {

    public static void main(String[] args) {
        Manager m = new Manager();

        args = new String[]{
                "/data/1.txt",
                "/data/2.txt",
                "/data/3.txt",

        };
        multiThread(args, m);

        if (m.isChFlag()) {
            System.out.println("Итог = " + m.getResult());
        } else {
            System.out.println("Ошибка обработки ресурсов!");
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
