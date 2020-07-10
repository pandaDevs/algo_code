package code.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GetImportance {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees) {
            map.put(employee.id, employee);
        }

        if(map.containsKey(id)) {
            return getImportance(map.get(id), map);
        }
        return 0;
    }

    private int getImportance(Employee employee, Map<Integer, Employee> map) {
        Queue<Employee> queue = new LinkedList<>();
        int total = 0;
        queue.offer(employee);
        while(!queue.isEmpty()) {
            Employee employee1 = queue.poll();
            total += employee1.importance;
            List<Integer> sub = employee1.subordinates;
            for(Integer id : sub) {
                if(map.containsKey(id)) {
                    queue.offer(map.get(id));
                }
            }
        }
        return total;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
