import java.math.*;

public class CaesarCipher{
    private int state;
    private char[] textChar;
    private int textCharLength;
    private int shift;

    private char[] baseLetter = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private char[] key=new char[26];

    CaesarCipher(){
        //empty Constructor required.
    }

    CaesarCipher(int state, char[] textChar, int shift){
        this.shift=shift;
        this.textChar=textChar;
        this.state=state;
        this.textCharLength=textChar.length;

        if(state==1){
            encrypt();
        }else if(state==2){
            decrypt();
        }    
    }

    private void encrypt(){
        int newShift;
        for(int i=0;i<26;i++){
            newShift=Math.abs((i+shift)%26);
            key[i]=baseLetter[newShift];
        }
        
        magic();
    }

    private void decrypt(){
        int newShift;
        int errorControl;
        for(int i=0;i<26;i++){
            if(i-shift<0){
                errorControl=i+26-shift;
            }else{
                errorControl=i-shift;
            }
            newShift=Math.abs(errorControl)%26;
            key[i]=baseLetter[newShift];
        }

        magic();
    }

    private void magic(){
        int counter=0;
        for(int i=0;i<textCharLength;i++){
            while(textChar[i]!=baseLetter[counter]){
                counter++;
            }

            textChar[i]=key[counter];
            counter=0;
        }

        for(int i=0;i<textCharLength;i++){
            System.out.print(textChar[i]);
        }
    }
}//class cipher