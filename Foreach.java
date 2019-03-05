import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

//Credit: https://www.journaldev.com/2389/java-8-features-with-examples
public class Foreach {

    public static void main(String[] args)
    {
        List<Integer> integerList = new ArrayList<>();

        for (int i=0; i<20; i++) integerList.add(i);

        Iterator<Integer> iterator = integerList.iterator(); //old Style.

        while (iterator.hasNext()) // old style iterator.
        {
            Integer num = iterator.next();

            System.out.println("Output from old style iterator: " + num);
        }


        integerList.forEach(new Consumer<Integer>(){
            @Override
            public void accept(Integer i)
            {
                System.out.println("Output from new style anonymous consumer class implementation: " + i);
            }
        });

        integerList.forEach(i -> System.out.println("Output from lambda: "+i));

        ConsumerImpl consumerImpl = new ConsumerImpl();

        integerList.forEach(consumerImpl);
    }

    static class ConsumerImpl implements Consumer<Integer>
    {
        @Override
        public void accept(Integer i)
        {
            System.out.println("Output from new style consumer class implementation: " + i);
        }

    }
}
