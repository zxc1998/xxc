package aa;

public class aa {
	
	
	
	
		int a =1;
		double  d =2.0;
		void show() {
			System.out.println("Class A: a="+a +"\td="+d);
		}  
		public static void main(String[] args) {
			 b aaa = new b ();
               aaa.show();
		}	
		
	}
	class b extends aa{
		String d="Java program.";
		void show(){
		super.show( );
		System.out.println("Class B: a="+a +"\td="+d);
		}
	}

