import java.util.Scanner;
import java.util.Stack;

class StackClass {
    Stack<String> chest;
    int limit;

    public StackClass(int limit)
    {
        chest = new Stack<>();
        this.limit = limit;
    }

    public void addItem(String item)
    {
        if (chest.size() >= limit)
        {
            System.out.println("Chest is full");
            return;
        }
        chest.push(item);
        System.out.println(item + " added to the chest.");
    }

    public void removeItem()
    {
        String removed = chest.pop();
        System.out.println(removed + " removed from the chest.");
    }

    public void showChest() {
        System.out.println("The Chest contains: " + chest);
    }

    public int size() {
        return chest.size();
    }

    public int getLimit() {
        return limit;
    }
}

public class Day12_Stack
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int limit = 3;
        StackClass chest = new StackClass(limit);

        while (true)
        {
            System.out.println("Choose an option:\n1. Add item\n2. Remove item\n3. Show Chest\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            if (choice == 4) {
                break;
            }
            else if (choice == 1)
            {
                if (chest.size() >= chest.getLimit())
                {
                    System.out.println("Chest is full");
                }
                else
                {
                    System.out.print("Enter the item to add: ");
                    String item = sc.nextLine();
                    chest.addItem(item);
                }
            }
            else if (choice == 2) {
                chest.removeItem();
            }
            else if (choice == 3) {
                chest.showChest();
            }
            else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
        sc.close();
    }
}
