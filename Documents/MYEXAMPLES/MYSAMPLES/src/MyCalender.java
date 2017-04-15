import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;*/


public class MyCalender {
	public int y ;
public static void main(String args[]){
 //code for getting week before current date
/* Calendar calendar = Calendar.getInstance();
 System.out.println(calendar.get(Calendar.DATE));
 calendar.add(Calendar.DATE, -7);
 System.out.println(calendar.get(Calendar.DATE)); 
 System.out.println(calendar.get(Calendar.MONTH));
 System.out.println(calendar.get(Calendar.YEAR));
 calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),0,0,0);
 System.out.println(calendar.getTime());*/
	/* Map<String, String> env = System.getenv();
     for (String envName : env.keySet()) {
         System.out.format("%s=%s%n",
                           envName,
                           env.get(envName));
     }*/
/*
String name = "ifodihfuidhfdishij";
String[] splitName = name.split(";");
System.out.println(splitName[0]);
*/

	


	   
	        /*Display display = new Display();
	        Shell shell = new Shell(display);

	        final Text text = new Text(shell, SWT.BORDER);
	        text.addVerifyListener(new VerifyListener() {

	        @Override
	        public void verifyText(VerifyEvent e) {
	            e.doit = Character.isDigit(e.character)
	            || Character.isWhitespace(e.character)
	            || e.keyCode == SWT.ARROW_LEFT
	            || e.keyCode == SWT.ARROW_RIGHT
	            || e.keyCode == SWT.BS;
	        }
	        });
	        text.setSize(200, 20);
	        shell.pack();
	        shell.open();
	        while (!shell.isDisposed()) {
	            if (!display.readAndDispatch())
	                display.sleep();
	        }
	        display.dispose();
*/	   

/*String str1= "00002ae80008535030323838343700000770726f76696465000200000055000000005409ff24ca43b51b54798378be7e962d545aa127fa2fca7c63098165a7619b2c3109f117c81fb30b0e0a82628b53f2485401bf08a8bfbcf83f25f117c817f2485409f117c817f2485409f116ce17f24854030000000841435a03737543440500000000000000000000000000000600000001060600000000";
String str2 = "00002fce0008535030323838343700000750524f56494445000200000055000000005409fce2ca43b51b5459a3589e5eb60d545aa127fa2fca7c6309a1458741bb0c1109f117c81fc2d45fc3f89a9ff0f2485401fee2bbbefdfa1249f117c817f2485409f117c817f2485409f116ce17f248540300000008309c0bca098d57e70500000000000000000000000000000600000001060600000000";
System.out.println(str1.equals(str2));*/
/*Map<BigDecimal,String> testEmptyMap = new HashMap<BigDecimal,String>();
if(testEmptyMap.containsKey(12345.00)){
	System.out.println("true");
}
else{
	System.out.println("false");
}
Collection<String> num1 = new ArrayList<String>();
num1.add("abcd123");
num1.add("1234");
num1.add("ertud132");
num1.add("34567");
num1.add("pasham");
num1.add("45678");
List<Double> num2 = new ArrayList<Double>();
num2.add(11.45);
num2.add(8.45);
num2.add(10.00);
num2.add(2.45);
num2.add(2.45);
num2.add(3.22);
/*if(num2.containsAll(num1)){System.out.println("true");
}
else{System.out.println(false);}*/
/*BigDecimal num1 = new BigDecimal(404275);
BigDecimal num2 = new BigDecimal(404275.0);
System.out.println(num1.compareTo(num2));*/

/*Collections.sort(num2, new Comparator<Double>() {
	public int compare(Double m1, Double m2) {
		return m1.compareTo(m2);
	}
});	
for(Double val:num2){
System.out.println(val);
}*/
	/*String name = "/cerner/sp028847/programfiles/testdata(2).dareport";
	System.out.println(name.toLowerCase().endsWith(".dareport"));*/
	/*String name = "helloworld?";
	String pattern = "[<|>|*|?|:|/\\|]";
	Pattern r = Pattern.compile(pattern);
	Matcher m = r.matcher(name);
	if (m.find( )) {
        System.out.println("Found value: " + m.group(0) );
     } else {
        System.out.println("NO MATCH");
     }
	*/

MyCalender cal = new MyCalender();
cal.y = 0;
cal.setVal(10);
System.out.println(cal.y);

	
}

void setVal(int x){
	y = x;
}
int getVal(){
	return y;
}
}
