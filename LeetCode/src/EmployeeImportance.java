import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        Employee targetEmployee=null;
        for(int i=0;i<employees.size();i++)
        {
            if(employees.get(i).id==id)
            {
                targetEmployee=employees.get(i);      // first get the target employee whose importance is to be calculated
            }
        }
        Stack<Employee> stack=new Stack<Employee>();
        for(int i=0;i<employees.size();i++)
        {
            if(targetEmployee.subordinates.contains(employees.get(i).id))    // push all the subordinates for that employee in a stack
            {
                stack.push(employees.get(i));
            }
        }
        while(!stack.isEmpty())
        {
            Employee poppedEmployee=stack.pop();                 // until the stack becomes empty pop the employee from the stack and add its importance to our target employee
            targetEmployee.importance+=poppedEmployee.importance;
            if(!poppedEmployee.subordinates.isEmpty())           // check whether the employee that is popped from stack has other subordinates
            {
                for(int i=0;i<poppedEmployee.subordinates.size();i++)   // if yes then match the id of the subordinate to out list of employees and push this employee on stack
                {
                    for(int j=0;j<employees.size();j++)
                    {
                        if(poppedEmployee.subordinates.get(i)==employees.get(j).id)
                        {
                            stack.push(employees.get(j));
                        }
                    }
                }
            }
        }
        return targetEmployee.importance;
    }

    public static void main(String[] args) {

    }
}
