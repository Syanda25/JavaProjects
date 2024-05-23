/*
 *@Auther: Siyanda S Ntuli
 *Email: siyandasec25@gmail.com
 *Topic: Search Suggestions System 2

 example:   products = {"dbc", "acd", "abc", "abcd", "abdc", "a", "acbd"}
	  	    searchWord = "acd"

		Array.sort(products);
		products = {"a", "abc", "abcd", "abdc", "acd", "acbd", "dbc"}

		char[0] = 'a' => searchWord = "a"
		char[1] = 'c' => searchWord = "ac"
		char[2} = 'd' => dearchWprd = "acd"
		
		Input   :Output
		"a" => 	{"a", "abc", "abcd"}
		"ac" =>	{"a", "acd", "acbd"}
		"acd"=>	{"a", "acd"}

*/

import java.util.*;
class SearchSuggestion{
    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";

        ArrayList<ArrayList<String>> suggestions = searchSuggestion(products, searchWord);

        for (List<String> suggestion : suggestions) {
            System.out.println(suggestion);
        }
    }
    
    static ArrayList<ArrayList<String>> searchSuggestion(String[] products, String searchWord){
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();
        Arrays.sort(products);
        StringBuilder sbSW = new StringBuilder();
        char[] chSWs = searchWord.toCharArray();
        int counter = 0;
        
        for(char chSW: chSWs){
            sbSW.append(chSW);
            ArrayList<String> matchingProd = new ArrayList<>();
            for(String product: products){
                StringBuilder sbProd = new StringBuilder();
                char[] chProds = product.toCharArray();
                
                if(chProds.length<=counter){
                    StringBuilder temp = new StringBuilder();
                    for(int i=0; i<chProds.length; i++){
                        temp.append(chSWs[i]);
                        sbProd.append(chProds[i]);
                    }
                        
                    if((temp.toString()).equalsIgnoreCase(sbProd.toString())){
                        if(matchingProd.size()<3){
                            matchingProd.add(product);
                        }
                    }
                }else{
                    for(int i=0; i<=counter; i++){
                        sbProd.append(chProds[i]);
                    }
                    if((sbSW.toString()).equalsIgnoreCase(sbProd.toString())){
                        if(matchingProd.size()<3){
                            matchingProd.add(product);
                        }
                    }
                }
            }
            counter++;
            listOfLists.add(matchingProd);
        }
        return listOfLists;
    }
}