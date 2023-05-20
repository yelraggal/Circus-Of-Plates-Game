
package ThemeStrategy;

public class Theme2 implements Themes{

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
      return "/BackGroundTheme2.jpeg";        
    }

    @Override
    public String clown() {
       return "/player.png" ;
    }

    @Override
    public String clownrev() {
       return "/playerrev.png";
    }

    @Override
    public String GetPlates(String s) {

   if(s.equals("red"))
       {
           return "/blueyellowPlate.png";
       }
       else if(s.equals("blue"))
       {      
           return "/tenniscolourplate.png";
       }
       else if(s.equals("black"))
       {
        return "/blackwhitePlate.png";
       }
       else
       {
           return"/basketcolourPlate.png";
       }
    }

    @Override
    public String GetBalls(String s) {
       if(s.equals("red"))
       {
           return "/volleyball.png";
       }
       else if(s.equals("blue"))
       {      
           return "/tennis ball.png";
       }
       else if(s.equals("black"))
       {
           return "/Football.png";
       }
       else
       {
           return"/basketball.png";
       }
        
    }
}
