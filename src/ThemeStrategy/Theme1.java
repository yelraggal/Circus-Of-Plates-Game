
package ThemeStrategy;

public class Theme1 implements Themes {
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
      return "/background.jpeg";        
    }

    @Override
    public String clown() {
       return "/clown.png" ;
    }

    @Override
    public String clownrev() {
       return "/clownrev.png";
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
           return "/redball.png";
       }
       else if(s.equals("blue"))
       {      
           return "/blueball.png";
       }
       else if(s.equals("black"))
       {
           return "/blackball.png";
       }
       else
       {
           return"/yellowball.png";
       }

    }    
 
}
