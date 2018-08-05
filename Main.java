import java.util.*;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.M;

public class Main {
    public static void main(String [] args) {
        //создаём животных, используя getters
        // через конструкторы оно не работает, поэтому такие вот костылики (я хз почему так @___@)

        Dog a = new Dog();
        a.setColour("рыжий");
        a.setOwner("no");
        a.setName("");
        a.getName();
        a.getColour();
        a.getOwner();

        Dog b = new Dog();
        b.setColour("чёрный");
        b.setOwner("no");
        b.setName("Баян");
        b.getColour();
        b.getOwner();

        Cat c = new Cat();
        c.setColour("рыжий");
        c.setOwner("yes");
        c.setName("Васян");
        c.getOwner();
        c.getColour();

        Cat d = new Cat();
        d.setColour("рыжий");
        d.setOwner("no");
        d.setName("Васян");
        d.getOwner();
        d.getColour();

        Dog t = new Dog();
        t.setColour("рыжий");
        t.setOwner("no");
        t.setName("Volyna");
        t.getName();
        t.getColour();
        t.getOwner();

        //создаём базу данных по животным и добавляем их - коллекция 1

        List<Animal> animal_data = new ArrayList<>();
        animal_data.add(a);
        animal_data.add(b);
        animal_data.add(c);
        animal_data.add(d);
        animal_data.add(t);
        //System.out.println(animal_data);

        // создаём базу данных приюта (только бездомные животные) - коллекция 2
        List<Animal> stray = animal_data.stream()
                .filter(s ->"no".contentEquals(s.getOwner()))
                .collect(Collectors.toList());
        System.out.print("В приюте находятся: " + stray);

        //обрабатываем запрос "Мама, хочу рыжую собаку!"
        // ищем рыжих животных

        List<Animal> red_animals = stray.stream()
                .filter(w -> "рыжий".contentEquals(w.getColour()))
                .collect(Collectors.toList());
        System.out.print("\nВот рыжие животные: " + red_animals);

        //выбираем собаку
        for(Animal chosen : red_animals) {
            if(chosen.getClass().equals(Dog.class)) {
                System.out.print("\nВы можете забрать:" + chosen);
            }
        }



    }
}

