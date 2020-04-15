/*
        Dont share this code to anyone, this is for acads purposes only
    Comments are shown to every line of this code, if you have any questions
     or concerns regarding this code, please dont hesitate to contact me.
        
####################################ISSUES######################################
    THIS PROGRAM IS ALMOST DONE, AND IM PLANNING TO ADD MORE FUNCTIONALITIES
                            IN IT, PLEASE BEAR WITH ME..

    Steps:
    1. Encrypt this word using the application (menu choice = 1) 
       the word is "rvxzhnbvvhg".
    2. After Encryption, you will be given a passphrase that you need to 
       decrypt.
    3. The program will automatically return to menu after encryption.
    4. Decrypt the given passphrase (menu choice = 2)

###############################WILD BUG APPEARED################################

    5. Bug appears, it will be fixed when my depression's done.

                                    Coffee?
                                (  )   (   )  )
                                ) (   )  (  (
                                ( )  (    ) )
                                _____________
                               <_____________> ___
                               |             |/ _ \
                               |               | | |
                               |               |_| |
                            ___|             |\___/
                           /    \___________/    \
                           \_____________________/        
################################################################################                
Most of the error catching of this program is finished, im just too lazy to do it
################################################################################
This program uses the built-in methods below:

StringBuilder() and Random()
################################################################################
Good Luck and Have Fun coding, you can do this, laban mo ayaw mog shift hantod
                    sa makaya pa, see you sa industry puhon
                |\ | |  ||\ \ /(_~     |~)|_~|\/||_~|\/||~)|_~|~)
                |~\|_|/\||~\ | ,_)     |~\|__|  ||__|  ||_)|__|~\

                   \ //~\| |    |\ |~)|_~    | ||\ ||/~\| ||_~
                    | \_/\_/    |~\|~\|__    \_/| \||\_X\_/|__

                 (J U S T   L I K E   E V E R Y O N E   E L S E)

#################################TEST PASSPHRASE################################
DECRYPTION
A198711bczx2u or ghAl99Ebn83hzx4iU

ENCRYPTION
rxzcbv 
################################################################################
*/
        
package hellodarknessmyoldfriend;

import java.util.*;

/**
 *
 * @author v4riabl3
 */

public class Hellodarknessmyoldfriend {

    /**
     * @param args the command line arguments
     */
    static void menu(){
        
        System.out.println("**************VCipher**************");
        String passphrase = "";
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("[1] Encrypt Passphrase");
        System.out.println("[2] Decrypt Passphrase");
        System.out.println("[3] Exit");
        System.out.print("Input Action: ");
        choice = scan.nextInt();
        
        switch(choice){
            case 1:
                System.out.print("\033[H\033[2J");                              //clear screen 40-41
                System.out.flush();
                
                System.out.println("********VCipher Encryption********");
                System.out.print("Input Passphrase: ");
                passphrase = scan.next();
                if(passphrase.isEmpty() || passphrase.isBlank()){               //error catching for blank input
                    System.out.println("Please input passphrase");
                }else{
                    vcipher_generate_salt(passphrase);
                }
                break;
            case 2:
                System.out.println("********VCipher Decryption********");
                System.out.print("Input Passphrase: ");
                passphrase = scan.next();
                vcipher_decryption(passphrase);                                 //call vcipher_decryption method
                break;
            case 3:
                System.exit(0);
                break;
        }   
    }
    
    public static void vcipher_generate_salt(String passphrase){                //salt generator
        String salt_characters = "0123456789";
        
        StringBuilder salt = new StringBuilder();
        Random rand = new Random();
        
        
        for(int i = 0;i < passphrase.length();i++){
            int index = (int) (rand.nextFloat() * salt_characters.length());
            
            //salt.append(passphrase.charAt(i),index);
            
            System.out.print(index);
            System.out.print(passphrase.charAt(i) + index);
       }
        System.out.println(salt.toString());
    }
    
    public static void vcipher_decryption(String passphrase){
        StringBuilder rev = new StringBuilder();
        passphrase = passphrase.replaceAll("[0123456789]", "");                 //remove all numbers in the passphrase
        rev.append(passphrase);                                                 //reverse passphrase line 115-116
        rev = rev.reverse();                                                    //rev == reversed passphrase
        int passphrase_length = rev.length() + 1;
        
        if(passphrase_length % 2 == 1){                                         //if even
            String rev_passphrase = rev.toString();                             //convert from string builder data type to string
            rev_passphrase = rev_passphrase.replaceAll("[aeiAEI]", "r");        //step 1
            rev_passphrase = rev_passphrase.replaceAll("[ouOU]", "v");
            
            rev_passphrase.toLowerCase();                                       //convert to lowercase
            System.out.println("Decrypted Passphrase: " + rev_passphrase);
            
            menu();                                                             // return to menu after
        }else{
            String rev_passphrase = rev.toString();                             //convert from string builder data type to string
            rev_passphrase = rev_passphrase.replaceAll("[aeiAEI]", "v");        //step 1
            rev_passphrase = rev_passphrase.replaceAll("[ouOU]", "r");
            
            rev_passphrase.toLowerCase();                                       //convert to lowercase
            System.out.println("Decrypted Passphrase: " + rev_passphrase);

            menu();                                                             // return to menu after
        }
    }
        
    public static void vcipher_encryption(String passphrase){                   
        String odd_key_pattern1 = "aeiAEI";
        String odd_key_pattern2  = "ouOU";
        
        String even_key_pattern1 = "ouOU";
        String even_key_pattern2  = "aeiAEI";
        
        Random ran = new Random();
        
        int passphrase_length = passphrase.length() + 1; 
           
        if(passphrase_length % 2 == 1){                                         //if value is even else odd
            
            char pattern1 = even_key_pattern1.charAt(ran.nextInt(even_key_pattern1.length()));
            char pattern2 = even_key_pattern2.charAt(ran.nextInt(even_key_pattern2.length()));
            
            StringBuilder rev = new StringBuilder();                            //called StringBuilder class for reversing to convert String to StringBuilder class
            
            rev.append(passphrase);                                             //append passphrase
            rev = rev.reverse();                                                //then reverse
            
            String rev_final = rev.toString();
            rev_final = rev_final.replaceAll("r", Character.toString(pattern1));
            rev_final = rev_final.replaceAll("v", Character.toString(pattern2));

            char final_passphrase = rev_final.charAt(ran.nextInt(rev_final.length()));
            rev.append(final_passphrase);                                       //append to convert StringBuilder to String
            
            String rev_f = rev.toString();
            System.out.println("Encrypted Passphrase: " + rev_f);
            
            menu();                                                             //return to menu after encryption  
        }else{
            char pattern1 = odd_key_pattern1.charAt(ran.nextInt(odd_key_pattern1.length()));
            char pattern2 = odd_key_pattern2.charAt(ran.nextInt(odd_key_pattern2.length()));
            
            StringBuilder rev = new StringBuilder();
            rev.append(passphrase);
            rev = rev.reverse();
            String rev_final = rev.toString();  
            rev_final = rev_final.replaceAll("r", Character.toString(pattern1));
            rev_final = rev_final.replaceAll("v", Character.toString(pattern2));

            char final_passphrase = rev_final.charAt(ran.nextInt(rev_final.length()));
            rev.append(final_passphrase);
            
            String rev_f = rev.toString();
            System.out.println("Encrypted Passphrase: " + rev_f);
            
            //rvxzhnbvvhg
            menu(); 
        }
        
    }
    public static void main(String[] args) {
        menu();
      
    }   

}