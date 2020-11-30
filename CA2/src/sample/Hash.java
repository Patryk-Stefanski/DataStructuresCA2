package sample;

import java.util.Arrays;

public class Hash {

    int currentSize = 0;
    int arraySize = 31;
    Politician[] politiciansArray = new Politician[arraySize];





    public void politicianHashFunction(Politician politician, Politician[] politiciansArray) {


        int hashIndex = -1;




            for (int i = 0; i < politician.getPoliticianName().length(); i++) {
                hashIndex = hashIndex + politician.getPoliticianName().charAt(i);
                currentSize++;
            }
            hashIndex = hashIndex % arraySize;

            System.out.println("Modulus Index= " + hashIndex + " for value " + politician);

            while (politiciansArray[hashIndex] != null) {

                ++hashIndex;

                System.out.println("Collision Try " + hashIndex + " Instead");

                // If we get to the end of the array go back to index 0

                hashIndex %= arraySize;

            }
            politiciansArray[hashIndex] = politician;

        }


    public void reHash() {
        int hashIndex = -1;
        if (currentSize == arraySize) {
            Politician[] reHashPolitician = new Politician[arraySize * 2];

            for (int i = 0; i < reHashPolitician.length; i++) {

            }
        }
    }





    public Politician findKey(String key) {
        int hashIndex = -1;
        // Find the keys original hash key
        for (int i = 0; i < key.length(); i++) {
            hashIndex = hashIndex + key.charAt(i);
            currentSize++;
        }
        int arrayIndexHash = hashIndex % 31;

        while (politiciansArray[arrayIndexHash] != null) {
            if (politiciansArray[arrayIndexHash].getPoliticianName().equals(key)) {
                // Found the key so return it
                System.out.println(key + " was found in index " + arrayIndexHash);
                return politiciansArray[arrayIndexHash];
            }
            // Look in the next index
            ++arrayIndexHash;
            // If we get to the end of the array go back to index
            arrayIndexHash %= arraySize;
        }
        // Couldn't locate the key
        return null;
    }

    public void fill(Politician[] politiciansArray){
        Politician p = null;
        Arrays.fill(politiciansArray, p);
    }


}