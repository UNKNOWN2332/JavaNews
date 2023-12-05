package uz.shukrullaev;

/**
 * @author Abdulloh
 * @see uz.shukrullaev.com
 * @since 12/4/2023 7:33 PM
 */

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

// Интерфейс компонента
interface Department {
    void printDepartmentName();
}

// Конкретный компонент
class ConcreteDepartment implements Department {
    private String name;

    public ConcreteDepartment(String name) {
        this.name = name;
    }

    @Override
    public void printDepartmentName() {
        System.out.println("Department: " + name);
    }
}

// Композит, содержащий другие компоненты (могут быть как конкретные департаменты, так и другие композиты)
class CompositeDepartment implements Department {
    private String name;
    private List<Department> subDepartments;

    public CompositeDepartment(String name) {
        this.name = name;
        this.subDepartments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        subDepartments.add(department);
    }

    @Override
    public void printDepartmentName() {
        System.out.println("Composite Department: " + name);

        // Используем итератор для обхода подразделений
        Iterator<Department> iterator = subDepartments.iterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            department.printDepartmentName();
        }
    }
}

public class IteratorCompositeExample {
    public static void main(String[] args) {
        // Создаем структуру композита
        CompositeDepartment root = new CompositeDepartment("Root");

        ConcreteDepartment leaf1 = new ConcreteDepartment("Leaf 1");
        ConcreteDepartment leaf2 = new ConcreteDepartment("Leaf 2");

        CompositeDepartment composite1 = new CompositeDepartment("Composite 1");
        ConcreteDepartment leaf3 = new ConcreteDepartment("Leaf 3");
        ConcreteDepartment leaf4 = new ConcreteDepartment("Leaf 4");

        CompositeDepartment composite2 = new CompositeDepartment("Composite 2");
        ConcreteDepartment leaf5 = new ConcreteDepartment("Leaf 5");

        // Строим иерархию
        root.addDepartment(leaf1);
        root.addDepartment(leaf2);

        composite1.addDepartment(leaf3);
        composite1.addDepartment(leaf4);

        composite2.addDepartment(leaf5);

        root.addDepartment(composite1);
        root.addDepartment(composite2);

        // Используем итератор для обхода всей структуры
        root.printDepartmentName();


        System.out.println("######################################");
        try {
            throwsConcurrentExceptionVersion();
        } catch (ConcurrentModificationException e) {
            System.out.println("Concurrent exception boldi ");
        }
        System.out.println("######################################");


        testCycleAndStopWhenCycled();


    }

    private static void testCycleAndStopWhenCycled() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> submit = executor.submit(IteratorCompositeExample::testCycleVersion);
        System.out.println("START");
        try {
            submit.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            submit.cancel(true);
            System.out.println("Time outga tushdi tsikl bop");
            System.exit(1);
        }
    }

    public static void throwsConcurrentExceptionVersion() {
        // Создаем структуру композита
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        for (String value : list) {
            System.out.println(value);
            // Производим изменение коллекции в процессе итерации (например, добавление нового элемента)
            list.add("New Item");  // Это вызовет ConcurrentModificationException
        }

    }

    public static void testCycleVersion() {
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            System.out.println(item);
            // Производим изменение коллекции в процессе итерации (например, добавление нового элемента)
            list.add("New Item");  // ConcurrentModificationException не будет выброшено но будет цикляться
        }
    }
    /**
     * Iterator pattern - iterator pattern bu bizning collectionlarimiz ustida olib boradigon
     * manipulatsya qiladigon jaryonimzada ConcurrentModificationException exception chiqish yoki
     * tsiklga tushib qolish oldini olish uchun ishlatiladigon pattern bu pattern kodimizni dynamic
     * toza va design patternga mos holda bolib va bu OOP inkapsulyatsya turiga mansub
     * biz iterator orqali concurrent oldini olish tsikl tushish oldini olish uchun ishlatamiz
     * */
}
