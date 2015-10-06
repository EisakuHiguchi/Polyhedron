package icosa;

import java.io.*;

public class icosa_main {

	
	public static void main(String[] args) {
		Icosa ico = new Icosa();
		
		icosa_main func = new icosa_main();
		func.dubug_AllPoint(ico);
		
		System.out.println("fin");
	}
	
	
	private void dubug_AllPoint(Icosa ico) {
		try {
			FileWriter fw = new FileWriter("data.txt");
			
//			for(Pointer3D p: ico.getAllPoint()) {
			for(int i = 0; i < ico.getAllPoint().size(); i++) {
				Pointer3D p = ico.getAllPoint().get(i);
				
				double[] d = p.getPoint();
				fw.write(d[0] + " " + d[1] + " " + d[2] + "\n");
				
//				if((i % 2 == 0) & (i > 0)) {
//					double[] temp = ico.getAllPoint().get(i - 1).getPoint(); 
//					fw.write(temp[0] + " " + temp[1] + " " + temp[2] + "\n");
//				}
				
				for(int j = 0; j < ico.allUnit.size(); j++) {
					Pointer3D e = ico.allUnit.get(j);
					double[] ep =  e.getPoint();
					fw.write(ep[0] + " " + ep[1] + " " + ep[2] + "\n");
					fw.write(d[0] + " " + d[1] + " " + d[2] + "\n");
				}
				
			}
			fw.close();
		} catch (Exception e) {
			
		}
	}
	
}
