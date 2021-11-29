package setting;

import java.io.IOException;
import java.util.Vector;

public class MOption {

    MOption(){

    }

    void opt() {
        try {
            String str = null;
            switch (str) {
            case "list":
                list();
                break;
            case "kick":
                kick();
                break;
            default:
                System.out.println("올바른 option을 선택해주세요");
                opt();
            }

        } catch (IOException ie) {
            opt();
        }
    }
    void list(){
        
        for(OneCliMod oneCliMod : this.v){

        }
    }
    void kick(){
        String str = inputTar get("");
        if (str == null){
            pln("");
            kick();
        } else {
            for (OneCliMod oneCliMod : this.v){
                if (str.equals(oneCliMod.chatId)){
                    this.v.remove(oneCliMod);
                    MOption.on_off = 0;
                    return;
                }
            }
        }
    }

    void p(String str){
        System.out.print(str);
    }
    void pln(String str){
        System.out.println(str);
    }

}