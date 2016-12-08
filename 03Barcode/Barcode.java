import java.util.*;
public class Barcode implements Comparable<Barcode>{
    // instance variables
    //A checkDigit is added to the right of a zip code. The check digit is equal
    //to the sum of the digits of the zip code modulo 10.

    private String _zip;
    private int _checkDigit;

    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	if (zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	try {
	    for (int i = 0;i < 5;i ++){
		Integer.parseInt(zip.substring(i));
	    }
	}catch (NumberFormatException e){
	    
	}
	_zip = zip;
	_checkDigit = checkSum() % 10;
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	return this;
    }


    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int ans = 0;
	for (int i = 0; i < 5; i++){
	    ans += Integer.parseInt(_zip.substring(i));
	}
	return ans;
    }

    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String ans = "|";
        for (int i = 0; i < 5;i++){
            switch (Integer.parseInt(_zip.substring(i))){
            case 0: ans+= "||:::";
	    case 1: ans+= ":::||";
	    case 2: ans+= "::|:|";
	    case 3: ans+= "::||:";
            case 4: ans += ":|::|";
            case 5: ans += ":|:|:";
            case 6: ans += ":||::";
            case 7: ans += "|:::|";
            case 8: ans += "|::|:";
            case 9: ans += "|:|::";
            }
	}
	switch (_checkDigit){
        case 0: ans+= "||:::";
        case 1: ans+= ":::||";
        case 2: ans+= "::|:|";
        case 3: ans+= "::||:";
        case 4: ans += ":|::|";
        case 5: ans += ":|:|:";
        case 6: ans += ":||::";
        case 7: ans += "|:::|";
        case 8: ans += "|::|:";
        case 9: ans += "|:|::";
        }
	return _zip + _checkDigit + ans + "|"; 
    }
    

    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	other.compareTo(Integer.parseInt(_zip + _checkDigit));
    }
    
}