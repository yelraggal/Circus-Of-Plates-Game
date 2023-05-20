/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThemeStrategy;

/**
 *
 * @author Moham
 */
public class Theme3 implements Themes{
    @Override
    public String getLeftHand() {
      return "/stickleft.png";
    }

    @Override
    public String getRightHand() {
     return "/stickright.png";       
    }

    @Override
    public String getbackgroud() {
      return "/bck2.jpeg";         
    }

    @Override
    public String clown() {
      return "/cl33.png" ;
    }

    @Override
    public String clownrev() {
       return "/cl33.png" ;
    }

    @Override
    public String GetPlates(String s) {
    if(s.equals("red"))
       {
           return "/redPlate.png";
       }
       else if(s.equals("blue"))
       {      
           return "/bluePlate.png";
       }
       else if(s.equals("black"))
       {
           return "/blackPlate.png";
       }
       else
       {
           return"/yellowPlate.png";
       }

    }

    @Override
    public String GetBalls(String s) {
  if(s.equals("red"))
       {
           return "/red chris.png";
       }
       else if(s.equals("blue"))
       {      
           return "/blue chris.png";
       }
       else if(s.equals("black"))
       {
           return "/black chris.png";
       }
       else
       {
           return"/yellow chris.png";
       }

    }   
    
    
}
