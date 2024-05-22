/*
 *@Auther: Siyanda S Ntuli
 *Email: siyandasec25@gmail.com
 *Topic: Quadratic Probing
*/

import java.util.*;

public class SearchSuggestionsSystem {
    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";

        ArrayList<ArrayList<String>> suggestions = suggestedProducts(products, searchWord);

        for (List<String> suggestion : suggestions) {
            System.out.println(suggestion);
        }
    }

    static ArrayList<ArrayList<String>> suggestedProducts(String[] products, String searchWord) {
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();
        Arrays.sort(products);

        StringBuilder sbProd = new StringBuilder();

        for (char ch : searchWord.toCharArray()) {
            sbProd.append(ch);
            ArrayList<String> newWords = new ArrayList<>();

            for (String product : products) {
                StringBuilder sbSW = new StringBuilder();
                char[] charProd = product.toCharArray();

                for (int i = 0; i < charProd.length; i++) {
                    sbSW.append(charProd[i]);
                    String strProd = sbProd.toString();
                    String strSW = sbSW.toString();

                    if (strProd.equalsIgnoreCase(strSW)) {
                        if (newWords.size() < 3) {
                            newWords.add(product);
                        }
                    }
                }
            }

            listOfLists.add(newWords);
        }

        return listOfLists;
    }
}
