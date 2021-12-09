package Task23;

import com.google.gson.Gson;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.ArrayList;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        new Main().exe();
    }

    private void exe() {

        CallLog call1 = new CallLog("0663210000", 45);
        CallLog call2 = new CallLog("0502345656", 120);
        CallLog call3 = new CallLog("0671230033", 0);

        BidiMap<CallLog, Integer> wrongMap = new DualHashBidiMap<>();
        wrongMap.put(call1, 1);
        wrongMap.put(call2, 2);
        wrongMap.put(call3, 3);

        BidiMap<Integer, CallLog> correctMap = wrongMap.inverseBidiMap();

        System.out.println("Обращаемся к элементу коллекции через ключ. Получаем: " + correctMap.get(1).getTelNumber() +
                "\nОбращаемся к ключу через его значение. Получаем: " + correctMap.getKey(call1));


        Bag<CallLog> bag = new HashBag<>();
        bag.add(call1, 5);
        bag.add(call2, 3);
        bag.add(call3, 2);

        System.out.println("\nСколько раз в коллекции встречается данный объект: " + bag.getCount(call1) +
                "\nКоличество всех элементов: " + bag.size());

        Set<CallLog> unigeBag = bag.uniqueSet();

        for (CallLog callLog : unigeBag) {
            System.out.println(callLog.getTelNumber());
        }

        bag.remove(call1, 2);
        System.out.println("Количество элементов после удаления: " + bag.size());

        Gson gson = new Gson();
        String json1 = gson.toJson(call1);
        String json2 = gson.toJson(call2);
        String json3 = gson.toJson(call3);
        System.out.println(json1 + "\n" + json2 + "\n" + json3);

        CallLog call01 = gson.fromJson(json1, CallLog.class);
        CallLog call02 = gson.fromJson(json2, CallLog.class);
        CallLog call03 = gson.fromJson(json3, CallLog.class);
        System.out.println(call01.getTelNumber() + "\n" + call02.getTelNumber() + "\n" + call03.getTelNumber());

    }

    public CallLog createCallLog (ArrayList<String> telNumbers, int maxDuration){

        String telNumber = telNumbers.get((int) (Math.random()*telNumbers.size()));
        int duration = (int) (Math.random() * maxDuration);
        CallLog call = new CallLog(telNumber, duration);
        return call;
    }
}

