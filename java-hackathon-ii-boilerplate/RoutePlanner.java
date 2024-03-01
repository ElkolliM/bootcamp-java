import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RoutePlanner {


    // Source City, Destination City, Distance in kms, Typical flight time, Typical ticket cost


    private String[] routes ;
    public  String[] extractData(String fileName ){

        try{
            BufferedReader abc = new BufferedReader(new FileReader(fileName));
            List<String> list = new ArrayList<>();
            String line ;
            while(( line = abc.readLine()) != null) {
                list.add(line);


            }
            abc.close();
            routes = new String[list.size()];
            int index =0;
            // copy of the list to an array
            for(String i : list) routes[index++] = i;
        } catch (Exception e){

        }
        return routes;
    }

    String[]showDirectFlights(String[] routeInfo, String fromCity) {

        List<String> result = new ArrayList<>();
        List<String> destinations  = new ArrayList<>();

        for (int i = 0; i < routeInfo.length; i++) {


            String[] data = routeInfo[i].split(", ");


            if (data[0].equalsIgnoreCase(fromCity)) {
                result.add(routeInfo[i]);
                // add just the destination city from 'fromCity'
                destinations.add(data[1]);


            }
        }
        // sort the destination
        destinations = destinations.stream().sorted().toList();
        String[] sorted = new  String[result.size()];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = destinations.get(i);
        }

        for(int j=0; j < result.size(); j++){
            int finalJ = j;
            sorted[j] = result.stream().
                    filter(city -> city.split(", ")[1].equalsIgnoreCase(sorted[finalJ]))
                    .findFirst().orElse(null);
        }

        if(sorted.length == 0){
            System.out.println( "We are sorry. At this point in time we do not have any information" +
                    " on flights in the specified route");
        }


        return sorted;


    }

    public static void main(String[] args) {

        String file = "sample-inputs.txt";

        RoutePlanner planner = new RoutePlanner();
        String[] t = planner.extractData(file);

        String[] res = planner.showDirectFlights(t,"Delhi");

        for(String c : res)
            System.out.println(c);
    }



}
