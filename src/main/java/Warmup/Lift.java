package Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Lift {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader reader = new BufferedReader(new FileReader("1.txt"));
        int sizeLift = Integer.parseInt(reader.readLine());
        int countFloor = Integer.parseInt(reader.readLine());

        int[] countPeopleFloor = new int[countFloor];
        for (int i = 0; i < countFloor; i++) {
            countPeopleFloor[i] = Integer.valueOf(reader.readLine());
        }

        BigInteger sumSec = BigInteger.ZERO;
        int floor = countFloor-1;
        while ( floor >= 0 ) {

            while (floor >= 0 && countPeopleFloor[floor] == 0) floor--;

            BigInteger sec = BigInteger.valueOf((floor+1)*2);
            BigInteger secC = sec.add(sumSec);
            sumSec = secC;
            int countPeople = sizeLift;
            while (countPeople > 0 && floor >= 0) {

                if (floor >= 0 && countPeopleFloor[floor] == 0) {
                    floor--;
                }
                else {
                    if (countPeopleFloor[floor] >= sizeLift) {
                        countPeopleFloor[floor] -= countPeople;
                        countPeople = 0;
                        int k = countPeopleFloor[floor] / sizeLift;
                        long arg1 =(floor + 1) * 2;
                        long arg2 = k * arg1;
                        sec = BigInteger.valueOf(arg2);
                        sumSec = sumSec.add(sec);
                        countPeopleFloor[floor] = countPeopleFloor[floor] % sizeLift;
                    } else if (countPeopleFloor[floor] > countPeople) {
                        countPeopleFloor[floor] -= countPeople;
                        countPeople = 0;
                    } else {
                        countPeople -= countPeopleFloor[floor];
                        countPeopleFloor[floor--] = 0;
                    }
                }

            }
        }

        System.out.println(sumSec);
    }
}

