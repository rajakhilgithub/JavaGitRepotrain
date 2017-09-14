
import java.util.*;

/**
 *
 * @author Peggy Fisher
 */
public class FindName {
public static Scanner sn=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] names = {{"Mickey", "Mouse"},
            {"Donald", "Duck"},
            {"Goofy", "Pluto"},
            {"Snow", "White"},
            {"James", "Bond"},
            {"Doc", "Sneezy"},
            {"Scotty", "Jimmy"},
            {"Peggy", "Sandy"},
            {"Joe", "Sean"},
            {"Alice", "Mackenzie"},
            {"Reshmi", "Vasant"},
            {"Steve", "Rae"}};
        //ask the user to enter a name, then pass the name and array to 
        //the method to search for that name. 
     System.out.println("Guess a name:");
     String name=sn.nextLine();
     boolean r=Findname(names,name);
     if(r) {
    	 System.out.println(name+" Found");
     }else {
    	 System.out.println(name+" Not Found");
     }
    }
    public static boolean Findname(String[][] namelist,String name) {
    	boolean res=false;
    	for(int i=0;i<namelist.length;i++) {
    		for(int j=0;j<namelist[i].length;j++) {
    			if(namelist[i][j].equalsIgnoreCase(name)) {
    				res=true;
    			}
    		}
    	}
    	return res;
    }
    }
    

