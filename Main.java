import java.util.Scanner;

import com.sun.glass.ui.SystemClipboard;

import java.lang.String;

class Main extends CaesarCipher{
    public static void main(String[] args){
        int mState;
        int mShiftingNumber;
        String mText;
        char[] mTextChar;
        Scanner scanner=new Scanner(System.in);
        
        System.out.println("\nCaesar's Shifting Cipher\nplease use uppercase letter only.");
        System.out.println("input initial text: ");
        mText=scanner.nextLine();
        mTextChar=mText.toCharArray();

        System.out.print("input shifting number: ");
        mShiftingNumber=scanner.nextInt();
        
        System.out.print("1.encrypt 2.decrypt");
        mState=scanner.nextInt();

        CaesarCipher caesarCipher=new CaesarCipher(mState, mTextChar, mShiftingNumber);

    }//psvm
}//public class main