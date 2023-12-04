package uz.shukrullaev.com;

/**
 * @author Abdulloh
 * @see uz.shukrullaev.com
 * @since 12/4/2023 7:33 PM
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    }

}
