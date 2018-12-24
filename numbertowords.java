/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
* This program has been perfectd upto 99,999
* Making it functional upto any number is very easy.
* Just keep adding to the nested "if" statements.
*/
package numbertowords;

import java.util.ArrayList; 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
/**
 *
 * @author dev-k
 * dev.kasibhatla@gmail.com
 */
public class NumberToWords {
int input, length = 0;
String words = "";
ArrayList<String> digits = new ArrayList<>();

 
    public String convertNumberToString(int in){        
        String intString = Integer.toString(in);        
        return intString;
    }
    
    public void handleSeperationOfDigits(int in){
        String intString = convertNumberToString(in);
        if(intString.length() > 0){            
            char[] temp = intString.toCharArray();
            for (int i=0; i<temp.length; i++){
                switch (temp[i]){
                    case '0':
                        digits.add("Zero");
                        break;
                    case '1':
                        digits.add("One");
                        break;
                    case '2':
                        digits.add("Two");
                        break;
                    case '3':
                        digits.add("Three");
                        break;
                    case '4':
                        digits.add("Four");
                        break;
                    case '5':
                        digits.add("Five");
                        break;
                    case '6':
                        digits.add("Six");
                        break;
                    case '7':
                        digits.add("Seven");
                        break;
                    case '8':
                        digits.add("Eight");
                        break;
                    case '9':
                        digits.add("Nine");
                        break;
                    default:
                        System.out.println("An error occured");                        
                }                
            }
            
        }
        else {
            System.out.println("Looks like an invalid number");
        }
    }
    
    public String processSeperatedDigits(){
        String t1 = "";
        int l = digits.size();
        int i = l -1;
        if (l == 1){
            words = digits.get(i);
        }
        else if (l > 1){
            t1 = processTensPlace(digits.get(i - 1), digits.get(i));
            words = t1 + words;
            if(l > 2){
                if(digits.get(i - 2) == "Zero"){}
                else{
                    words = digits.get(i - 2) + " Hundred " + words;
                }
                
                if (l == 4){
                    if(digits.get(i - 3) == "Zero"){}
                    else{
                      words = digits.get(i - 3) + " Thousand " + words; 
                    }                    
                }
                else if (l > 4){
                    t1 = processTensPlace(digits.get(i - 4), digits.get(i - 3));
                    words = t1 + " Thousand " + words;
                }
            }
            
        }
        return words;
    }
    
    public String processTensPlace(String tens, String units){
        String temp = "";
        if (units == "Zero"){
            units = "";
        }
        switch (tens){
            case "Zero":
                temp = units;
                break;
            case "One":
                switch (units){
                    case "":
                        temp += "Ten";
                        break;
                    case "One":
                        temp += "Eleven";
                        break;
                    case "Two":
                        temp += "Twelve";
                        break;
                    case "Three":
                        temp += "Thirteen";
                        break;
                    case "Four":
                        temp += "Fourteen";
                        break;
                    case "Five":
                        temp += "Fifteen";
                        break;
                    case "Six":
                        temp += "Sixteen";
                        break;
                    case "Seven":
                        temp+= "Seventeen";
                        break;
                    case "Eight":
                        temp += "Eighteen";
                        break;
                    case "Nine":
                        temp += "Nineteen";
                        break;
                    
                }
                break;
            case "Two":
                temp = "Twenty " + units;
                break;
            case "Three":
                temp = "Thirty " + units;
                break;
            case "Four":
                temp = "Forty " + units;
                break;
            case "Five":
                temp = "Fifty " + units;
                break;
            case "Six":
                temp = "Sixty " + units;
                break;
            case "Seven":
                temp = "Seventy " + units;
                break;
            case "Eight":
                temp = "Eighty " + units;
                break;
            case "Nine":
                temp = "Ninety " + units;
                break;
        
        }
        return temp;
        
    }   
    
    public String returnWordString(int input){
        handleSeperationOfDigits(input);        
        words = processSeperatedDigits(); 
        return words;
    }    
}
