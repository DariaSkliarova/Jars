package Task23;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class Main1 {

    static int value;

    public static void main(String[] args) {

        if (args.length == 0) {
            value = 1;
        } else {
            value = Integer.parseInt(args[0]);
        }
        Main1.exe1();
    }

    private static void exe1() {
        ArrayList<String> telNumbers = new ArrayList<>();
        telNumbers.add("0663210000");
        telNumbers.add("0508392773");
        telNumbers.add("0672894003");
        telNumbers.add("0931239898");
        telNumbers.add("0509283992");


        Collection<CallLog> collection = new ArrayList<>();
        for (int i = 0; i < value; i++) {
            CallLog call = createCallLog(telNumbers, value);
            collection.add(call);
        }

        Gson gson = new Gson();
        String jsonCalls = gson.toJson(collection);
        System.out.println("Json calls: " + jsonCalls);

        Type collectionType = new TypeToken<Collection<CallLog>>() {
        }.getType();
        Collection<CallLog> jsonCollection = gson.fromJson(jsonCalls, collectionType);
        System.out.println("\nCalls converted from Json: ");
        for (CallLog callLog : jsonCollection) {
            System.out.println(callLog.getTelNumber() + ": " + callLog.getDuration() + "sec.");
        }
    }

    public static CallLog createCallLog(ArrayList<String> telNumbers, int maxDuration) {

        String telNumber = telNumbers.get((int) (Math.random() * telNumbers.size()));
        int duration = (int) (Math.random() * maxDuration);
        CallLog call = new CallLog(telNumber, duration);
        return call;
    }
}
