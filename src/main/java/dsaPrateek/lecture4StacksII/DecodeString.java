package dsaPrateek.lecture4StacksII;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        char[] chars = s.toCharArray ();
        Stack<String> characterStack = new Stack<> ();
        String temp = "",appendedStr ="",decodedStr="";
        characterStack.push(chars[0]+"");
        for(int i = 1; i<chars.length;i++){
            if(chars[i] != ']'){
                characterStack.push(chars[i]+"");
            }else{
                while(!characterStack.isEmpty()&&!characterStack.peek().equals ("[")){
                    temp = characterStack.pop() + temp;
                }
                characterStack.pop();
                int repeat = Integer.parseInt(characterStack.pop());
                for(int j=0; j<repeat;j++){
                    appendedStr = appendedStr +  temp;
                }
                characterStack.push(appendedStr);
                temp = "";
                appendedStr = "";

            }
        }
        while(!characterStack.isEmpty ()){
            decodedStr = characterStack.pop()+decodedStr;
        }
        return  decodedStr;
    }

    public static void main(String[] args) {
        DecodeString decode = new DecodeString();
        String decodedStr = decode.decodeString ("3[a2[c]]");
        System.out.println (decodedStr);
    }
}
